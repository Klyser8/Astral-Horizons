package com.github.klyser.astralhorizons.platform;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class CommonPlatformHelper {

    @ExpectPlatform
    public static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
        throw new AssertionError();
    }

}
