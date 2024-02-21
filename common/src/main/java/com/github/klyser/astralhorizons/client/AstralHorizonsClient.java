package com.github.klyser.astralhorizons.client;

import com.github.klyser.astralhorizons.block.vegetation.AnomalousGrassBlock;
import com.github.klyser.astralhorizons.network.AHPacketData;
import com.github.klyser.astralhorizons.platform.ClientPlatformHelper;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import com.github.klyser.astralhorizons.registry.AHTags;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;

public class AstralHorizonsClient {

    public static void init() {
        ClientPlatformHelper.setBlockRenderType(AHBlocks.ANOMAGRASS_BLOCK.get(), RenderType.cutout());
        ClientPlatformHelper.setBlockRenderType(AHBlocks.ANOMALICE.get(), RenderType.translucent());
        ClientPlatformHelper.setBlockRenderType(AHBlocks.ANOMALOUS_SHORT_GRASS.get(), RenderType.cutout());
        ClientPlatformHelper.setBlockRenderType(AHBlocks.SICKENED_SHRUB.get(), RenderType.cutout());
        ClientPlatformHelper.setBlockRenderType(AHBlocks.ANOMALOUS_SEAGRASS.get(), RenderType.cutout());
        ClientPlatformHelper.setBlockRenderType(AHBlocks.SCURANE_LEAVES.get(), RenderType.cutout());
        ClientPlatformHelper.setBlockRenderType(AHBlocks.ANOMALOUS_TALL_SEAGRASS.get(), RenderType.cutout());
        ClientPlatformHelper.setBlockRenderType(AHBlocks.TWISTED_TENDRIL_STEM.get(), RenderType.cutout());
        ClientPlatformHelper.setBlockRenderType(AHBlocks.TWISTED_TENDRIL_HEAD.get(), RenderType.cutout());
        ClientPlatformHelper.setBlockRenderType(AHBlocks.SCURANE_SAPLING.get(), RenderType.cutout());
        ClientPlatformHelper.setBlockRenderType(AHBlocks.SCURANE_LIGHTS.get(), RenderType.translucent());
        ClientPlatformHelper.setBlockRenderType(AHBlocks.SCURANE_TRAPDOOR.get(), RenderType.cutout());
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
            if (blockState.is(AHTags.ANOMALOUS_VEGETATION)) {
                if (blockAndTintGetter == null || blockPos == null) {
                    return FoliageColor.getDefaultColor();
                }
                if (AHPacketData.wasDragonSlainOnce()) {
                    if (blockState.is(AHBlocks.SICKENED_SHRUB.get()) ||
                            blockState.is(AHBlocks.ANOMALOUS_SHORT_GRASS.get())) {
                        return 6846678;
                    }
                    if (blockState.is(AHBlocks.SCURANE_LEAVES.get()) ||
                            blockState.is(AHBlocks.SCURANE_LIGHTS.get())) { //Scurane lights shouldnt blink but they do.
                        return 0xFFA26D;
                    }
                } else {
                    return BiomeColors.getAverageFoliageColor(blockAndTintGetter, blockPos);
                }
            }
            return 0xFFFFFF;
        };
    }
}
