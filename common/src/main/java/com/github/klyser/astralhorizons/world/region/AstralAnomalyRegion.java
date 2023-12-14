package com.github.klyser.astralhorizons.world.region;

import com.github.klyser.astralhorizons.registry.AHBiomes;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import static terrablender.api.ParameterUtils.*;

public class AstralAnomalyRegion extends Region {
    public AstralAnomalyRegion(ResourceLocation name, RegionType type, int weight) {
        super(name, type, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
        new ParameterPointListBuilder()
                .temperature(Temperature.NEUTRAL)
                .humidity(Humidity.NEUTRAL)
                .continentalness(Continentalness.NEAR_INLAND, Continentalness.INLAND, Continentalness.MID_INLAND, Continentalness.FAR_INLAND)
                .erosion(Erosion.EROSION_2)
                .depth(Depth.SURFACE)
                .weirdness(Weirdness.MID_SLICE_VARIANT_ASCENDING)
                .build().forEach(point -> builder.add(point, AHBiomes.ASTRAL_ANOMALY));
        builder.build().forEach(mapper);
    }
}
