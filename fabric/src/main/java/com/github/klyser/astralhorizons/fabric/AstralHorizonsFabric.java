package com.github.klyser.astralhorizons.fabric;

import com.github.klyser.astralhorizons.AstralHorizons;
import de.dafuqs.revelationary.api.revelations.RevelationAware;
import net.fabricmc.api.ModInitializer;
import terrablender.api.TerraBlenderApi;

public class AstralHorizonsFabric implements ModInitializer, TerraBlenderApi {

    @Override
    public void onInitialize() {
        AstralHorizons.init();
        FabricEventListener.initPlayerJoinListener();
        FabricEventListener.initServerTickListener();
        FabricEventListener.initPlayerDisconnectListener();
    }

    @Override
    public void onTerraBlenderInitialized() {
        AstralHorizons.initTerrablender();
    }
}