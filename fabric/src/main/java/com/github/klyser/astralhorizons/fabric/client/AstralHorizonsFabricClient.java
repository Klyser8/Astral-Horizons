package com.github.klyser.astralhorizons.fabric.client;

import com.github.klyser.astralhorizons.client.AstralHorizonsClient;
import com.github.klyser.astralhorizons.registry.AHBlockColors;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.color.block.BlockColors;

public class AstralHorizonsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AstralHorizonsClient.init();
        registerBlockColors();
    }

    public static void registerBlockColors() {
        BlockColors blockColors = new BlockColors();
        blockColors.register(AHBlockColors::getBlockColor, AHBlockColors.getAffectedBlocks());
    }
}
