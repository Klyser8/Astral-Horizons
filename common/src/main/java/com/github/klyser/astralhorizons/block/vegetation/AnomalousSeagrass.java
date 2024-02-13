package com.github.klyser.astralhorizons.block.vegetation;

import com.github.klyser.astralhorizons.block.CloakedBlock;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Tuple;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SeagrassBlock;
import net.minecraft.world.level.block.TallSeagrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import java.util.Map;

public class AnomalousSeagrass extends SeagrassBlock implements CloakedBlock {

    private final Block cloakBlock;
    public AnomalousSeagrass(Properties properties, Block cloakBlock) {
        super(properties);
        this.cloakBlock = cloakBlock;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        BlockState blockState = AHBlocks.ANOMALOUS_TALL_SEAGRASS.get().defaultBlockState();
        BlockState blockState2 = blockState.setValue(TallSeagrassBlock.HALF, DoubleBlockHalf.UPPER);
        BlockPos blockPos = pos.above();
        if (level.getBlockState(blockPos).is(Blocks.WATER)) {
            level.setBlock(pos, blockState, Block.UPDATE_ALL);
            level.setBlock(blockPos, blockState2, Block.UPDATE_ALL);
        }
    }

    @Override
    public Tuple<Block, Block> getBlockTuple() {
        return new Tuple<>(this, cloakBlock);
    }

    @Override
    public Map<BlockState, BlockState> getBlockStateCloaks() {
        return Map.of(defaultBlockState(), cloakBlock.defaultBlockState());
    }
}
