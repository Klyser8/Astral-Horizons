package com.github.klyser.astralhorizons.fabric.client;

import com.github.klyser.astralhorizons.client.AstralHorizonsClient;
import com.github.klyser.astralhorizons.network.AHPacketData;
import com.github.klyser.astralhorizons.network.EnderDragonStatusPacket;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;

public class AstralHorizonsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AstralHorizonsClient.init();
        registerBlockColors();

        ClientPlayNetworking.registerGlobalReceiver(EnderDragonStatusPacket.ID,
                (client, handler, buf, responseSender) ->
                        client.execute(() -> AHPacketData.setDragonDead(buf.readBoolean())));
    }

    public static void registerBlockColors() {
        ColorProviderRegistry.BLOCK.register(AstralHorizonsClient.registerBlockColors(), AHBlocks.getAHTintedBlocks());
    }
}
