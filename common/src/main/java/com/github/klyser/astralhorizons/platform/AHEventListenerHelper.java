package com.github.klyser.astralhorizons.platform;

import com.github.klyser.astralhorizons.AstralHorizons;
import com.github.klyser.astralhorizons.network.EnderDragonStatusPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;

import java.util.HashMap;
import java.util.Map;

public class AHEventListenerHelper {

    public static final Map<ServerPlayer, Long> playerJoinGameTimeMap = new HashMap<>();

    public static void handlePlayerJoinEvent(ServerPlayer player, MinecraftServer server) {
        playerJoinGameTimeMap.put(player, server.getWorldData().overworldData().getGameTime());
        CommonPlatformHelper.sendPacketToClient(new EnderDragonStatusPacket(server.getWorldData().endDragonFightData().dragonKilled()),
                EnderDragonStatusPacket.ID, player);
    }

    public static void handleServerTickEvent(MinecraftServer server) {
        if (playerJoinGameTimeMap.isEmpty()) return;
        for (ServerPlayer player : playerJoinGameTimeMap.keySet()) {
            if (server.getWorldData().overworldData().getGameTime() - playerJoinGameTimeMap.get(player) > 100) {
                AstralHorizons.awardDragonDeadAdvancement(player);
                playerJoinGameTimeMap.remove(player);
            }
        }
    }

    public static void handlePlayerDisconnectEvent(ServerPlayer player) {
        playerJoinGameTimeMap.remove(player);
    }

}
