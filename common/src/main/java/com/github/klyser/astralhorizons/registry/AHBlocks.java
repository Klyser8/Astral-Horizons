package com.github.klyser.astralhorizons.registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

import static com.github.klyser.astralhorizons.platform.CommonPlatformHelper.registerBlock;

public class AHBlocks {

    public static void init() {}

    public static final Supplier<Block> ANOMALOUS_DIRT = registerBlock("anomalous_dirt", () ->
            new Block(BlockBehaviour.Properties
                    .copy(Blocks.DIRT)
                    .strength(1.0f)));
    public static final Supplier<Block> ANOMALOUS_GRASS_BLOCK = registerBlock("anomalous_grass_block", () ->
            new Block(BlockBehaviour.Properties
                    .copy(Blocks.GRASS_BLOCK)
                    .strength(1.0f)));

    public static final Supplier<Block> ANOMALOUS_STONE = registerBlock("anomalous_stone", () ->
            new Block(BlockBehaviour.Properties
                    .copy(Blocks.STONE)
                    .strength(4.0f, 6.0f)));

    public static final Supplier<Block> ANOMALOUS_SAND = registerBlock("anomalous_sand", () ->
            new Block(BlockBehaviour.Properties
                    .copy(Blocks.SAND)
                    .strength(0.75f)));

    public static final Supplier<Block> ANOMALOUS_LOG = registerBlock("anomalous_log", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties
                    .copy(Blocks.OAK_LOG)
                    .strength(3.0f)));

    public static final Supplier<Block> ANOMALOUS_LEAVES = registerBlock("anomalous_leaves", () ->
            new LeavesBlock(BlockBehaviour.Properties
                    .copy(Blocks.OAK_LEAVES)
                    .strength(0.3f)
                    .randomTicks()));

}
