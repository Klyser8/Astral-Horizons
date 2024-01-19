package com.github.klyser.astralhorizons.client;

import com.github.klyser.astralhorizons.registry.AHBlocks;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class AstralHorizonsClient {

    public static void init() {

    }

    public static BlockColor registerBlockColors() {
        return (blockState, blockAndTintGetter, blockPos, tintIndex) -> {
            if (blockAndTintGetter == null || blockPos == null) {
                System.out.println("Somethings wrong");
                return 0xAAAAAA;
            }
            if (blockPos.getX() % 2 == 0) {
                System.out.println("SKY!");
                return 0x444444;
            } else {
                System.out.println("No sky :(");
                return 0xFFFFFF;
            }
        };
    }
}
