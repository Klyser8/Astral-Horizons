package com.github.klyser.astralhorizons.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

import java.util.List;

public record BoulderFeatureConfig(
        List<ResourceLocation> boulderNbts, WeightedStateProvider saltAndPepperBlocks, boolean randomRotation, boolean randomMirror)
        implements FeatureConfiguration {

    public static final Codec<BoulderFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.listOf().fieldOf("boulder_structures").forGetter(BoulderFeatureConfig::boulderNbts),
            WeightedStateProvider.CODEC.fieldOf("rock_providers").forGetter(BoulderFeatureConfig::saltAndPepperBlocks),
            Codec.BOOL.fieldOf("random_rotation").forGetter(BoulderFeatureConfig::randomRotation),
            Codec.BOOL.fieldOf("random_mirror").forGetter(BoulderFeatureConfig::randomMirror)
            ).apply(instance, BoulderFeatureConfig::new)
    );


}
