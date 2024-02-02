package com.github.klyser.astralhorizons.registry;

import com.github.klyser.astralhorizons.AstralHorizons;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class AHBiomes {

    public static final ResourceKey<Biome> FLUSHED_ASTRAL_ANOMALY = register("flushed_astral_anomaly");
    public static final ResourceKey<Biome> TWISTED_ASTRAL_ANOMALY = register("twisted_astral_anomaly");
    public static final ResourceKey<Biome> ANOMALOUS_BEACH = register("anomalous_beach");
    public static final ResourceKey<Biome> ANOMALOUS_RIVER = register("anomalous_river");
    public static final ResourceKey<Biome> RUGGED_ASTRAL_ANOMALY = register("rugged_astral_anomaly");
    public static final ResourceKey<Biome> ERODED_ASTRAL_ANOMALY = register("eroded_astral_anomaly");
    public static final ResourceKey<Biome> FRIGID_ASTRAL_ANOMALY = register("frigid_astral_anomaly");

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, AstralHorizons.id( name));
    }

}
