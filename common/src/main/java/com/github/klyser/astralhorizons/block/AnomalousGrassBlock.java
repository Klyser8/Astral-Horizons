package com.github.klyser.astralhorizons.block;

import com.github.klyser.astralhorizons.registry.AHBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.SpreadingSnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LightEngine;
import org.jetbrains.annotations.NotNull;

public class AnomalousGrassBlock extends SpreadingSnowyDirtBlock {
    public static final MapCodec<AnomalousGrassBlock> CODEC = simpleCodec(AnomalousGrassBlock::new);
    public AnomalousGrassBlock(Properties properties) {
        super(properties);
    }

    private static boolean canBeGrass(BlockState state, LevelReader levelReader, BlockPos pos) {
        BlockPos blockPos = pos.above();
        BlockState blockState = levelReader.getBlockState(blockPos);
        if (blockState.is(Blocks.SNOW) && blockState.getValue(SnowLayerBlock.LAYERS) == 1) {
            return true;
        }
        if (blockState.getFluidState().getAmount() == 8) {
            return false;
        }
        int i = LightEngine.getLightBlockInto(levelReader, state, pos, blockState, blockPos, Direction.UP, blockState.getLightBlock(levelReader, blockPos));
        return i < levelReader.getMaxLightLevel();
    }

    private static boolean canPropagate(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockPos = pos.above();
        return canBeGrass(state, level, pos) && !level.getFluidState(blockPos).is(FluidTags.WATER);
    }

    @Override
    protected @NotNull MapCodec<? extends SpreadingSnowyDirtBlock> codec() {
        return CODEC;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!AnomalousGrassBlock.canBeGrass(state, level, pos)) {
            level.setBlockAndUpdate(pos, AHBlocks.ANOMADIRT.get().defaultBlockState());
            return;
        }
        if (level.getMaxLocalRawBrightness(pos.above()) >= 9) {
            BlockState blockState = this.defaultBlockState();
            for (int i = 0; i < 4; ++i) {
                BlockPos blockPos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                if (!level.getBlockState(blockPos).is(AHBlocks.ANOMADIRT.get()) || !AnomalousGrassBlock.canPropagate(blockState, level, blockPos)) continue;
                level.setBlockAndUpdate(blockPos, blockState.setValue(SNOWY, level.getBlockState(blockPos.above()).is(Blocks.SNOW)));
            }
        }
    }
}
