package com.github.klyser.astralhorizons.registry;

import com.github.klyser.astralhorizons.platform.CommonPlatformHelper;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import java.util.function.Supplier;

public class AHItems {

    public static void init() {}

    public static final Supplier<Item> COSMIC_CRYSTAL = CommonPlatformHelper.registerItem(
            "cosmic_crystal", () -> new Item(new Item.Properties()
                    .rarity(Rarity.UNCOMMON)));

    // ---- BLOCKS ----

    public static final Supplier<Item> ANOMALOUS_DIRT = CommonPlatformHelper.registerItem(
            "anomalous_dirt", () -> new BlockItem(AHBlocks.ANOMALOUS_DIRT.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALOUS_GRASS_BLOCK = CommonPlatformHelper.registerItem(
            "anomalous_grass_block", () -> new BlockItem(AHBlocks.ANOMALOUS_GRASS_BLOCK.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALOUS_STONE = CommonPlatformHelper.registerItem(
            "anomalous_stone", () -> new BlockItem(AHBlocks.ANOMALOUS_STONE.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALOUS_STONE_SLAB = CommonPlatformHelper.registerItem(
            "anomalous_slab", () -> new BlockItem(AHBlocks.ANOMALOUS_STONE_SLAB.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALOUS_STONE_STAIRS = CommonPlatformHelper.registerItem(
            "anomalous_stairs", () -> new BlockItem(AHBlocks.ANOMALOUS_STONE_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALOUS_STONE_PRESSURE_PLATE = CommonPlatformHelper.registerItem(
            "anomalous_pressure_plate", () -> new BlockItem(AHBlocks.ANOMALOUS_STONE_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALOUS_STONE_BUTTON = CommonPlatformHelper.registerItem(
            "anomalous_button", () -> new BlockItem(AHBlocks.ANOMALOUS_STONE_BUTTON.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALOUS_COBBLESTONE = CommonPlatformHelper.registerItem(
            "anomalous_cobblestone", () -> new BlockItem(AHBlocks.ANOMALOUS_COBBLESTONE.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALOUS_COBBLESTONE_SLAB = CommonPlatformHelper.registerItem(
            "anomalous_cobblestone_slab", () -> new BlockItem(AHBlocks.ANOMALOUS_COBBLESTONE_SLAB.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALOUS_COBBLESTONE_STAIRS = CommonPlatformHelper.registerItem(
            "anomalous_cobblestone_stairs", () -> new BlockItem(AHBlocks.ANOMALOUS_COBBLESTONE_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALOUS_COBBLESTONE_WALL = CommonPlatformHelper.registerItem(
            "anomalous_cobblestone_wall", () -> new BlockItem(AHBlocks.ANOMALOUS_COBBLESTONE_WALL.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALOUS_STONE_BRICKS = CommonPlatformHelper.registerItem(
            "anomalous_stone_bricks", () -> new BlockItem(AHBlocks.ANOMALOUS_STONE_BRICKS.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALOUS_STONE_BRICK_STAIRS = CommonPlatformHelper.registerItem(
            "anomalous_stone_brick_stairs", () -> new BlockItem(AHBlocks.ANOMALOUS_STONE_BRICK_STAIRS.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALOUS_STONE_BRICK_SLAB = CommonPlatformHelper.registerItem(
            "anomalous_stone_brick_slab", () -> new BlockItem(AHBlocks.ANOMALOUS_STONE_BRICK_SLAB.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALOUS_STONE_BRICK_WALL = CommonPlatformHelper.registerItem(
            "anomalous_stone_brick_wall", () -> new BlockItem(AHBlocks.ANOMALOUS_STONE_BRICK_WALL.get(), new Item.Properties()));
    public static final Supplier<Item> CHISELED_ANOMALOUS_STONE_BRICKS = CommonPlatformHelper.registerItem(
            "chiseled_anomalous_stone_bricks", () -> new BlockItem(AHBlocks.CHISELED_ANOMALOUS_STONE_BRICKS.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALOUS_SAND = CommonPlatformHelper.registerItem(
            "anomalous_sand", () -> new BlockItem(AHBlocks.ANOMALOUS_SAND.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALOUS_LOG = CommonPlatformHelper.registerItem(
            "anomalous_log", () -> new BlockItem(AHBlocks.ANOMALOUS_LOG.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALOUS_LEAVES = CommonPlatformHelper.registerItem(
            "anomalous_leaves", () -> new BlockItem(AHBlocks.ANOMALOUS_LEAVES.get(), new Item.Properties()));


}
