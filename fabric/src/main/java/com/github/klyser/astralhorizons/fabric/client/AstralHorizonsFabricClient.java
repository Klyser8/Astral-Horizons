package com.github.klyser.astralhorizons.fabric.client;

import com.github.klyser.astralhorizons.client.AstralHorizonsClient;
import com.github.klyser.astralhorizons.registry.AHBlockColors;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.RenderType;

public class AstralHorizonsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AstralHorizonsClient.init();
        registerBlockColors();
        BlockRenderLayerMap.INSTANCE.putBlock(AHBlocks.ANOMAGRASS_BLOCK.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AHBlocks.ANOMALICE.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AHBlocks.ANOMALOUS_SHORT_GRASS.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AHBlocks.SICKENED_SHRUB.get(), RenderType.translucent());
        System.out.println("CLIENT INIT");
    }

    public static void registerBlockColors() {
        BlockColors blockColors = new BlockColors();
        blockColors.register(AHBlockColors::getBlockColor, AHBlockColors.getAffectedBlocks());
    }
}
