package com.github.klyser.astralhorizons.fabric.datagen.tag;

import com.github.klyser.astralhorizons.AstralHorizons;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

import java.util.concurrent.CompletableFuture;

public class AHBiomeTagGenerator extends BiomeTagsProvider {

    private static final TagKey<Biome> AH_BIOMES = TagKey.create(Registries.BIOME, new ResourceLocation(AstralHorizons.MOD_ID, "biomes"));
    public AHBiomeTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(packOutput, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(AH_BIOMES).add(ResourceKey.create(Registries.BIOME, new ResourceLocation("astralhorizons:astral_anomaly")));
    }
}
