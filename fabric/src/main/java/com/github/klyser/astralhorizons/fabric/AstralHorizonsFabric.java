package com.github.klyser.astralhorizons.fabric;

import com.github.klyser.astralhorizons.AstralHorizons;
import com.github.klyser.astralhorizons.registry.AHTags;
import com.github.klyser.astralhorizons.registry.AHVillagerTrades;
import de.dafuqs.revelationary.api.revelations.RevelationAware;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import terrablender.api.TerraBlenderApi;

public class AstralHorizonsFabric implements ModInitializer, TerraBlenderApi {

    @Override
    public void onInitialize() {
        AstralHorizons.init();
        FabricEventListener.initPlayerJoinListener();
        FabricEventListener.initServerTickListener();
        FabricEventListener.initPlayerDisconnectListener();
        registerVillagerTradeOffers();
    }

    @Override
    public void onTerraBlenderInitialized() {
        AstralHorizons.initTerrablender();
    }

    private void registerVillagerTradeOffers() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CARTOGRAPHER,
                5, list -> list.addAll(AHVillagerTrades.ASTRAL_GATEWAY_TREASURE_MAP_FOR_EMERALDS));
    }
}