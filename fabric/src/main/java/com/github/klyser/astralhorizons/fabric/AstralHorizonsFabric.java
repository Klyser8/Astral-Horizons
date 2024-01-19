package com.github.klyser.astralhorizons.fabric;

import com.github.klyser.astralhorizons.AstralHorizons;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import com.github.klyser.astralhorizons.registry.AHNetworkingConstants;
import io.netty.buffer.ByteBuf;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import terrablender.api.TerraBlenderApi;

import java.util.Timer;
import java.util.TimerTask;

public class AstralHorizonsFabric implements ModInitializer, TerraBlenderApi {

    @Override
    public void onInitialize() {
        AstralHorizons.init();
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    AstralHorizons.awardDragonDeadAdvancement(handler.player);
                    ByteBuf byteBuf = PacketByteBufs.create().writeBoolean(server.getWorldData().endDragonFightData().dragonKilled());
                    ServerPlayNetworking.send(handler.player, AHNetworkingConstants.ENDER_DRAGON_DEFEAT_PACKET_ID, new FriendlyByteBuf(byteBuf));
                }
            }, 1000);
        });
    }

    @Override
    public void onTerraBlenderInitialized() {
        AstralHorizons.initTerrablender();
    }
}