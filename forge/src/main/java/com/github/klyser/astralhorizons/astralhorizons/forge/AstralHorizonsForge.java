package com.github.klyser.astralhorizons.astralhorizons.forge;

import com.github.klyser.astralhorizons.astralhorizons.AstralHorizons;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AstralHorizons.MOD_ID)
public class AstralHorizonsForge {
    public AstralHorizonsForge() {
        AstralHorizons.init();
    }
}