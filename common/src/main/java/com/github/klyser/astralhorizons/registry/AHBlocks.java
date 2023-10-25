package com.github.klyser.astralhorizons.registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

import static com.github.klyser.astralhorizons.platform.CommonPlatformHelper.registerBlock;

public class AHBlocks {

    public static void init() {}

    public static final Supplier<Block> ANOMALOUS_DIRT = registerBlock("anomalous_dirt", () ->
            new Block(BlockBehaviour.Properties
                    .copy(Blocks.DIRT)
                    .strength(1.0f)
                    .dynamicShape()));

}
