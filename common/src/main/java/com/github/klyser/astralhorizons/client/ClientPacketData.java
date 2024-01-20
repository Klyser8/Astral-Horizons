package com.github.klyser.astralhorizons.client;

import com.github.klyser.astralhorizons.network.EnderDragonStatusPacket;

public class ClientPacketData {
    private ClientPacketData() {}

    private static boolean dragonDefeatedOnce = false;

    public static void handleDragonStatus(EnderDragonStatusPacket packet) {
        dragonDefeatedOnce = packet.dragonDefeatedOnce();
    }

    /**
     * Gets the status of the dragon.
     * @return true if the dragon is dead, false otherwise.
     */
    public static boolean isDragonDead() {
        return dragonDefeatedOnce;
    }

    public static void setDragonDead(boolean dragonDefeated) {
        ClientPacketData.dragonDefeatedOnce = dragonDefeated;
    }
}
