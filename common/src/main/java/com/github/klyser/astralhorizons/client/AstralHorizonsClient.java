package com.github.klyser.astralhorizons.client;

import com.github.klyser.astralhorizons.platform.ClientPlatformHelper;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.RenderType;

public class AstralHorizonsClient {

    public static void init() {
        ClientPlatformHelper.setBlockRenderType(AHBlocks.ANOMAGRASS_BLOCK.get(), RenderType.cutout());
        ClientPlatformHelper.setBlockRenderType(AHBlocks.ANOMALICE.get(), RenderType.translucent());
        ClientPlatformHelper.setBlockRenderType(AHBlocks.ANOMALOUS_SHORT_GRASS.get(), RenderType.translucent());
        ClientPlatformHelper.setBlockRenderType(AHBlocks.SICKENED_SHRUB.get(), RenderType.translucent());
        ClientPlatformHelper.setBlockRenderType(AHBlocks.SCURANE_TRAPDOOR.get(), RenderType.translucent());
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
