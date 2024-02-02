package com.github.klyser.astralhorizons.forge;

import com.github.klyser.astralhorizons.AstralHorizons;
import com.github.klyser.astralhorizons.network.AHPacketData;
import com.github.klyser.astralhorizons.network.EnderDragonStatusPacket;
import net.minecraftforge.network.ChannelBuilder;
import net.minecraftforge.network.SimpleChannel;

public class AHForgePacketHandler {

    private static final int PROTOCOL_VERSION = 1;
    public static final SimpleChannel INSTANCE = ChannelBuilder.named(AstralHorizons.id("main"))
            .networkProtocolVersion(PROTOCOL_VERSION)
            .simpleChannel();

    public static void init() {
        int id = 0; // Increment this for each packet
        INSTANCE.messageBuilder(EnderDragonStatusPacket.class, id)
                .decoder(EnderDragonStatusPacket::fromBytes)
                .encoder(EnderDragonStatusPacket::toBytes)
                .consumerMainThread((msg, ctx) -> AHPacketData.handleDragonStatus(msg))
                .add();
    }

}
