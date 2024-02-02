package com.github.klyser.astralhorizons.client;

import com.github.klyser.astralhorizons.block.AnomalousGrassBlock;
import com.github.klyser.astralhorizons.network.AHPacketData;
import com.github.klyser.astralhorizons.platform.ClientPlatformHelper;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.GrassColor;

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

            if (blockState.getBlock() instanceof AnomalousGrassBlock) {
                if (blockAndTintGetter == null || blockPos == null) {
                    return GrassColor.getDefaultColor();
                }
                if (AHPacketData.wasDragonSlainOnce()) {
                    return 6846678;
                } else {
                    return BiomeColors.getAverageGrassColor(blockAndTintGetter, blockPos);
                }
            }

            return 0xFFFFFF;
        };
    }
}
