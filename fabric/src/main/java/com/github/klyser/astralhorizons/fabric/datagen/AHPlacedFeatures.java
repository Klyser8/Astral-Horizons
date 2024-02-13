package com.github.klyser.astralhorizons.fabric.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

import static com.github.klyser.astralhorizons.AstralHorizons.id;

public class AHPlacedFeatures {

    public static final ResourceKey<PlacedFeature> SCURANE_TREE = ResourceKey.create(Registries.PLACED_FEATURE, id("scurane_tree"));
    public static final ResourceKey<PlacedFeature> ANOMASTONE_BOULDER = ResourceKey.create(Registries.PLACED_FEATURE, id("anomastone_boulder"));
    public static final ResourceKey<PlacedFeature> DISK_ANOMASAND = ResourceKey.create(Registries.PLACED_FEATURE, id("disk_anomasand"));
    public static final ResourceKey<PlacedFeature> DISK_LUTIEL = ResourceKey.create(Registries.PLACED_FEATURE, id("disk_lutiel"));
    public static final ResourceKey<PlacedFeature> AURANITE_ORE = ResourceKey.create(Registries.PLACED_FEATURE, id("ore_auranite"));
    public static final ResourceKey<PlacedFeature> CHLORITE_ORE = ResourceKey.create(Registries.PLACED_FEATURE, id("ore_chlorite"));
    public static final ResourceKey<PlacedFeature> SIDEROCK_ORE = ResourceKey.create(Registries.PLACED_FEATURE, id("ore_siderock"));
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> features = context.lookup(Registries.CONFIGURED_FEATURE);

        registerScuraneTree(context, features);
        registerAnomastoneBoulder(context, features);
        registerAnomasandDisk(context, features);
        registerLutielDisk(context, features);
        registerAuraniteOre(context, features);
        registerChloriteOre(context, features);
        registerSiderockOre(context, features);
    }

    private static void registerScuraneTree(BootstapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> features) {
        Holder.Reference<ConfiguredFeature<?, ?>> scuraneTree = features.getOrThrow(AHConfiguredFeatures.SCURANE_TREE);
        PlacementUtils.register(context, SCURANE_TREE, scuraneTree, List.of(
                BlockPredicateFilter.forPredicate(
                        BlockPredicate.wouldSurvive(
                                Blocks.ACACIA_SAPLING.defaultBlockState().setValue(BlockStateProperties.STAGE, 0),
                                Vec3i.ZERO
                        )
                )
        ));
    }
    private static void registerAnomastoneBoulder(BootstapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> features) {
        Holder.Reference<ConfiguredFeature<?, ?>> anomastoneBoulder = features.getOrThrow(AHConfiguredFeatures.ANOMASTONE_BOULDER); //TODO implement frfr!
        PlacementUtils.register(context, ANOMASTONE_BOULDER, anomastoneBoulder,
                InSquarePlacement.spread(),
                RarityFilter.onAverageOnceEvery(10),
                HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES),
                BlockPredicateFilter.forPredicate(
                        BlockPredicate.matchesBlocks(Blocks.AIR, Blocks.WATER)
                ),
                BiomeFilter.biome()
        );
    }
    private static void registerAnomasandDisk(BootstapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> features) {
        Holder.Reference<ConfiguredFeature<?, ?>> diskAnomasand = features.getOrThrow(AHConfiguredFeatures.DISK_ANOMASAND);
        PlacementUtils.register(context, DISK_ANOMASAND, diskAnomasand,
                InSquarePlacement.spread(),
                HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG),
                BlockPredicateFilter.forPredicate(
                        BlockPredicate.matchesFluids(Fluids.WATER)
                ),
                BiomeFilter.biome()
        );
    }
    private static void registerLutielDisk(BootstapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> features) {
        Holder.Reference<ConfiguredFeature<?, ?>> diskLutiel = features.getOrThrow(AHConfiguredFeatures.DISK_LUTIEL);
        PlacementUtils.register(context, DISK_LUTIEL, diskLutiel,
                InSquarePlacement.spread(),
                HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG),
                BlockPredicateFilter.forPredicate(
                        BlockPredicate.matchesFluids(Fluids.WATER)
                ),
                BiomeFilter.biome()
        );
    }
    private static void registerAuraniteOre(BootstapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> features) {
        Holder.Reference<ConfiguredFeature<?, ?>> auraniteOre = features.getOrThrow(AHConfiguredFeatures.AURANITE_ORE);
        PlacementUtils.register(context, AURANITE_ORE, auraniteOre,
                InSquarePlacement.spread(),
                RarityFilter.onAverageOnceEvery(3),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-25), VerticalAnchor.absolute(20))
        );
    }private static void registerChloriteOre(BootstapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> features) {
        Holder.Reference<ConfiguredFeature<?, ?>> chloriteOre = features.getOrThrow(AHConfiguredFeatures.CHLORITE_ORE);
        PlacementUtils.register(context, CHLORITE_ORE, chloriteOre,
                InSquarePlacement.spread(),
                RarityFilter.onAverageOnceEvery(3),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(15), VerticalAnchor.absolute(60))
        );
    }private static void registerSiderockOre(BootstapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> features) {
        Holder.Reference<ConfiguredFeature<?, ?>> siderockOre = features.getOrThrow(AHConfiguredFeatures.SIDEROCK_ORE);
        PlacementUtils.register(context, SIDEROCK_ORE, siderockOre,
                InSquarePlacement.spread(),
                RarityFilter.onAverageOnceEvery(3),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(-20))
        );
    }

}
