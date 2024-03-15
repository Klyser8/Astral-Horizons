package com.github.klyser.astralhorizons.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import static com.github.klyser.astralhorizons.AstralHorizons.id;

public class AHConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> TWISTED_TENDRIL = ResourceKey.create(Registries.CONFIGURED_FEATURE, id("twisted_tendril"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCURANE_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE, id("scurane_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ANOMASTONE_BOULDER = ResourceKey.create(Registries.CONFIGURED_FEATURE, id("anomastone_boulder"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_ANOMASAND = ResourceKey.create(Registries.CONFIGURED_FEATURE, id("disk_anomasand"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_LUTIEL = ResourceKey.create(Registries.CONFIGURED_FEATURE, id("disk_lutiel"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> AURANITE_ORE = ResourceKey.create(Registries.CONFIGURED_FEATURE, id("ore_auranite"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHLORITE_ORE = ResourceKey.create(Registries.CONFIGURED_FEATURE, id("ore_chlorite"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SIDEROCK_ORE = ResourceKey.create(Registries.CONFIGURED_FEATURE, id("ore_siderock"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SINGLE_ANOMALOUS_GRASS = ResourceKey.create(Registries.CONFIGURED_FEATURE, id("single_anomalous_grass"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_ANOMALOUS_GRASS = ResourceKey.create(Registries.CONFIGURED_FEATURE, id("anomalous_grass_patch"));
//    public static final ResourceKey<ConfiguredFeature<?, ?>> TWISTED_TENDRIL_PATCH = ResourceKey.create(Registries.CONFIGURED_FEATURE, id("twisted_tendril_patch"));
}
