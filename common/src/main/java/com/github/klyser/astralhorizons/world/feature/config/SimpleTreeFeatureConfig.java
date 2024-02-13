package com.github.klyser.astralhorizons.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public record SimpleTreeFeatureConfig(
        List<ResourceLocation> crownStructureList, IntProvider trunkLength, BlockStateProvider trunkProvider, boolean randomRotation, boolean randomMirror)
        implements FeatureConfiguration {

    public static final Codec<SimpleTreeFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.listOf().fieldOf("crown_structures").forGetter(SimpleTreeFeatureConfig::crownStructureList),
            IntProvider.CODEC.fieldOf("trunk_length").forGetter(SimpleTreeFeatureConfig::trunkLength),
            BlockStateProvider.CODEC.fieldOf("trunk_provider").forGetter(SimpleTreeFeatureConfig::trunkProvider),
            Codec.BOOL.fieldOf("random_rotation").forGetter(SimpleTreeFeatureConfig::randomRotation),
            Codec.BOOL.fieldOf("random_mirror").forGetter(SimpleTreeFeatureConfig::randomMirror)
            ).apply(instance, SimpleTreeFeatureConfig::new)
    );

}
