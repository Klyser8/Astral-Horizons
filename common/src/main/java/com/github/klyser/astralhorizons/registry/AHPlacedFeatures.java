package com.github.klyser.astralhorizons.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import static com.github.klyser.astralhorizons.AstralHorizons.id;

public class AHPlacedFeatures {

    public static final ResourceKey<PlacedFeature> SCURANE_TREE = ResourceKey.create(Registries.PLACED_FEATURE, id("scurane_tree"));
    public static final ResourceKey<PlacedFeature> ANOMASTONE_BOULDER = ResourceKey.create(Registries.PLACED_FEATURE, id("anomastone_boulder"));
    public static final ResourceKey<PlacedFeature> DISK_ANOMASAND = ResourceKey.create(Registries.PLACED_FEATURE, id("disk_anomasand"));
    public static final ResourceKey<PlacedFeature> DISK_LUTIEL = ResourceKey.create(Registries.PLACED_FEATURE, id("disk_lutiel"));
    public static final ResourceKey<PlacedFeature> AURANITE_ORE = ResourceKey.create(Registries.PLACED_FEATURE, id("ore_auranite"));
    public static final ResourceKey<PlacedFeature> CHLORITE_ORE = ResourceKey.create(Registries.PLACED_FEATURE, id("ore_chlorite"));
    public static final ResourceKey<PlacedFeature> SIDEROCK_ORE = ResourceKey.create(Registries.PLACED_FEATURE, id("ore_siderock"));
    public static final ResourceKey<PlacedFeature> ANOMALOUS_GRASS_PATCH = ResourceKey.create(Registries.PLACED_FEATURE, id("anomalous_grass_patch"));
    public static final ResourceKey<PlacedFeature> SINGLE_ANOMALOUS_GRASS = ResourceKey.create(Registries.PLACED_FEATURE, id("single_anomalous_grass"));

}
