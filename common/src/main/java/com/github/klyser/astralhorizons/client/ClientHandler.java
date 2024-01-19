package com.github.klyser.astralhorizons.client;

import com.github.klyser.astralhorizons.network.EnderDragonStatusPacket;

public class ClientHandler {
    private ClientHandler() {}

    private static boolean dragonDefeated = false;

    public static void handleDragonStatus(EnderDragonStatusPacket packet) {
        dragonDefeated = packet.dragonDefeated();
    }

    /**
     * Gets the status of the dragon.
     * @return true if the dragon is dead, false otherwise.
     */
    public static boolean isDragonDead() {
        return dragonDefeated;
    }

}
