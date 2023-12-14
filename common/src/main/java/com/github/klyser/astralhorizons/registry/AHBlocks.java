package com.github.klyser.astralhorizons.registry;

import com.github.klyser.astralhorizons.block.AHFallingBlock;
import com.github.klyser.astralhorizons.block.AnomalousGrassBlock;
import com.github.klyser.astralhorizons.block.AnomalousStoneBricks;
import com.github.klyser.astralhorizons.block.HorizontalDirectionalSlabBlock;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.function.Supplier;

import static com.github.klyser.astralhorizons.platform.CommonPlatformHelper.registerBlock;

public class AHBlocks {

    public static void init() {}

    public static final Supplier<Block> ANOMALOUS_DIRT = registerBlock("anomalous_dirt", () ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.DIRT)
                    .strength(1.0f)));
    public static final Supplier<Block> ANOMALOUS_GRASS_BLOCK = registerBlock("anomalous_grass_block", () ->
            new AnomalousGrassBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.GRASS_BLOCK)
                    .strength(1.0f)));
    public static final Supplier<Block> ANOMALOUS_STONE = registerBlock("anomalous_stone", () ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> ANOMALOUS_STONE_SLAB = registerBlock("anomalous_slab", () ->
            new SlabBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_SLAB)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> ANOMALOUS_STONE_STAIRS = registerBlock("anomalous_stairs", () ->
            new StairBlock(ANOMALOUS_STONE.get().defaultBlockState(), BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_STAIRS)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> ANOMALOUS_STONE_PRESSURE_PLATE = registerBlock("anomalous_pressure_plate", () ->
            new PressurePlateBlock(AHBlockSetTypes.ANOMALOUS_STONE, BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_PRESSURE_PLATE)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> ANOMALOUS_STONE_BUTTON = registerBlock("anomalous_button", () ->
            new ButtonBlock(AHBlockSetTypes.ANOMALOUS_STONE, 20, BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_BUTTON)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> ANOMALOUS_COBBLESTONE = registerBlock("anomalous_cobblestone", () ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.COBBLESTONE)
                    .strength(4.5f, 6.0f)));
    public static final Supplier<Block> ANOMALOUS_COBBLESTONE_SLAB = registerBlock("anomalous_cobblestone_slab", () ->
            new SlabBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.COBBLESTONE_SLAB)
                    .strength(4.5f, 6.0f)));
    public static final Supplier<Block> ANOMALOUS_COBBLESTONE_STAIRS = registerBlock("anomalous_cobblestone_stairs", () ->
            new StairBlock(ANOMALOUS_COBBLESTONE.get().defaultBlockState(), BlockBehaviour.Properties
                    .ofFullCopy(Blocks.COBBLESTONE_STAIRS)
                    .strength(4.5f, 6.0f)));
    public static final Supplier<Block> ANOMALOUS_COBBLESTONE_WALL = registerBlock("anomalous_cobblestone_wall", () ->
            new WallBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.COBBLESTONE_WALL)
                    .strength(4.5f, 6.0f)));
    public static final Supplier<Block> ANOMALOUS_STONE_BRICKS = registerBlock("anomalous_stone_bricks", () ->
            new AnomalousStoneBricks(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_BRICKS)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> ANOMALOUS_STONE_BRICK_SLAB = registerBlock("anomalous_stone_brick_slab", () ->
            new HorizontalDirectionalSlabBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_BRICK_SLAB)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> ANOMALOUS_STONE_BRICK_STAIRS = registerBlock("anomalous_stone_brick_stairs", () ->
            new StairBlock(ANOMALOUS_STONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_BRICK_STAIRS)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> ANOMALOUS_STONE_BRICK_WALL = registerBlock("anomalous_stone_brick_wall", () ->
            new WallBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_BRICK_WALL)
                    .forceSolidOn()
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> CHISELED_ANOMALOUS_STONE_BRICKS = registerBlock("chiseled_anomalous_stone_bricks", () ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CHISELED_STONE_BRICKS)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> ANOMALOUS_SAND = registerBlock("anomalous_sand", () -> //TODO create class extending FallingBlock
            new AHFallingBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.SAND)
                    .strength(0.75f)));
    public static final Supplier<Block> ANOMALOUS_LOG = registerBlock("anomalous_log", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.OAK_LOG)
                    .strength(3.0f)));
    public static final Supplier<Block> ANOMALOUS_WOOD = registerBlock("anomalous_wood", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.OAK_WOOD)
                    .strength(3.0f)));
    public static final Supplier<Block> ANOMALOUS_LEAVES = registerBlock("anomalous_leaves", () ->
            new LeavesBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.OAK_LEAVES)
                    .strength(0.3f)
                    .randomTicks()));

}
