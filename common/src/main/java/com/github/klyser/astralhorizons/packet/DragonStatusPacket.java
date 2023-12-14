package com.github.klyser.astralhorizons.packet;

import net.minecraft.resources.ResourceLocation;

public class DragonStatusPacket {
    private static final ResourceLocation ID = new ResourceLocation("astralhorizons", "dragon_status");
    private final boolean dragonDefeated;

    public DragonStatusPacket(boolean dragonDefeated) {
        this.dragonDefeated = dragonDefeated;
    }

    public boolean isDragonDefeated() {
        return dragonDefeated;
    }

    public static ResourceLocation getId() {

        return ID;
    }

}
