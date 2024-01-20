package com.github.klyser.astralhorizons.client;

import net.minecraft.client.color.block.BlockColor;

public class AstralHorizonsClient {

    public static void init() {

    }

    public static BlockColor registerBlockColors() {
        return (blockState, blockAndTintGetter, blockPos, tintIndex) -> {
            if (blockAndTintGetter == null || blockPos == null) {
                System.out.println("Somethings wrong");
                return 0xAAAAAA;
            }
            if (ClientPacketData.isDragonDead()) {
                System.out.println("SKY!");
                return 0x444444;
            } else {
                System.out.println("No sky :(");
                return 0xFFFFFF;
            }
        };
    }
}
