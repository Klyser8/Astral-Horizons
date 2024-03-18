package com.github.klyser.astralhorizons.block.vegetation;

import com.github.klyser.astralhorizons.block.CloakedBlock;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

public class ScuraneLeaves extends LeavesBlock implements BonemealableBlock, CloakedBlock {
    private Block cloakBlock;
    public ScuraneLeaves(Properties properties, Block cloakBlock) {
        super(properties);
        this.cloakBlock = cloakBlock;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        boolean isBlockBelowNotScuraneLights = !level.getBlockState(pos.below()).is(AHBlocks.SCURANE_LIGHTS.get());
        boolean isBlockBelowEmpty = level.isEmptyBlock(pos.below());
        return isBlockBelowNotScuraneLights && isBlockBelowEmpty;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        BlockPos below = pos.below();
        level.setBlock(below, AHBlocks.SCURANE_LIGHTS.get().defaultBlockState(), LeavesBlock.UPDATE_ALL);
        BoneMealItem.addGrowthParticles(level, below, 20);
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
