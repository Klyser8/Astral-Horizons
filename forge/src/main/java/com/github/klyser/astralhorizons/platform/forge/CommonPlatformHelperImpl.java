package com.github.klyser.astralhorizons.platform.forge;

import com.github.klyser.astralhorizons.AstralHorizons;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = AstralHorizons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonPlatformHelperImpl {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AstralHorizons.MOD_ID);

    public static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
        return ITEMS.register(name, item);
    }

}
