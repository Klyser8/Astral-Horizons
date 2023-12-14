package com.github.klyser.astralhorizons.forge;

import com.github.klyser.astralhorizons.AstralHorizons;
import com.github.klyser.astralhorizons.client.AstralHorizonsClient;
import com.github.klyser.astralhorizons.forge.client.AstralHorizonsForgeClient;
import com.github.klyser.astralhorizons.platform.forge.CommonPlatformHelperImpl;
import com.github.klyser.astralhorizons.util.AdvancementUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.dimension.end.EndDragonFight;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(AstralHorizons.MOD_ID)
public class AstralHorizonsForge {

    public AstralHorizonsForge() {
        AstralHorizons.init();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        CommonPlatformHelperImpl.ITEMS.register(bus);
        CommonPlatformHelperImpl.CREATIVE_MODE_TABS.register(bus);
        CommonPlatformHelperImpl.BLOCKS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
        bus.addListener(this::commonSetup);

        if (FMLEnvironment.dist.isClient()) {
            AstralHorizonsForgeClient.subscribeClientEvents();
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(AstralHorizons::initTerrablender);
    }

    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        AstralHorizons.awardDragonDeadAdvancement(player);
    }
}