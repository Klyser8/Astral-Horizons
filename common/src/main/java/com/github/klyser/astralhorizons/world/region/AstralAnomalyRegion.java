package com.github.klyser.astralhorizons.world.region;

import com.github.klyser.astralhorizons.registry.AHBiomes;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

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
        });
    }
}
