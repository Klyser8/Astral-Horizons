package com.github.klyser.astralhorizons.forge.client;

import com.github.klyser.astralhorizons.client.AstralHorizonsClient;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class AstralHorizonsForgeClient {

    public static void subscribeClientEvents() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(AstralHorizonsForgeClient::clientSetup);
        modEventBus.addListener(AstralHorizonsForgeClient::registerBlockColors);
    }

    private static void clientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(AHBlocks.ANOMAGRASS_BLOCK.get(), RenderType.cutout());
    }

    private static void registerBlockColors(final RegisterColorHandlersEvent.Block event) {
        event.register(AstralHorizonsClient.registerBlockColors(), AHBlocks.ANOMALOUS_TINTED_BLOCKS);
    }

}
