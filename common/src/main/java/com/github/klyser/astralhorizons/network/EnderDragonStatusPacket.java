package com.github.klyser.astralhorizons.network;

import com.github.klyser.astralhorizons.AstralHorizons;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

/**
 * Thank you, @lilycurlee, for your help! <3
 * This is the packet that is sent to the client to tell it whether the dragon is dead or not.
 */
public record EnderDragonStatusPacket(boolean dragonDefeatedOnce) implements AHPacket {
    public static final ResourceLocation ID = AstralHorizons.id("dragon_status");

    @Override
    public void toBytes(FriendlyByteBuf buffer) {
        buffer.writeBoolean(dragonDefeatedOnce);
    }

    public static EnderDragonStatusPacket fromBytes(FriendlyByteBuf buf) {
        boolean dragonDefeated = buf.readBoolean();
        return new EnderDragonStatusPacket(dragonDefeated);
    }
}
