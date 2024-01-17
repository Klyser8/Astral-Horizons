package com.github.klyser.astralhorizons.world.region;

import com.github.klyser.astralhorizons.registry.AHBiomes;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import static terrablender.api.ParameterUtils.*;

public class AstralAnomalyRegion extends Region {
    public AstralAnomalyRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
//        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.PLAINS, AHBiomes.FLUSHED_ASTRAL_ANOMALY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.MEADOW, AHBiomes.FLUSHED_ASTRAL_ANOMALY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.FOREST, AHBiomes.TWISTED_ASTRAL_ANOMALY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.BIRCH_FOREST, AHBiomes.TWISTED_ASTRAL_ANOMALY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.DARK_FOREST, AHBiomes.TWISTED_ASTRAL_ANOMALY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.BEACH, AHBiomes.ANOMALOUS_BEACH);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.RIVER, AHBiomes.ANOMALOUS_RIVER);
/*            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.JAGGED_PEAKS, AHBiomes.RUGGED_ASTRAL_ANOMALY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.ERODED_BADLANDS, AHBiomes.RUGGED_ASTRAL_ANOMALY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.LUSH_CAVES, AHBiomes.ANOMALOUS_DEPTHS);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.BADLANDS, AHBiomes.ERODED_ASTRAL_ANOMALY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.DESERT, AHBiomes.ERODED_ASTRAL_ANOMALY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SNOWY_PLAINS, AHBiomes.FRIGID_ASTRAL_ANOMALY);*/
        });
        // Flushed Astral Anomaly
        /*new ParameterPointListBuilder()
                .temperature(Temperature.NEUTRAL)
                .humidity(Humidity.NEUTRAL)
                .continentalness(Continentalness.MID_INLAND)
                .erosion(Erosion.EROSION_6)
                .weirdness(Weirdness.span(Weirdness.LOW_SLICE_VARIANT_ASCENDING, Weirdness.MID_SLICE_VARIANT_ASCENDING))
                .depth(Depth.SURFACE)
                .build().forEach(point -> builder.add(point, AHBiomes.FLUSHED_ASTRAL_ANOMALY));*/
        // Overgrown Astral Anomaly
        /*new ParameterPointListBuilder()
                .temperature(Temperature.WARM)
                .humidity(Humidity.WET)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.EROSION_3)
                .weirdness(Weirdness.span(Weirdness.PEAK_VARIANT, Weirdness.HIGH_SLICE_VARIANT_DESCENDING))
                .depth(Depth.SURFACE)
                .build().forEach(point -> builder.add(point, AHBiomes.OVERGROWN_ASTRAL_ANOMALY));
        // Rugged Astral Anomaly
        new ParameterPointListBuilder()
                .temperature(Temperature.COOL)
                .humidity(Humidity.DRY)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.EROSION_0)
                .weirdness(Weirdness.span(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.PEAK_NORMAL))
                .depth(Depth.SURFACE)
                .build().forEach(point -> builder.add(point, AHBiomes.RUGGED_ASTRAL_ANOMALY));
        // Eroded Astral Anomaly
        new ParameterPointListBuilder()
                .temperature(Temperature.HOT)
                .humidity(Humidity.ARID)
                .continentalness(Continentalness.FAR_INLAND)
                .erosion(Erosion.EROSION_5)
                .weirdness(Weirdness.HIGH_SLICE_VARIANT_ASCENDING)
                .depth(Depth.SURFACE)
                .build().forEach(point -> builder.add(point, AHBiomes.ERODED_ASTRAL_ANOMALY));
        // Frigid Astral Anomaly
        new ParameterPointListBuilder()
                .temperature(Temperature.ICY)
                .humidity(Humidity.NEUTRAL)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.EROSION_2)
                .weirdness(Weirdness.span(Weirdness.MID_SLICE_NORMAL_DESCENDING, Weirdness.LOW_SLICE_NORMAL_DESCENDING))
                .depth(Depth.SURFACE)
                .build().forEach(point -> builder.add(point, AHBiomes.FRIGID_ASTRAL_ANOMALY));
        // Anomalous Depths
        new ParameterPointListBuilder()
                .temperature(Temperature.COOL)
                .humidity(Humidity.NEUTRAL)
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.EROSION_0)
                .weirdness(Weirdness.FULL_RANGE)
                .depth(Depth.UNDERGROUND)
                .build().forEach(point -> builder.add(point, AHBiomes.ANOMALOUS_DEPTHS));*/

//        builder.build().forEach(mapper);
    }
}
