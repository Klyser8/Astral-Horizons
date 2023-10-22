package com.github.klyser.astralhorizons.forge;

import com.github.klyser.astralhorizons.AstralHorizons;
import com.github.klyser.astralhorizons.platform.forge.CommonPlatformHelperImpl;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AstralHorizons.MOD_ID)
public class AstralHorizonsForge {
    public AstralHorizonsForge() {
        AstralHorizons.init();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        CommonPlatformHelperImpl.ITEMS.register(bus);
    }
}