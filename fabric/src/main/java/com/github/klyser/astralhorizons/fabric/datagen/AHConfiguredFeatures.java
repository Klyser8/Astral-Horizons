package com.github.klyser.astralhorizons.fabric.datagen;

import com.github.klyser.astralhorizons.registry.AHBlocks;
import com.github.klyser.astralhorizons.registry.AHFeatures;
import com.github.klyser.astralhorizons.world.feature.config.BoulderFeatureConfig;
import com.github.klyser.astralhorizons.world.feature.config.SimpleTreeFeatureConfig;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

import java.util.List;

import static com.github.klyser.astralhorizons.AstralHorizons.id;

public class AHConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> SCURANE_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE, id("scurane_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ANOMASTONE_BOULDER = ResourceKey.create(Registries.CONFIGURED_FEATURE, id("anomastone_boulder"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_ANOMASAND = ResourceKey.create(Registries.CONFIGURED_FEATURE, id("disk_anomasand"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_LUTIEL = ResourceKey.create(Registries.CONFIGURED_FEATURE, id("disk_lutiel"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> AURANITE_ORE = ResourceKey.create(Registries.CONFIGURED_FEATURE, id("ore_auranite"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHLORITE_ORE = ResourceKey.create(Registries.CONFIGURED_FEATURE, id("ore_chlorite"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SIDEROCK_ORE = ResourceKey.create(Registries.CONFIGURED_FEATURE, id("ore_siderock"));

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        registerScuraneTree(context);
        registerAnomastoneBoulder(context);
        registerAnomasandDisk(context);
        registerLutielDisk(context);
        registerAuraniteOre(context);
        registerChloriteOre(context);
        registerSiderockOre(context);
    }

    private static void registerAnomastoneBoulder(BootstapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, ANOMASTONE_BOULDER, AHFeatures.BOULDER.get(), new BoulderFeatureConfig(
                List.of(
                        id("boulders/boulder21"),
                        id("boulders/boulder22"),
                        id("boulders/boulder23"),
                        id("boulders/boulder24"),
                        id("boulders/boulder31"),
                        id("boulders/boulder32"),
                        id("boulders/boulder33"),
                        id("boulders/boulder34"),
                        id("boulders/boulder35"),
                        id("boulders/boulder41"),
                        id("boulders/boulder42"),
                        id("boulders/boulder43"),
                        id("boulders/boulder51"),
                        id("boulders/boulder52")
                ),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>()
                        .add(AHBlocks.ANOMASTONE.get().defaultBlockState(), 3)
                        .add(AHBlocks.COBBLED_ANOMASTONE.get().defaultBlockState(), 1)),
                true,
                true
        ));
    }
    private static void registerScuraneTree(BootstapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, SCURANE_TREE, AHFeatures.SIMPLE_TREE.get(), new SimpleTreeFeatureConfig(
                List.of(
                        id("scurane_crown1"),
                        id("scurane_crown2"),
                        id("scurane_crown3"),
                        id("scurane_crown4")
                ),
                UniformInt.of(2, 5),
                BlockStateProvider.simple(AHBlocks.SCURANE_LOG.get()),
                true,
                true
        ));
    }
    private static void registerAnomasandDisk(BootstapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, DISK_ANOMASAND, Feature.DISK, new DiskConfiguration(
                new RuleBasedBlockStateProvider(BlockStateProvider.simple(AHBlocks.ANOMASAND.get()), List.of()),
                BlockPredicate.matchesBlocks(AHBlocks.ANOMADIRT.get()),
                UniformInt.of(2, 4),
                1
        ));
    }
    private static void registerLutielDisk(BootstapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, DISK_LUTIEL, Feature.DISK, new DiskConfiguration(
                new RuleBasedBlockStateProvider(BlockStateProvider.simple(AHBlocks.LUTIEL.get()), List.of()),
                BlockPredicate.matchesBlocks(AHBlocks.ANOMADIRT.get()),
                UniformInt.of(2, 4),
                1
        ));
    }
    private static void registerAuraniteOre(BootstapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, AURANITE_ORE, Feature.ORE, new OreConfiguration(
                List.of(
                        OreConfiguration.target(new BlockMatchTest(AHBlocks.ANOMASTONE.get()), AHBlocks.AURANITE.get().defaultBlockState()),
                        OreConfiguration.target(new BlockMatchTest(Blocks.STONE), AHBlocks.AURANITE.get().defaultBlockState()),
                        OreConfiguration.target(new BlockMatchTest(Blocks.DEEPSLATE), AHBlocks.AURANITE.get().defaultBlockState())
                ),
                64)
        );
    }
    private static void registerChloriteOre(BootstapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, CHLORITE_ORE, Feature.ORE, new OreConfiguration(
                List.of(
                        OreConfiguration.target(new BlockMatchTest(AHBlocks.ANOMASTONE.get()), AHBlocks.CHLORITE.get().defaultBlockState()),
                        OreConfiguration.target(new BlockMatchTest(Blocks.STONE), AHBlocks.CHLORITE.get().defaultBlockState()),
                        OreConfiguration.target(new BlockMatchTest(Blocks.DEEPSLATE), AHBlocks.CHLORITE.get().defaultBlockState())
                ),
                64)
        );
    }
    private static void registerSiderockOre(BootstapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, SIDEROCK_ORE, Feature.ORE, new OreConfiguration(
                List.of(
                        OreConfiguration.target(new BlockMatchTest(AHBlocks.ANOMASTONE.get()), AHBlocks.SIDEROCK.get().defaultBlockState()),
                        OreConfiguration.target(new BlockMatchTest(Blocks.STONE), AHBlocks.SIDEROCK.get().defaultBlockState()),
                        OreConfiguration.target(new BlockMatchTest(Blocks.DEEPSLATE), AHBlocks.SIDEROCK.get().defaultBlockState())
                ),
                64)
        );
    }

}
