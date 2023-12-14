package com.github.klyser.astralhorizons.fabric;

import com.github.klyser.astralhorizons.AstralHorizons;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
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
                }
            }, 1000);
        });
        BlockRenderLayerMap.INSTANCE.putBlock(AHBlocks.ANOMALOUS_GRASS_BLOCK.get(), RenderType.cutout());
    }

    @Override
    public void onTerraBlenderInitialized() {
        AstralHorizons.initTerrablender().run();
    }
}