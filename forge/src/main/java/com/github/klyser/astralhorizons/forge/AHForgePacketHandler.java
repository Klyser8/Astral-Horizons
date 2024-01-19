package com.github.klyser.astralhorizons.forge;

import com.github.klyser.astralhorizons.AstralHorizons;
import com.github.klyser.astralhorizons.client.ClientHandler;
import com.github.klyser.astralhorizons.network.EnderDragonStatusPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class AHForgePacketHandler {

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(AstralHorizons.MOD_ID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void init() {
        int id = 0;
        INSTANCE.messageBuilder(EnderDragonStatusPacket.class, id++)
                .decoder(EnderDragonStatusPacket::fromBytes)
                .encoder(EnderDragonStatusPacket::toBytes)
                .consumerMainThread((msg, ctx) -> ClientHandler.handleDragonStatus(msg))
                .add();
    }

}
