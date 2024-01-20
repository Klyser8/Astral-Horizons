package com.github.klyser.astralhorizons.forge;

import com.github.klyser.astralhorizons.AstralHorizons;
import com.github.klyser.astralhorizons.forge.client.AstralHorizonsForgeClient;
import com.github.klyser.astralhorizons.platform.forge.CommonPlatformHelperImpl;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

import static com.github.klyser.astralhorizons.AstralHorizons.MOD_ID;

@Mod(MOD_ID)
public class AstralHorizonsForge {

    public AstralHorizonsForge() {
        AstralHorizons.init();
        AHForgePacketHandler.init();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        CommonPlatformHelperImpl.ITEMS.register(bus);
        CommonPlatformHelperImpl.CREATIVE_MODE_TABS.register(bus);
        CommonPlatformHelperImpl.BLOCKS.register(bus);
        MinecraftForge.EVENT_BUS.register(new ForgeEventListener());

        if (FMLEnvironment.dist.isClient()) {
            AstralHorizonsForgeClient.subscribeClientEvents();
        }
        bus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(AstralHorizons::initTerrablender);
    }
}