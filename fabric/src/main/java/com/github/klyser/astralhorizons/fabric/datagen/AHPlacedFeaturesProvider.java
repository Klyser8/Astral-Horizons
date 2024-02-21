package com.github.klyser.astralhorizons.fabric.datagen;

import com.github.klyser.astralhorizons.registry.AHConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

import static com.github.klyser.astralhorizons.registry.AHPlacedFeatures.*;

public class AHPlacedFeaturesProvider {
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> features = context.lookup(Registries.CONFIGURED_FEATURE);
        registerSingleAnomalousGrass(context, features);
        registerAnomalousGrassPatch(context, features);
        registerScuraneTree(context, features);
        registerAnomastoneBoulder(context, features);
        registerAnomasandDisk(context, features);
        registerLutielDisk(context, features);
        registerAuraniteOre(context, features);
        registerChloriteOre(context, features);
        registerSiderockOre(context, features);
    }

    private static void registerSingleAnomalousGrass(BootstapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> features) {
        Holder.Reference<ConfiguredFeature<?, ?>> feature = features.getOrThrow(AHConfiguredFeatures.SINGLE_ANOMALOUS_GRASS);
        PlacementUtils.register(context, SINGLE_ANOMALOUS_GRASS, feature, List.of(
                BlockPredicateFilter.forPredicate(
                        BlockPredicate.matchesBlocks(Blocks.AIR)
                )
        ));
    }
    private static void registerAnomalousGrassPatch(BootstapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> features) {
        Holder.Reference<ConfiguredFeature<?, ?>> feature = features.getOrThrow(AHConfiguredFeatures.PATCH_ANOMALOUS_GRASS);
        PlacementUtils.register(context, ANOMALOUS_GRASS_PATCH, feature,
                InSquarePlacement.spread(),
                HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
                CountPlacement.of(16),
                BiomeFilter.biome()
        );
    }

    private static void registerScuraneTree(BootstapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> features) {
        Holder.Reference<ConfiguredFeature<?, ?>> feature = features.getOrThrow(AHConfiguredFeatures.SCURANE_TREE);
        PlacementUtils.register(context, SCURANE_TREE, feature, List.of(
                BlockPredicateFilter.forPredicate(
                        BlockPredicate.wouldSurvive(
                                Blocks.ACACIA_SAPLING.defaultBlockState().setValue(BlockStateProperties.STAGE, 0),
                                Vec3i.ZERO
                        )
                )
        ));
    }
    private static void registerAnomastoneBoulder(BootstapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> features) {
        Holder.Reference<ConfiguredFeature<?, ?>> feature = features.getOrThrow(AHConfiguredFeatures.ANOMASTONE_BOULDER);
        PlacementUtils.register(context, ANOMASTONE_BOULDER, feature,
                InSquarePlacement.spread(),
                RarityFilter.onAverageOnceEvery(8),
                HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
                BiomeFilter.biome()
        );
    }
    private static void registerAnomasandDisk(BootstapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> features) {
        Holder.Reference<ConfiguredFeature<?, ?>> feature = features.getOrThrow(AHConfiguredFeatures.DISK_ANOMASAND);
        PlacementUtils.register(context, DISK_ANOMASAND, feature,
                InSquarePlacement.spread(),
                HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG),
                BlockPredicateFilter.forPredicate(
                        BlockPredicate.matchesFluids(Fluids.WATER)
                ),
                BiomeFilter.biome()
        );
    }
    private static void registerLutielDisk(BootstapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> features) {
        Holder.Reference<ConfiguredFeature<?, ?>> feature = features.getOrThrow(AHConfiguredFeatures.DISK_LUTIEL);
        PlacementUtils.register(context, DISK_LUTIEL, feature,
                InSquarePlacement.spread(),
                HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG),
                BlockPredicateFilter.forPredicate(
                        BlockPredicate.matchesFluids(Fluids.WATER)
                ),
                BiomeFilter.biome()
        );
    }
    private static void registerAuraniteOre(BootstapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> features) {
        Holder.Reference<ConfiguredFeature<?, ?>> feature = features.getOrThrow(AHConfiguredFeatures.AURANITE_ORE);
        PlacementUtils.register(context, AURANITE_ORE, feature,
                InSquarePlacement.spread(),
                RarityFilter.onAverageOnceEvery(3),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-25), VerticalAnchor.absolute(20))
        );
    }
    private static void registerChloriteOre(BootstapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> features) {
        Holder.Reference<ConfiguredFeature<?, ?>> feature = features.getOrThrow(AHConfiguredFeatures.CHLORITE_ORE);
        PlacementUtils.register(context, CHLORITE_ORE, feature,
                InSquarePlacement.spread(),
                RarityFilter.onAverageOnceEvery(3),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(15), VerticalAnchor.absolute(60))
        );
    }
    private static void registerSiderockOre(BootstapContext<PlacedFeature> context, HolderGetter<ConfiguredFeature<?, ?>> features) {
        Holder.Reference<ConfiguredFeature<?, ?>> feature = features.getOrThrow(AHConfiguredFeatures.SIDEROCK_ORE);
        PlacementUtils.register(context, SIDEROCK_ORE, feature,
                InSquarePlacement.spread(),
                RarityFilter.onAverageOnceEvery(3),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(-20))
        );
    }

}
