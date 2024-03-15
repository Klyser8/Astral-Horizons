package com.github.klyser.astralhorizons.registry;

import com.github.klyser.astralhorizons.platform.CommonPlatformHelper;
import com.github.klyser.astralhorizons.world.feature.config.BoulderFeatureConfig;
import com.github.klyser.astralhorizons.world.feature.config.SimpleTreeFeatureConfig;
import com.github.klyser.astralhorizons.world.feature.feature.BoulderFeature;
import com.github.klyser.astralhorizons.world.feature.feature.SimpleTreeFeature;
import com.github.klyser.astralhorizons.world.feature.feature.TwistedTendrilFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.function.Supplier;

public class AHFeatures {

    public static void init() {}

    public static final Supplier<Feature<SimpleTreeFeatureConfig>> SIMPLE_TREE =
            CommonPlatformHelper.registerFeature("simple_tree", () -> new SimpleTreeFeature(SimpleTreeFeatureConfig.CODEC));
    public static final Supplier<Feature<BoulderFeatureConfig>> BOULDER =
            CommonPlatformHelper.registerFeature("boulder", () -> new BoulderFeature(BoulderFeatureConfig.CODEC));
    public static final Supplier<Feature<NoneFeatureConfiguration>> TWISTED_TENDRIL =
            CommonPlatformHelper.registerFeature("twisted_tendril", () -> new TwistedTendrilFeature(NoneFeatureConfiguration.CODEC));

}
