package com.github.klyser.astralhorizons.registry;

import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public final class AHTreeGrower {

    public static void init() {}

    public static final TreeGrower SCURANE_TREE = new TreeGrower("scurane", Optional.empty(), Optional.of(AHConfiguredFeatures.SCURANE_TREE), Optional.empty());

}
