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
    public static final Supplier<Item> ANOMALOUS_SAND = CommonPlatformHelper.registerItem(
            "anomalous_sand", () -> new BlockItem(AHBlocks.ANOMALOUS_SAND.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALOUS_LOG = CommonPlatformHelper.registerItem(
            "anomalous_log", () -> new BlockItem(AHBlocks.ANOMALOUS_LOG.get(), new Item.Properties()));
    public static final Supplier<Item> ANOMALOUS_LEAVES = CommonPlatformHelper.registerItem(
            "anomalous_leaves", () -> new BlockItem(AHBlocks.ANOMALOUS_LEAVES.get(), new Item.Properties()));


}
