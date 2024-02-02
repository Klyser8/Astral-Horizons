package com.github.klyser.astralhorizons.platform;

import com.github.klyser.astralhorizons.AstralHorizons;
import com.github.klyser.astralhorizons.data.AstralHorizonsServerData;
import com.github.klyser.astralhorizons.network.EnderDragonStatusPacket;
import com.github.klyser.astralhorizons.util.AdvancementUtil;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;

import java.util.HashMap;
import java.util.Map;

public class AHEventListenerHelper {

    public static final Map<ServerPlayer, Long> playerJoinGameTimeMap = new HashMap<>();

    public static void handlePlayerJoinEvent(ServerPlayer player, MinecraftServer server) {
        AstralHorizonsServerData data = AstralHorizonsServerData.getOrCreate(server);
        if (data == null) {
            AstralHorizons.LOGGER.warn("Server data is null, cannot handle player join event.");
            return;
        }
        boolean dragonUndefeated = !data.dragonSlainOnce();
        if (dragonUndefeated) {
            return;
        }
        playerJoinGameTimeMap.put(player, server.getWorldData().overworldData().getGameTime());
        CommonPlatformHelper.sendPacketToClient(new EnderDragonStatusPacket(data.dragonSlainOnce()),
                EnderDragonStatusPacket.ID, player);
    }

    public static void handleServerTickEvent(MinecraftServer server) {
        if (playerJoinGameTimeMap.isEmpty()) {
            return;
        }
        AstralHorizonsServerData data = AstralHorizonsServerData.getOrCreate(server);
        if (data == null) {
            AstralHorizons.LOGGER.warn("Server data is null, cannot handle server tick event.");
            return;
        }
        boolean dragonUndefeated = !data.dragonSlainOnce();
        if (dragonUndefeated) {
            return;
        }
        for (ServerPlayer player : playerJoinGameTimeMap.keySet()) {
            if (server.getWorldData().overworldData().getGameTime() - playerJoinGameTimeMap.get(player) > 100) {
                AdvancementUtil.completeAdvancement(player, AstralHorizons.id( "dragon_dead"), "tick");
                playerJoinGameTimeMap.remove(player);
            }
        }
    }

    public static void handlePlayerDisconnectEvent(ServerPlayer player) {
        playerJoinGameTimeMap.remove(player);
    }

}
