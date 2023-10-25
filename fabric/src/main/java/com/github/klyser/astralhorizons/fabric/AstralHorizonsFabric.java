package com.github.klyser.astralhorizons.fabric;

import com.github.klyser.astralhorizons.AstralHorizons;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;

import java.util.Timer;
import java.util.TimerTask;

public class AstralHorizonsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        AstralHorizons.init();

        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    AstralHorizons.awardDragonDeadAdvancement(handler.player);
                }
            }, 1000);
        });
    }
}