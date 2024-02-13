package com.github.klyser.astralhorizons.network;

import net.minecraft.network.FriendlyByteBuf;

/**
 * Thank you, @lilycurlee, for your help! <3
 */
public interface AHPacket {

    void toBytes(FriendlyByteBuf buffer);

}
