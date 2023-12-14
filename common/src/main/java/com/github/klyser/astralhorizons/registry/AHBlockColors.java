package com.github.klyser.astralhorizons.registry;

import net.minecraft.client.color.block.BlockColors;
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
        if (pos == null || !(blockAndTintGetter instanceof Level level))
            return 0xFFFFFF;
        return 0x00FF00;
    }

    public static Block[] getAffectedBlocks() {
        return new Block[]{
                AHBlocks.ANOMALOUS_DIRT.get(),
                AHBlocks.ANOMALOUS_GRASS_BLOCK.get(),
                AHBlocks.ANOMALOUS_STONE.get(),
                AHBlocks.ANOMALOUS_STONE_SLAB.get(),
                AHBlocks.ANOMALOUS_STONE_STAIRS.get(),
                AHBlocks.ANOMALOUS_STONE_PRESSURE_PLATE.get(),
                AHBlocks.ANOMALOUS_STONE_BUTTON.get(),
                AHBlocks.ANOMALOUS_COBBLESTONE.get(),
                AHBlocks.ANOMALOUS_COBBLESTONE_SLAB.get(),
                AHBlocks.ANOMALOUS_COBBLESTONE_STAIRS.get(),
                AHBlocks.ANOMALOUS_COBBLESTONE_WALL.get()
        };
    }

}
