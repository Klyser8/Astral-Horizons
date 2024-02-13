package com.github.klyser.astralhorizons.block.vegetation;

import com.github.klyser.astralhorizons.block.CloakedBlock;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallSeagrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import java.util.Hashtable;
import java.util.Map;

public class AnomalousTallSeagrass extends TallSeagrassBlock implements CloakedBlock {

    private final Block cloakBlock;
    public AnomalousTallSeagrass(Properties properties, Block cloakBlock) {
        super(properties);
        this.cloakBlock = cloakBlock;
    }

    @Override
    public Tuple<Block, Block> getBlockTuple() {
        return new Tuple<>(this, cloakBlock);
    }

    @Override
    public Map<BlockState, BlockState> getBlockStateCloaks() {
        Map<BlockState, BlockState> cloaks = new Hashtable<>();
        for (BlockState blockState : getStateDefinition().getPossibleStates()) {
            if (blockState.getValue(HALF) == DoubleBlockHalf.UPPER) {
                cloaks.put(blockState, cloakBlock.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER));
            } else {
                cloaks.put(blockState, cloakBlock.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER));
            }
        }
        return cloaks;
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return new ItemStack(AHBlocks.ANOMALOUS_SEAGRASS.get());
    }
}
