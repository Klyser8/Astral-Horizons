package com.github.klyser.astralhorizons.fabric.datagen.tag;

import com.github.klyser.astralhorizons.registry.AHBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class AHBlockTagGenerator extends FabricTagProvider.BlockTagProvider {

    //MINECRAFT
    private static final TagKey<Block> MINEABLE_PICKAXE = TagKey.create(Registries.BLOCK, new ResourceLocation("minecraft:mineable/pickaxe"));
    private static final TagKey<Block> WALLS = TagKey.create(Registries.BLOCK, new ResourceLocation("minecraft:walls"));

    //ASTRAL HORIZONS

    public AHBlockTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }


    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(MINEABLE_PICKAXE)
                .add(AHBlocks.ANOMALOUS_COBBLESTONE.get())
                .add(AHBlocks.ANOMALOUS_STONE.get())
                .add(AHBlocks.ANOMALOUS_STONE_BRICKS.get())
                .add(AHBlocks.ANOMALOUS_STONE_BRICK_STAIRS.get())
                .add(AHBlocks.ANOMALOUS_STONE_BRICK_SLAB.get())
                .add(AHBlocks.ANOMALOUS_STONE_BRICK_WALL.get())
                .add(AHBlocks.CHISELED_ANOMALOUS_STONE_BRICKS.get());
        getOrCreateTagBuilder(WALLS)
                .add(AHBlocks.ANOMALOUS_COBBLESTONE_WALL.get());
    }
}
