package com.github.klyser.astralhorizons.registry;

import com.github.klyser.astralhorizons.AstralHorizons;
import com.github.klyser.astralhorizons.platform.CommonPlatformHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

import java.util.function.Supplier;

import static com.github.klyser.astralhorizons.platform.CommonPlatformHelper.registerCreativeTab;

public class AHCreativeModeTabs {

    public static void init() {

    }

    public static final Supplier<CreativeModeTab> ITEMS = registerCreativeTab("items",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                    .title(Component.translatable("itemGroup." + AstralHorizons.MOD_ID + ".items"))
                    .icon(() -> AHItems.COSMIC_CRYSTAL.get().getDefaultInstance())
                    .displayItems((features, entries) -> {
                        entries.accept(AHItems.COSMIC_CRYSTAL.get());
                    }).build()
    );

    public static final Supplier<CreativeModeTab> BLOCKS = registerCreativeTab("blocks",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                    .title(Component.translatable("itemGroup." + AstralHorizons.MOD_ID + ".blocks"))
                    .icon(() -> AHItems.ANOMALOUS_DIRT.get().getDefaultInstance())
                    .displayItems((features, entries) -> {
                        entries.accept(AHItems.ANOMALOUS_DIRT.get());
                    }).build()
    );

}
