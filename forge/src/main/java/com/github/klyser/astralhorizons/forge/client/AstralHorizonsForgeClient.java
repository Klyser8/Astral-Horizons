package com.github.klyser.astralhorizons.forge.client;

import com.github.klyser.astralhorizons.client.AstralHorizonsClient;
import com.github.klyser.astralhorizons.registry.AHBlockColors;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
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
        ItemBlockRenderTypes.setRenderLayer(AHBlocks.ANOMALOUS_GRASS_BLOCK.get(), RenderType.cutout());
    }

}
