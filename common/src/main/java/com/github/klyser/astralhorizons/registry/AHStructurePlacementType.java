package com.github.klyser.astralhorizons.registry;

import com.github.klyser.astralhorizons.platform.CommonPlatformHelper;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;

import java.util.function.Supplier;

public class AHStructurePlacementType<SP extends StructurePlacement> {

    public static void init() {}

    public static final Supplier<StructurePlacementType<RandomSpreadStructurePlacement>> TEST_PLACEMENT = CommonPlatformHelper.registerPlacementType("test_placement", () -> () -> RandomSpreadStructurePlacement.CODEC);


}
