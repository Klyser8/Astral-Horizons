package com.github.klyser.astralhorizons.fabric.client;

import com.github.klyser.astralhorizons.AstralHorizons;
import com.github.klyser.astralhorizons.client.AstralHorizonsClient;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import com.github.klyser.astralhorizons.util.AdvancementUtil;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.biome.Biomes;

public class AstralHorizonsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AstralHorizonsClient.init();
        registerBlockColors();
        BlockRenderLayerMap.INSTANCE.putBlock(AHBlocks.ANOMAGRASS_BLOCK.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AHBlocks.ANOMALICE.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AHBlocks.ANOMALOUS_SHORT_GRASS.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AHBlocks.SICKENED_SHRUB.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AHBlocks.SCURANE_TRAPDOOR.get(), RenderType.translucent());
    }

    public static void registerBlockColors() {
        ColorProviderRegistry.BLOCK.register(AstralHorizonsClient.registerBlockColors(), AHBlocks.ANOMALOUS_TINTED_BLOCKS);
    }
}
