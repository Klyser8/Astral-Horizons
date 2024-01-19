package com.github.klyser.astralhorizons.registry;

import com.github.klyser.astralhorizons.block.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.List;
import java.util.function.Supplier;

import static com.github.klyser.astralhorizons.platform.CommonPlatformHelper.registerBlock;

public class AHBlocks {

    public static void init() {}

    public static final Supplier<Block> TEST_TINTED_BLOCK = registerBlock("test_tinted_block", () ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> ANOMADIRT = registerBlock("anomadirt", () ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.DIRT)
                    .strength(1.0f)));
    public static final Supplier<Block> ANOMAGRASS_BLOCK = registerBlock("anomagrass_block", () ->
            new AnomalousGrassBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.GRASS_BLOCK)
                    .strength(1.0f)));
    public static final Supplier<Block> ANOMASTONE = registerBlock("anomastone", () ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> LUTIEL = registerBlock("lutiel", () ->
            new AHFallingBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.GRAVEL)
                    .strength(0.9f)));
    public static final Supplier<Block> ANOMASTONE_SLAB = registerBlock("anomastone_slab", () ->
            new SlabBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_SLAB)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> ANOMASTONE_STAIRS = registerBlock("anomastone_stairs", () ->
            new AHStairBlock(ANOMASTONE.get().defaultBlockState(), BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_STAIRS)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> ANOMASTONE_PRESSURE_PLATE = registerBlock("anomastone_pressure_plate", () ->
            new AHPressurePlateBlock(AHBlockSetType.ANOMASTONE, BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_PRESSURE_PLATE)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> ANOMASTONE_BUTTON = registerBlock("anomastone_button", () ->
            new AHButtonBlock(AHBlockSetType.ANOMASTONE, 20, BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_BUTTON)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> COBBLED_ANOMASTONE = registerBlock("cobbled_anomastone", () ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.COBBLESTONE)
                    .strength(4.5f, 6.0f)));
    public static final Supplier<Block> COBBLED_ANOMASTONE_SLAB = registerBlock("cobbled_anomastone_slab", () ->
            new SlabBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.COBBLESTONE_SLAB)
                    .strength(4.5f, 6.0f)));
    public static final Supplier<Block> COBBLED_ANOMASTONE_STAIRS = registerBlock("cobbled_anomastone_stairs", () ->
            new AHStairBlock(COBBLED_ANOMASTONE.get().defaultBlockState(), BlockBehaviour.Properties
                    .ofFullCopy(Blocks.COBBLESTONE_STAIRS)
                    .strength(4.5f, 6.0f)));
    public static final Supplier<Block> COBBLED_ANOMASTONE_WALL = registerBlock("cobbled_anomastone_wall", () ->
            new WallBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.COBBLESTONE_WALL)
                    .strength(4.5f, 6.0f)));
    public static final Supplier<Block> ANOMASTONE_BRICKS = registerBlock("anomastone_bricks", () ->
            new AnomalousStoneBricks(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_BRICKS)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> ANOMASTONE_BRICK_SLAB = registerBlock("anomastone_brick_slab", () ->
            new HorizontalDirectionalSlabBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_BRICK_SLAB)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> ANOMASTONE_BRICK_STAIRS = registerBlock("anomastone_brick_stairs", () ->
            new AHStairBlock(ANOMASTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_BRICK_STAIRS)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> ANOMASTONE_BRICK_WALL = registerBlock("anomastone_brick_wall", () ->
            new WallBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_BRICK_WALL)
                    .forceSolidOn()
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> CHISELED_ANOMASTONE_BRICKS = registerBlock("chiseled_anomastone_bricks", () ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CHISELED_STONE_BRICKS)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> CHLORITE = registerBlock("chlorite", () ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> CHLORITE_SLAB = registerBlock("chlorite_slab", () ->
            new SlabBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_SLAB)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> CHLORITE_STAIRS = registerBlock("chlorite_stairs", () ->
            new AHStairBlock(CHLORITE.get().defaultBlockState(), BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_STAIRS)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> CHLORITE_WALL = registerBlock("chlorite_wall", () ->
            new WallBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.COBBLESTONE_WALL)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> CHLORITE_BRICKS = registerBlock("chlorite_bricks", () ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.NETHER_BRICKS)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> CHLORITE_BRICK_SLAB = registerBlock("chlorite_brick_slab", () ->
            new SlabBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.NETHER_BRICK_SLAB)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> CHLORITE_BRICK_STAIRS = registerBlock("chlorite_brick_stairs", () ->
            new AHStairBlock(CHLORITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .ofFullCopy(Blocks.NETHER_BRICK_STAIRS)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> CHLORITE_BRICK_WALL = registerBlock("chlorite_brick_wall", () ->
            new WallBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.NETHER_BRICK_WALL)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> SIDEROCK = registerBlock("siderock", () ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> SIDEROCK_SLAB = registerBlock("siderock_slab", () ->
            new SlabBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_SLAB)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> SIDEROCK_STAIRS = registerBlock("siderock_stairs", () ->
            new AHStairBlock(SIDEROCK.get().defaultBlockState(), BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_STAIRS)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> SIDEROCK_WALL = registerBlock("siderock_wall", () ->
            new WallBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.COBBLESTONE_WALL)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> SIDEROCK_BRICKS = registerBlock("siderock_bricks", () ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.NETHER_BRICKS)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> SIDEROCK_BRICK_SLAB = registerBlock("siderock_brick_slab", () ->
            new SlabBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.NETHER_BRICK_SLAB)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> SIDEROCK_BRICK_STAIRS = registerBlock("siderock_brick_stairs", () ->
            new AHStairBlock(SIDEROCK_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .ofFullCopy(Blocks.NETHER_BRICK_STAIRS)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> SIDEROCK_BRICK_WALL = registerBlock("siderock_brick_wall", () ->
            new WallBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.NETHER_BRICK_WALL)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> AURANITE = registerBlock("auranite", () ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> AURANITE_SLAB = registerBlock("auranite_slab", () ->
            new SlabBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_SLAB)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> AURANITE_STAIRS = registerBlock("auranite_stairs", () ->
            new AHStairBlock(AURANITE.get().defaultBlockState(), BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_STAIRS)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> AURANITE_WALL = registerBlock("auranite_wall", () ->
            new WallBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.COBBLESTONE_WALL)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> AURANITE_BRICKS = registerBlock("auranite_bricks", () ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.NETHER_BRICKS)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> AURANITE_BRICK_SLAB = registerBlock("auranite_brick_slab", () ->
            new SlabBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.NETHER_BRICK_SLAB)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> AURANITE_BRICK_STAIRS = registerBlock("auranite_brick_stairs", () ->
            new AHStairBlock(AURANITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .ofFullCopy(Blocks.NETHER_BRICK_STAIRS)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> AURANITE_BRICK_WALL = registerBlock("auranite_brick_wall", () ->
            new WallBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.NETHER_BRICK_WALL)
                    .strength(4.0f, 6.0f)));
    public static final Supplier<Block> ANOMASAND = registerBlock("anomasand", () ->
            new AHFallingBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.SAND)
                    .strength(0.75f)));
    public static final Supplier<Block> ANOMASANDSTONE = registerBlock("anomasandstone", () ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.SANDSTONE)
                    .strength(1.3f)));
    public static final Supplier<Block> ANOMASANDSTONE_SLAB = registerBlock("anomasandstone_slab", () ->
            new SlabBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.SANDSTONE_SLAB)
                    .strength(1.3f)));
    public static final Supplier<Block> ANOMASANDSTONE_STAIRS = registerBlock("anomasandstone_stairs", () ->
            new AHStairBlock(ANOMASANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties
                    .ofFullCopy(Blocks.SANDSTONE_STAIRS)
                    .strength(1.3f)));
    public static final Supplier<Block> ANOMASANDSTONE_WALL = registerBlock("anomasandstone_wall", () ->
            new WallBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.SANDSTONE_WALL)
                    .strength(1.3f)));
    public static final Supplier<Block> SMOOTH_ANOMASANDSTONE = registerBlock("smooth_anomasandstone", () ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.SMOOTH_SANDSTONE)
                    .strength(1.3f)));
    public static final Supplier<Block> SMOOTH_ANOMASANDSTONE_SLAB = registerBlock("smooth_anomasandstone_slab", () ->
            new SlabBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.SMOOTH_SANDSTONE_SLAB)
                    .strength(1.3f)));
    public static final Supplier<Block> SMOOTH_ANOMASANDSTONE_STAIRS = registerBlock("smooth_anomasandstone_stairs", () ->
            new AHStairBlock(SMOOTH_ANOMASANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties
                    .ofFullCopy(Blocks.SMOOTH_SANDSTONE_STAIRS)
                    .strength(1.3f)));
    public static final Supplier<Block> CUT_ANOMASANDSTONE = registerBlock("cut_anomasandstone", () ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CUT_SANDSTONE)
                    .strength(1.3f)));
    public static final Supplier<Block> CUT_ANOMASANDSTONE_SLAB = registerBlock("cut_anomasandstone_slab", () ->
            new SlabBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CUT_SANDSTONE_SLAB)
                    .strength(1.3f)));
    public static final Supplier<Block> ANOMALICE = registerBlock("anomalice", () ->
            new AHHalfTransparentBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.ICE)
                    .strength(0.75f)));
    public static final Supplier<Block> ANOMASNOW_BLOCK = registerBlock("anomasnow_block", () ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.SNOW_BLOCK)
                    .strength(0.33f)));
    public static final Supplier<Block> SCURANE_LOG = registerBlock("scurane_log", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CHERRY_LOG)
                    .strength(3.0f)));
    public static final Supplier<Block> SCURANE_WOOD = registerBlock("scurane_wood", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CHERRY_WOOD)
                    .strength(3.0f)));
    public static final Supplier<Block> STRIPPED_SCURANE_LOG = registerBlock("stripped_scurane_log", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STRIPPED_CHERRY_LOG)
                    .strength(3.0f)));
    public static final Supplier<Block> STRIPPED_SCURANE_WOOD = registerBlock("stripped_scurane_wood", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STRIPPED_CHERRY_WOOD)
                    .strength(3.0f)));
    public static final Supplier<Block> SCURANE_LEAVES = registerBlock("scurane_leaves", () ->
            new LeavesBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CHERRY_LEAVES)
                    .strength(0.3f)
                    .randomTicks()));
    public static final Supplier<Block> SCURANE_PLANKS = registerBlock("scurane_planks", () ->
            new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CHERRY_PLANKS)
                    .strength(3.0f)));
    public static final Supplier<Block> SCURANE_SLAB = registerBlock("scurane_slab", () ->
            new SlabBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CHERRY_SLAB)
                    .strength(3.0f)));
    public static final Supplier<Block> SCURANE_STAIRS = registerBlock("scurane_stairs", () ->
            new AHStairBlock(SCURANE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CHERRY_STAIRS)
                    .strength(3.0f)));
    public static final Supplier<Block> SCURANE_FENCE = registerBlock("scurane_fence", () ->
            new FenceBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CHERRY_FENCE)
                    .strength(3.0f)));
    public static final Supplier<Block> SCURANE_FENCE_GATE = registerBlock("scurane_fence_gate", () ->
            new FenceGateBlock(AHWoodType.SCURANE, BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CHERRY_FENCE_GATE)
                    .strength(3.0f)));
    public static final Supplier<Block> SCURANE_BUTTON = registerBlock("scurane_button", () ->
            new AHButtonBlock(AHBlockSetType.SCURANE, 15, BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CHERRY_BUTTON)
                    .strength(0.75f)));
    public static final Supplier<Block> SCURANE_PRESSURE_PLATE = registerBlock("scurane_pressure_plate", () ->
            new AHPressurePlateBlock(AHBlockSetType.SCURANE, BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CHERRY_PRESSURE_PLATE)
                    .strength(0.75f)));
    public static final Supplier<Block> SCURANE_TRAPDOOR = registerBlock("scurane_trapdoor", () ->
            new AHTrapDoorBlock(AHBlockSetType.SCURANE, BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CHERRY_TRAPDOOR)
                    .strength(3.0f)));
    public static final Supplier<Block> SCURANE_DOOR = registerBlock("scurane_door", () ->
            new AHDoorBlock(AHBlockSetType.SCURANE, BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CHERRY_DOOR)
                    .strength(3.0f)));
    public static final Supplier<Block> SCURANE_SIGN = registerBlock("scurane_sign", () ->
            new WallSignBlock(AHWoodType.SCURANE, BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CHERRY_SIGN)
                    .strength(3.0f)));
    public static final Supplier<Block> SCURANE_WALL_SIGN = registerBlock("scurane_wall_sign", () ->
            new WallSignBlock(AHWoodType.SCURANE, BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CHERRY_WALL_SIGN)
                    .strength(3.0f)));
    public static final Supplier<Block> SCURANE_HANGING_SIGN = registerBlock("scurane_hanging_sign", () ->
            new CeilingHangingSignBlock(AHWoodType.SCURANE, BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CHERRY_HANGING_SIGN)
                    .strength(3.0f)));
    public static final Supplier<Block> SCURANE_WALL_HANGING_SIGN = registerBlock("scurane_wall_hanging_sign", () ->
            new WallHangingSignBlock(AHWoodType.SCURANE, BlockBehaviour.Properties
                    .ofFullCopy(Blocks.CHERRY_WALL_HANGING_SIGN)
                    .strength(3.0f)));
    public static final Supplier<Block> ANOMALOUS_SHORT_GRASS = registerBlock("anomalous_short_grass", () ->
            new AnomalousBushBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.SHORT_GRASS)
                    .strength(0.2f), AHTags.ANOMALOUS_DIRT)); //FIXME create tags class
    public static final Supplier<Block> SICKENED_SHRUB = registerBlock("sickened_shrub", () ->
            new AnomalousBushBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.FERN)
                    .strength(0.2f), AHTags.ANOMALOUS_DIRT)); //FIXME same here!

    public static final Block[] ANOMALOUS_TINTED_BLOCKS = new Block[]{
            AHBlocks.COBBLED_ANOMASTONE.get(), AHBlocks.COBBLED_ANOMASTONE_SLAB.get(), AHBlocks.COBBLED_ANOMASTONE_STAIRS.get(),
            AHBlocks.COBBLED_ANOMASTONE_WALL.get(), AHBlocks.ANOMASTONE_BRICKS.get(), AHBlocks.ANOMASTONE_BRICK_STAIRS.get(),
            AHBlocks.ANOMASTONE_BRICK_SLAB.get(), AHBlocks.ANOMASTONE_BRICK_WALL.get(), AHBlocks.CHISELED_ANOMASTONE_BRICKS.get(),
            AHBlocks.CHLORITE.get(), AHBlocks.CHLORITE_SLAB.get(), AHBlocks.CHLORITE_STAIRS.get(),
            AHBlocks.CHLORITE_WALL.get(), AHBlocks.CHLORITE_BRICKS.get(), AHBlocks.CHLORITE_BRICK_SLAB.get(),
            AHBlocks.CHLORITE_BRICK_STAIRS.get(), AHBlocks.CHLORITE_BRICK_WALL.get(), AHBlocks.SIDEROCK.get(),
            AHBlocks.SIDEROCK_SLAB.get(), AHBlocks.SIDEROCK_STAIRS.get(), AHBlocks.SIDEROCK_WALL.get(),
            AHBlocks.SIDEROCK_BRICKS.get(), AHBlocks.SIDEROCK_BRICK_SLAB.get(), AHBlocks.SIDEROCK_BRICK_STAIRS.get(),
            AHBlocks.SIDEROCK_BRICK_WALL.get(), AHBlocks.AURANITE.get(), AHBlocks.AURANITE_SLAB.get(),
            AHBlocks.AURANITE_STAIRS.get(), AHBlocks.AURANITE_WALL.get(), AHBlocks.AURANITE_BRICKS.get(),
            AHBlocks.AURANITE_BRICK_SLAB.get(), AHBlocks.AURANITE_BRICK_STAIRS.get(), AHBlocks.AURANITE_BRICK_WALL.get(),
            AHBlocks.ANOMASAND.get(), AHBlocks.ANOMASANDSTONE.get(), AHBlocks.ANOMASANDSTONE_SLAB.get(),
            AHBlocks.ANOMASANDSTONE_STAIRS.get(), AHBlocks.ANOMASANDSTONE_WALL.get(), AHBlocks.SMOOTH_ANOMASANDSTONE.get(),
            AHBlocks.SMOOTH_ANOMASANDSTONE_SLAB.get(), AHBlocks.SMOOTH_ANOMASANDSTONE_STAIRS.get(), AHBlocks.CUT_ANOMASANDSTONE.get(),
            AHBlocks.CUT_ANOMASANDSTONE_SLAB.get(), AHBlocks.ANOMALICE.get(), AHBlocks.ANOMASNOW_BLOCK.get(),
            AHBlocks.SCURANE_LOG.get(), AHBlocks.SCURANE_WOOD.get(), AHBlocks.STRIPPED_SCURANE_LOG.get(),
            AHBlocks.STRIPPED_SCURANE_WOOD.get(), AHBlocks.SCURANE_LEAVES.get(), AHBlocks.SCURANE_PLANKS.get(),
            AHBlocks.SCURANE_SLAB.get(), AHBlocks.SCURANE_STAIRS.get(), AHBlocks.SCURANE_FENCE.get(),
            AHBlocks.SCURANE_FENCE_GATE.get(), AHBlocks.SCURANE_DOOR.get(), AHBlocks.SCURANE_TRAPDOOR.get(),
            AHBlocks.SCURANE_PRESSURE_PLATE.get(), AHBlocks.SCURANE_BUTTON.get(), AHBlocks.SCURANE_SIGN.get(),
            AHBlocks.SCURANE_HANGING_SIGN.get(), AHBlocks.ANOMALOUS_SHORT_GRASS.get(), AHBlocks.SICKENED_SHRUB.get(),
            AHBlocks.TEST_TINTED_BLOCK.get()
    };

}
