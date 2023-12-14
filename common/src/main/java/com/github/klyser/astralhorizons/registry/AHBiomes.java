package com.github.klyser.astralhorizons.registry;

import com.github.klyser.astralhorizons.AstralHorizons;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class AHBiomes {

    public static final ResourceKey<Biome> ASTRAL_ANOMALY = register("astral_anomaly");

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(AstralHorizons.MOD_ID, name));
    }

}
