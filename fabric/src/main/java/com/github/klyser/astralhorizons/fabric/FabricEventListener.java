package com.github.klyser.astralhorizons.fabric;

import com.github.klyser.astralhorizons.platform.AHEventListenerHelper;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;

/**
 * This class contains methods containing registration logic for Fabric event listeners.
 * Any time you register a new event listener, the containing method should be called in {@link AstralHorizonsFabric#onInitialize()}
 */
public class FabricEventListener {

    private FabricEventListener() {}

    public static void initPlayerJoinListener() {
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> AHEventListenerHelper.handlePlayerJoinEvent(handler.player, server));
    }

    public static void initServerTickListener() {
        ServerTickEvents.END_SERVER_TICK.register(AHEventListenerHelper::handleServerTickEvent);
    }

    public static void initPlayerDisconnectListener() {
        ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> AHEventListenerHelper.handlePlayerDisconnectEvent(handler.player));
    }

}
