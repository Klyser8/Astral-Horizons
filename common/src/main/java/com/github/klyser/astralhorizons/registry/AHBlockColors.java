package com.github.klyser.astralhorizons.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

/**
 * This class is used by both the Forge and Fabric client classes to aid in registering block colors.
 */
public class AHBlockColors {

    public static int getBlockColor(BlockState state, BlockAndTintGetter blockAndTintGetter, BlockPos pos, int tintIndex) {
        if (pos == null || !(blockAndTintGetter instanceof Level level)) {
            return 0xFFFFFF;
        }
//        if (level.getBiome(pos).is())
        return 0x00FF00;
    }

    public static Block[] getAffectedBlocks() {
        return new Block[]{
                AHBlocks.ANOMADIRT.get(),
                AHBlocks.ANOMAGRASS_BLOCK.get(),
                AHBlocks.ANOMASTONE.get(),
                AHBlocks.ANOMASTONE_SLAB.get(),
                AHBlocks.ANOMASTONE_STAIRS.get(),
                AHBlocks.ANOMASTONE_PRESSURE_PLATE.get(),
                AHBlocks.ANOMASTONE_BUTTON.get(),
                AHBlocks.COBBLED_ANOMASTONE.get(),
                AHBlocks.COBBLED_ANOMASTONE_SLAB.get(),
                AHBlocks.COBBLED_ANOMASTONE_STAIRS.get(),
                AHBlocks.COBBLED_ANOMASTONE_WALL.get()
        };
    }

}
