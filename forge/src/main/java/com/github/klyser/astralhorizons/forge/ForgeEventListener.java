package com.github.klyser.astralhorizons.forge;

import com.github.klyser.astralhorizons.platform.AHEventListenerHelper;
import com.github.klyser.astralhorizons.registry.AHTags;
import com.github.klyser.astralhorizons.registry.AHVillagerTrades;
import de.dafuqs.revelationary.api.revelations.RevelationAware;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.entity.npc.VillagerTrades.TreasureMapForEmeralds;

import java.util.List;
import java.util.Objects;

public class ForgeEventListener {

    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        AHEventListenerHelper.handlePlayerJoinEvent((ServerPlayer) event.getEntity(), Objects.requireNonNull(event.getEntity().getServer()));
    }

    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }
        AHEventListenerHelper.handleServerTickEvent(event.getServer());
    }

    @SubscribeEvent
    public void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
        AHEventListenerHelper.handlePlayerDisconnectEvent((ServerPlayer) event.getEntity());
    }

    @SubscribeEvent
    public void onRegisterVillagerTrade(VillagerTradesEvent event) {
        event.getTrades().put(5, AHVillagerTrades.ASTRAL_GATEWAY_TREASURE_MAP_FOR_EMERALDS);
    }

}
