package com.github.klyser.astralhorizons.block.vegetation;

import com.github.klyser.astralhorizons.registry.AHBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ScuraneLeaves extends LeavesBlock implements BonemealableBlock {
    public ScuraneLeaves(Properties properties) {
        super(properties);
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


}
