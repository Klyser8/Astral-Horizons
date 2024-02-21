package com.github.klyser.astralhorizons.block.vegetation;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class ScuraneLights extends AnomalousBushBlock {
    public ScuraneLights(Properties properties, Block mayPlaceOn) {
        super(properties, mayPlaceOn);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockPos = pos.above();
        return this.mayPlaceOn(level.getBlockState(blockPos), level, blockPos);
    }
}
