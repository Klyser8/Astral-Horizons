package com.github.klyser.astralhorizons.platform.fabric;

import com.github.klyser.astralhorizons.AstralHorizons;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class CommonPlatformHelperImpl {

    public static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
        T registry = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(AstralHorizons.MOD_ID, name), item.get());
        return () -> registry; //TODO test item implementation
    }

}
