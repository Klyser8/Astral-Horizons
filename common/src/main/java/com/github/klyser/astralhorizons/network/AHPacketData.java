package com.github.klyser.astralhorizons.network;

public class AHPacketData {
    private AHPacketData() {}

    private static boolean dragonSlainOnce = false;

    public static void handleDragonStatus(EnderDragonStatusPacket packet) {
        dragonSlainOnce = packet.dragonDefeatedOnce();
    }

    /**
     * Gets the status of the dragon.
     * @return true if the dragon is dead, false otherwise.
     */
    public static boolean wasDragonSlainOnce() {
        return dragonSlainOnce;
    }

    public static void setDragonDead(boolean dragonDefeated) {
        AHPacketData.dragonSlainOnce = dragonDefeated;
    }
}
