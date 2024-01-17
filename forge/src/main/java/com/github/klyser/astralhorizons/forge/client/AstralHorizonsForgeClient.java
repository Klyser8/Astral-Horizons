package com.github.klyser.astralhorizons.forge.client;

import com.github.klyser.astralhorizons.registry.AHBlockColors;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class AstralHorizonsForgeClient {

    public static void subscribeClientEvents() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(AstralHorizonsForgeClient::onBlockColorsSetup);
        modEventBus.addListener(AstralHorizonsForgeClient::ClientSetup);

    }

    private static void onBlockColorsSetup(RegisterColorHandlersEvent.Block event) {
        event.register(AHBlockColors::getBlockColor, AHBlockColors.getAffectedBlocks());
    }

    private static void ClientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(AHBlocks.ANOMAGRASS_BLOCK.get(), RenderType.cutout());
    }

}
