package com.github.klyser.astralhorizons.registry;

import com.github.klyser.astralhorizons.platform.CommonPlatformHelper;
import com.github.klyser.astralhorizons.world.structure.ModifiedConcentricRingsStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;

import java.util.function.Supplier;

public class AHStructurePlacementType<SP extends StructurePlacement> {

    public static void init() {}

    public static final Supplier<StructurePlacementType<ModifiedConcentricRingsStructurePlacement>> MODIFIED_CONCENTRIC_RINGS =
            CommonPlatformHelper.registerPlacementType("modified_concentric_rings", () -> () -> ModifiedConcentricRingsStructurePlacement.CODEC);


}
