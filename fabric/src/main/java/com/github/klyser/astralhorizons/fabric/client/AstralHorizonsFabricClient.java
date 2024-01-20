package com.github.klyser.astralhorizons.fabric.client;

import com.github.klyser.astralhorizons.client.AstralHorizonsClient;
import com.github.klyser.astralhorizons.client.ClientPacketData;
import com.github.klyser.astralhorizons.network.EnderDragonStatusPacket;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
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
        BlockRenderLayerMap.INSTANCE.putBlock(AHBlocks.SCURANE_TRAPDOOR.get(), RenderType.translucent());

        ClientPlayNetworking.registerGlobalReceiver(EnderDragonStatusPacket.ID,
                (client, handler, buf, responseSender) ->
                        client.execute(() -> ClientPacketData.setDragonDead(buf.readBoolean())));
    }

    public static void registerBlockColors() {
        ColorProviderRegistry.BLOCK.register(AstralHorizonsClient.registerBlockColors(), AHBlocks.getAnomalousTintedBlocks());
    }
}
