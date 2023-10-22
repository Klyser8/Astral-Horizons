package com.github.klyser.astralhorizons.registry;

import com.github.klyser.astralhorizons.platform.CommonPlatformHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import java.util.function.Supplier;

public class AHItems {

    public static void register() {}

    public static final Supplier<Item> COSMIC_CRYSTAL = CommonPlatformHelper.registerItem(
            "cosmic_crystal", () -> new Item(new Item.Properties()
                    .rarity(Rarity.UNCOMMON)));

}
