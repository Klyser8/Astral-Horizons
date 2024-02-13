package com.github.klyser.astralhorizons.registry;

import com.github.klyser.astralhorizons.AstralHorizons;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class AHTags {

    //MINECRAFT - BLOCKS
    public static final TagKey<Block> MINEABLE_PICKAXE = TagKey.create(Registries.BLOCK, new ResourceLocation("minecraft:mineable/pickaxe"));
    public static final TagKey<Block> MINEABLE_SHOVEL = TagKey.create(Registries.BLOCK, new ResourceLocation("minecraft:mineable/shovel"));
    public static final TagKey<Block> MINEABLE_AXE = TagKey.create(Registries.BLOCK, new ResourceLocation("minecraft:mineable/axe"));
    public static final TagKey<Block> MINEABLE_HOE = TagKey.create(Registries.BLOCK, new ResourceLocation("minecraft:mineable/hoe"));
    public static final TagKey<Block> WALLS = TagKey.create(Registries.BLOCK, new ResourceLocation("minecraft:walls"));

    //ASTRAL HORIZONS - BLOCKS
    public static final TagKey<Block> ANOMALOUS_DIRT = TagKey.create(Registries.BLOCK, AstralHorizons.id("is_anomalous_dirt"));
    public static final TagKey<Block> ANOMALOUS_VEGETATION = TagKey.create(Registries.BLOCK, AstralHorizons.id("is_anomalous_vegetation"));

    //ASTRAL HORIZONS - BIOMES
    public static final TagKey<Biome> IS_ANOMALOUS = TagKey.create(Registries.BIOME, AstralHorizons.id("is_anomalous"));

}
