package com.github.klyser.astralhorizons.fabric.datagen.tag;

import com.github.klyser.astralhorizons.AstralHorizons;
import com.github.klyser.astralhorizons.registry.AHBiomes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

import java.util.concurrent.CompletableFuture;

import static com.github.klyser.astralhorizons.registry.AHTags.IS_ANOMALOUS;

public class AHBiomeTagGenerator extends FabricTagProvider<Biome> {
    /**
     * Constructs a new {@link FabricTagProvider} with the default computed path.
     *
     * <p>Common implementations of this class are provided.
     *
     * @param output           the {@link FabricDataOutput} instance
     * @param registriesFuture the backing registry for the tag type
     */
    public AHBiomeTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.BIOME, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(BiomeTags.IS_OVERWORLD)
                .addOptional(AHBiomes.FLUSHED_ASTRAL_ANOMALY)
                .addOptional(AHBiomes.TWISTED_ASTRAL_ANOMALY)
                .addOptional(AHBiomes.RUGGED_ASTRAL_ANOMALY)
                .addOptional(AHBiomes.ERODED_ASTRAL_ANOMALY)
                .addOptional(AHBiomes.FRIGID_ASTRAL_ANOMALY)
                .addOptional(AHBiomes.ANOMALOUS_RIVER)
                .addOptional(AHBiomes.ANOMALOUS_BEACH);
        getOrCreateTagBuilder(IS_ANOMALOUS)
                .addOptional(AHBiomes.FLUSHED_ASTRAL_ANOMALY)
                .addOptional(AHBiomes.TWISTED_ASTRAL_ANOMALY)
                .addOptional(AHBiomes.RUGGED_ASTRAL_ANOMALY)
                .addOptional(AHBiomes.ERODED_ASTRAL_ANOMALY)
                .addOptional(AHBiomes.FRIGID_ASTRAL_ANOMALY)
                .addOptional(AHBiomes.ANOMALOUS_RIVER)
                .addOptional(AHBiomes.ANOMALOUS_BEACH);
    }
}
