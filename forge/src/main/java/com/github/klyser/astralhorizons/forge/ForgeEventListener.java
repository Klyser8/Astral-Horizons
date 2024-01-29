package com.github.klyser.astralhorizons.forge;

import com.github.klyser.astralhorizons.platform.AHEventListenerHelper;
import de.dafuqs.revelationary.api.revelations.RevelationAware;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

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

}
