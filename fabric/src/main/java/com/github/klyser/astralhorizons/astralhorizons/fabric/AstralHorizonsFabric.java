package com.github.klyser.astralhorizons.astralhorizons.fabric;

import com.github.klyser.astralhorizons.astralhorizons.AstralHorizons;
import net.fabricmc.api.ModInitializer;

public class AstralHorizonsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        AstralHorizons.init();
    }
}