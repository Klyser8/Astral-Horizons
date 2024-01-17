package com.github.klyser.astralhorizons.platform.fabric;

import com.github.klyser.astralhorizons.AstralHorizons;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;

import java.util.function.Supplier;

public class CommonPlatformHelperImpl {

    public static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
        T registry = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(AstralHorizons.MOD_ID, name), item.get());
        return () -> registry;
    }

    public static <T extends CreativeModeTab> Supplier<T> registerCreativeTab(String name, Supplier<T> tab) {
        T registry = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(AstralHorizons.MOD_ID, name), tab.get());
        return () -> registry;
    }

    public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        T registry = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(AstralHorizons.MOD_ID, name), block.get());
        return () -> registry;
    }

    public static <T extends SoundEvent> Supplier<T> registerSoundEvent(String name, Supplier<T> soundEvent) {
        T registry = Registry.register(BuiltInRegistries.SOUND_EVENT, new ResourceLocation(AstralHorizons.MOD_ID, name), soundEvent.get());
        return () -> registry;
    }

    public static <T extends Feature<?>> Supplier<T> registerFeature(String name, Supplier<T> feature) {
        T registry = Registry.register(BuiltInRegistries.FEATURE, new ResourceLocation(AstralHorizons.MOD_ID, name), feature.get());
        return () -> registry;
    }

}
