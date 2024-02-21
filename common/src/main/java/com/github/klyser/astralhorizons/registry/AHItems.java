package com.github.klyser.astralhorizons.registry;

import com.github.klyser.astralhorizons.platform.CommonPlatformHelper;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;

import java.util.function.Supplier;

public class AHItems {

    public static void init() {}

    public static final Supplier<Item> COSMIC_CRYSTAL = CommonPlatformHelper.registerItem(
            "cosmic_crystal", () -> new Item(new Item.Properties()
                    .rarity(Rarity.UNCOMMON)));
    public static final Supplier<Item> STARFLARE_BLOSSOM = CommonPlatformHelper.registerItem(
            "starflare_blossom", () -> new ItemNameBlockItem(AHBlocks.TWISTED_TENDRIL_HEAD.get(), new Item.Properties()));

    // ---- BLOCKS ----

    public static final Supplier<Item> ANOMADIRT = CommonPlatformHelper.registerItem(
            "anomadirt", () -> new BlockItem(AHBlocks.ANOMADIRT.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMAGRASS_BLOCK = CommonPlatformHelper.registerItem(
            "anomagrass_block", () -> new BlockItem(AHBlocks.ANOMAGRASS_BLOCK.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMASTONE = CommonPlatformHelper.registerItem(
            "anomastone", () -> new BlockItem(AHBlocks.ANOMASTONE.get(), new Item.Properties()));
    public static final Supplier<Item> LUTIEL = CommonPlatformHelper.registerItem(
            "lutiel", () -> new BlockItem(AHBlocks.LUTIEL.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMASTONE_SLAB = CommonPlatformHelper.registerItem(
            "anomastone_slab", () -> new BlockItem(AHBlocks.ANOMASTONE_SLAB.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMASTONE_STAIRS = CommonPlatformHelper.registerItem(
            "anomastone_stairs", () -> new BlockItem(AHBlocks.ANOMASTONE_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMASTONE_PRESSURE_PLATE = CommonPlatformHelper.registerItem(
            "anomastone_pressure_plate", () -> new BlockItem(AHBlocks.ANOMASTONE_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMASTONE_BUTTON = CommonPlatformHelper.registerItem(
            "anomastone_button", () -> new BlockItem(AHBlocks.ANOMASTONE_BUTTON.get(), new Item.Properties()));
    public static final Supplier<Item> COBBLED_ANOMASTONE = CommonPlatformHelper.registerItem(
            "cobbled_anomastone", () -> new BlockItem(AHBlocks.COBBLED_ANOMASTONE.get(), new Item.Properties()));
    public static final Supplier<Item> COBBLED_ANOMASTONE_SLAB = CommonPlatformHelper.registerItem(
            "cobbled_anomastone_slab", () -> new BlockItem(AHBlocks.COBBLED_ANOMASTONE_SLAB.get(), new Item.Properties()));
    public static final Supplier<Item> COBBLED_ANOMASTONE_STAIRS = CommonPlatformHelper.registerItem(
            "cobbled_anomastone_stairs", () -> new BlockItem(AHBlocks.COBBLED_ANOMASTONE_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> COBBLED_ANOMASTONE_WALL = CommonPlatformHelper.registerItem(
            "cobbled_anomastone_wall", () -> new BlockItem(AHBlocks.COBBLED_ANOMASTONE_WALL.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMASTONE_BRICKS = CommonPlatformHelper.registerItem(
            "anomastone_bricks", () -> new BlockItem(AHBlocks.ANOMASTONE_BRICKS.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMASTONE_BRICK_STAIRS = CommonPlatformHelper.registerItem(
            "anomastone_brick_stairs", () -> new BlockItem(AHBlocks.ANOMASTONE_BRICK_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMASTONE_BRICK_SLAB = CommonPlatformHelper.registerItem(
            "anomastone_brick_slab", () -> new BlockItem(AHBlocks.ANOMASTONE_BRICK_SLAB.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMASTONE_BRICK_WALL = CommonPlatformHelper.registerItem(
            "anomastone_brick_wall", () -> new BlockItem(AHBlocks.ANOMASTONE_BRICK_WALL.get(), new Item.Properties()));
    public static final Supplier<Item> CHISELED_ANOMASTONE_BRICKS = CommonPlatformHelper.registerItem(
            "chiseled_anomastone_bricks", () -> new BlockItem(AHBlocks.CHISELED_ANOMASTONE_BRICKS.get(), new Item.Properties()));
    public static final Supplier<Item> CHLORITE = CommonPlatformHelper.registerItem(
            "chlorite", () -> new BlockItem(AHBlocks.CHLORITE.get(), new Item.Properties()));
    public static final Supplier<Item> CHLORITE_SLAB = CommonPlatformHelper.registerItem(
            "chlorite_slab", () -> new BlockItem(AHBlocks.CHLORITE_SLAB.get(), new Item.Properties()));
    public static final Supplier<Item> CHLORITE_STAIRS = CommonPlatformHelper.registerItem(
            "chlorite_stairs", () -> new BlockItem(AHBlocks.CHLORITE_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> CHLORITE_WALL = CommonPlatformHelper.registerItem(
            "chlorite_wall", () -> new BlockItem(AHBlocks.CHLORITE_WALL.get(), new Item.Properties()));
    public static final Supplier<Item> CHLORITE_BRICKS = CommonPlatformHelper.registerItem(
            "chlorite_bricks", () -> new BlockItem(AHBlocks.CHLORITE_BRICKS.get(), new Item.Properties()));
    public static final Supplier<Item> CHLORITE_BRICK_SLAB = CommonPlatformHelper.registerItem(
            "chlorite_brick_slab", () -> new BlockItem(AHBlocks.CHLORITE_BRICK_SLAB.get(), new Item.Properties()));
    public static final Supplier<Item> CHLORITE_BRICK_STAIRS = CommonPlatformHelper.registerItem(
            "chlorite_brick_stairs", () -> new BlockItem(AHBlocks.CHLORITE_BRICK_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> CHLORITE_BRICK_WALL = CommonPlatformHelper.registerItem(
            "chlorite_brick_wall", () -> new BlockItem(AHBlocks.CHLORITE_BRICK_WALL.get(), new Item.Properties()));
    public static final Supplier<Item> SIDEROCK = CommonPlatformHelper.registerItem(
            "siderock", () -> new BlockItem(AHBlocks.SIDEROCK.get(), new Item.Properties()));
    public static final Supplier<Item> SIDEROCK_SLAB = CommonPlatformHelper.registerItem(
            "siderock_slab", () -> new BlockItem(AHBlocks.SIDEROCK_SLAB.get(), new Item.Properties()));
    public static final Supplier<Item> SIDEROCK_STAIRS = CommonPlatformHelper.registerItem(
            "siderock_stairs", () -> new BlockItem(AHBlocks.SIDEROCK_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> SIDEROCK_WALL = CommonPlatformHelper.registerItem(
            "siderock_wall", () -> new BlockItem(AHBlocks.SIDEROCK_WALL.get(), new Item.Properties()));
    public static final Supplier<Item> SIDEROCK_BRICKS = CommonPlatformHelper.registerItem(
            "siderock_bricks", () -> new BlockItem(AHBlocks.SIDEROCK_BRICKS.get(), new Item.Properties()));
    public static final Supplier<Item> SIDEROCK_BRICK_SLAB = CommonPlatformHelper.registerItem(
            "siderock_brick_slab", () -> new BlockItem(AHBlocks.SIDEROCK_BRICK_SLAB.get(), new Item.Properties()));
    public static final Supplier<Item> SIDEROCK_BRICK_STAIRS = CommonPlatformHelper.registerItem(
            "siderock_brick_stairs", () -> new BlockItem(AHBlocks.SIDEROCK_BRICK_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> SIDEROCK_BRICK_WALL = CommonPlatformHelper.registerItem(
            "siderock_brick_wall", () -> new BlockItem(AHBlocks.SIDEROCK_BRICK_WALL.get(), new Item.Properties()));
    public static final Supplier<Item> AURANITE = CommonPlatformHelper.registerItem(
            "auranite", () -> new BlockItem(AHBlocks.AURANITE.get(), new Item.Properties()));
    public static final Supplier<Item> AURANITE_SLAB = CommonPlatformHelper.registerItem(
            "auranite_slab", () -> new BlockItem(AHBlocks.AURANITE_SLAB.get(), new Item.Properties()));
    public static final Supplier<Item> AURANITE_STAIRS = CommonPlatformHelper.registerItem(
            "auranite_stairs", () -> new BlockItem(AHBlocks.AURANITE_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> AURANITE_WALL = CommonPlatformHelper.registerItem(
            "auranite_wall", () -> new BlockItem(AHBlocks.AURANITE_WALL.get(), new Item.Properties()));
    public static final Supplier<Item> AURANITE_BRICKS = CommonPlatformHelper.registerItem(
            "auranite_bricks", () -> new BlockItem(AHBlocks.AURANITE_BRICKS.get(), new Item.Properties()));
    public static final Supplier<Item> AURANITE_BRICK_SLAB = CommonPlatformHelper.registerItem(
            "auranite_brick_slab", () -> new BlockItem(AHBlocks.AURANITE_BRICK_SLAB.get(), new Item.Properties()));
    public static final Supplier<Item> AURANITE_BRICK_STAIRS = CommonPlatformHelper.registerItem(
            "auranite_brick_stairs", () -> new BlockItem(AHBlocks.AURANITE_BRICK_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> AURANITE_BRICK_WALL = CommonPlatformHelper.registerItem(
            "auranite_brick_wall", () -> new BlockItem(AHBlocks.AURANITE_BRICK_WALL.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMASAND = CommonPlatformHelper.registerItem(
            "anomasand", () -> new BlockItem(AHBlocks.ANOMASAND.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMASANDSTONE = CommonPlatformHelper.registerItem(
            "anomasandstone", () -> new BlockItem(AHBlocks.ANOMASANDSTONE.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMASANDSTONE_SLAB = CommonPlatformHelper.registerItem(
            "anomasandstone_slab", () -> new BlockItem(AHBlocks.ANOMASANDSTONE_SLAB.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMASANDSTONE_STAIRS = CommonPlatformHelper.registerItem(
            "anomasandstone_stairs", () -> new BlockItem(AHBlocks.ANOMASANDSTONE_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMASANDSTONE_WALL = CommonPlatformHelper.registerItem(
            "anomasandstone_wall", () -> new BlockItem(AHBlocks.ANOMASANDSTONE_WALL.get(), new Item.Properties()));
    public static final Supplier<Item> SMOOTH_ANOMASANDSTONE = CommonPlatformHelper.registerItem(
            "smooth_anomasandstone", () -> new BlockItem(AHBlocks.SMOOTH_ANOMASANDSTONE.get(), new Item.Properties()));
    public static final Supplier<Item> SMOOTH_ANOMASANDSTONE_SLAB = CommonPlatformHelper.registerItem(
            "smooth_anomasandstone_slab", () -> new BlockItem(AHBlocks.SMOOTH_ANOMASANDSTONE_SLAB.get(), new Item.Properties()));
    public static final Supplier<Item> SMOOTH_ANOMASANDSTONE_STAIRS = CommonPlatformHelper.registerItem(
            "smooth_anomasandstone_stairs", () -> new BlockItem(AHBlocks.SMOOTH_ANOMASANDSTONE_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> CUT_ANOMASANDSTONE = CommonPlatformHelper.registerItem(
            "cut_anomasandstone", () -> new BlockItem(AHBlocks.CUT_ANOMASANDSTONE.get(), new Item.Properties()));
    public static final Supplier<Item> CUT_ANOMASANDSTONE_SLAB = CommonPlatformHelper.registerItem(
            "cut_anomasandstone_slab", () -> new BlockItem(AHBlocks.CUT_ANOMASANDSTONE_SLAB.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALICE = CommonPlatformHelper.registerItem(
            "anomalice", () -> new BlockItem(AHBlocks.ANOMALICE.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMASNOW_BLOCK = CommonPlatformHelper.registerItem(
            "anomasnow_block", () -> new BlockItem(AHBlocks.ANOMASNOW_BLOCK.get(), new Item.Properties()));
    public static final Supplier<Item> SCURANE_LOG = CommonPlatformHelper.registerItem(
            "scurane_log", () -> new BlockItem(AHBlocks.SCURANE_LOG.get(), new Item.Properties()));
    public static final Supplier<Item> SCURANE_WOOD = CommonPlatformHelper.registerItem(
            "scurane_wood", () -> new BlockItem(AHBlocks.SCURANE_WOOD.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_SCURANE_LOG = CommonPlatformHelper.registerItem(
            "stripped_scurane_log", () -> new BlockItem(AHBlocks.STRIPPED_SCURANE_LOG.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_SCURANE_WOOD = CommonPlatformHelper.registerItem(
            "stripped_scurane_wood", () -> new BlockItem(AHBlocks.STRIPPED_SCURANE_WOOD.get(), new Item.Properties()));
    public static final Supplier<Item> SCURANE_LEAVES = CommonPlatformHelper.registerItem(
            "scurane_leaves", () -> new BlockItem(AHBlocks.SCURANE_LEAVES.get(), new Item.Properties()));
    public static final Supplier<Item> SCURANE_PLANKS = CommonPlatformHelper.registerItem(
            "scurane_planks", () -> new BlockItem(AHBlocks.SCURANE_PLANKS.get(), new Item.Properties()));
    public static final Supplier<Item> SCURANE_SLAB = CommonPlatformHelper.registerItem(
            "scurane_slab", () -> new BlockItem(AHBlocks.SCURANE_SLAB.get(), new Item.Properties()));
    public static final Supplier<Item> SCURANE_STAIRS = CommonPlatformHelper.registerItem(
            "scurane_stairs", () -> new BlockItem(AHBlocks.SCURANE_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> SCURANE_FENCE = CommonPlatformHelper.registerItem(
            "scurane_fence", () -> new BlockItem(AHBlocks.SCURANE_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> SCURANE_FENCE_GATE = CommonPlatformHelper.registerItem(
            "scurane_fence_gate", () -> new BlockItem(AHBlocks.SCURANE_FENCE_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> SCURANE_DOOR = CommonPlatformHelper.registerItem(
            "scurane_door", () -> new BlockItem(AHBlocks.SCURANE_DOOR.get(), new Item.Properties()));
    public static final Supplier<Item> SCURANE_TRAPDOOR = CommonPlatformHelper.registerItem(
            "scurane_trapdoor", () -> new BlockItem(AHBlocks.SCURANE_TRAPDOOR.get(), new Item.Properties()));
    public static final Supplier<Item> SCURANE_PRESSURE_PLATE = CommonPlatformHelper.registerItem(
            "scurane_pressure_plate", () -> new BlockItem(AHBlocks.SCURANE_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final Supplier<Item> SCURANE_BUTTON = CommonPlatformHelper.registerItem(
            "scurane_button", () -> new BlockItem(AHBlocks.SCURANE_BUTTON.get(), new Item.Properties()));
//    public static final Supplier<Item> SCURANE_SIGN = CommonPlatformHelper.registerItem(
//            "scurane_sign", () -> new BlockItem(AHBlocks.SCURANE_SIGN.get(), new Item.Properties()));
//    public static final Supplier<Item> SCURANE_HANGING_SIGN = CommonPlatformHelper.registerItem(
//            "scurane_hanging_sign", () -> new BlockItem(AHBlocks.SCURANE_HANGING_SIGN.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALOUS_SHORT_GRASS = CommonPlatformHelper.registerItem(
            "anomalous_short_grass", () -> new BlockItem(AHBlocks.ANOMALOUS_SHORT_GRASS.get(), new Item.Properties()));
    public static final Supplier<Item> SICKENED_SHRUB = CommonPlatformHelper.registerItem(
            "sickened_shrub", () -> new BlockItem(AHBlocks.SICKENED_SHRUB.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALOUS_SEAGRASS = CommonPlatformHelper.registerItem(
            "anomalous_seagrass", () -> new BlockItem(AHBlocks.ANOMALOUS_SEAGRASS.get(), new Item.Properties()));
    public static final Supplier<Item> SCURANE_SAPLING = CommonPlatformHelper.registerItem(
            "scurane_sapling", () -> new BlockItem(AHBlocks.SCURANE_SAPLING.get(), new Item.Properties()));
    public static final Supplier<Item> SCURANE_LIGHTS = CommonPlatformHelper.registerItem(
            "scurane_lights", () -> new BlockItem(AHBlocks.SCURANE_LIGHTS.get(), new Item.Properties()));
}
