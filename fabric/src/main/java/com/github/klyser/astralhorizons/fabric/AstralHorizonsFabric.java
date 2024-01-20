package com.github.klyser.astralhorizons.fabric;

import com.github.klyser.astralhorizons.AstralHorizons;
import com.github.klyser.astralhorizons.network.EnderDragonStatusPacket;
import com.github.klyser.astralhorizons.platform.fabric.CommonPlatformHelperImpl;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import terrablender.api.TerraBlenderApi;

import java.util.Timer;
import java.util.TimerTask;

public class AstralHorizonsFabric implements ModInitializer, TerraBlenderApi {

    @Override
    public void onInitialize() {
        AstralHorizons.init();
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                AstralHorizons.awardDragonDeadAdvancement(handler.player);
                CommonPlatformHelperImpl.sendPacketToClient(new EnderDragonStatusPacket(server.getWorldData().endDragonFightData().dragonKilled()), EnderDragonStatusPacket.ID, handler.player);

            }
        }, 1000));
    }

    @Override
    public void onTerraBlenderInitialized() {
        AstralHorizons.initTerrablender();
    }
}