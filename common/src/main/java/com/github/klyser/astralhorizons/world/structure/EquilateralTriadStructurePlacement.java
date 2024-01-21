package com.github.klyser.astralhorizons.world.structure;

import net.minecraft.core.Vec3i;
import net.minecraft.world.level.chunk.ChunkGeneratorStructureState;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;

import java.util.Optional;

public class EquilateralTriadStructurePlacement extends StructurePlacement {
    protected EquilateralTriadStructurePlacement(Vec3i locateOffset, FrequencyReductionMethod frequencyReductionMethod, float frequency, int salt, Optional<ExclusionZone> exclusionZone) {
        super(locateOffset, frequencyReductionMethod, frequency, salt, exclusionZone);
    }

    @Override
    protected boolean isPlacementChunk(ChunkGeneratorStructureState structureState, int x, int z) {
        return false;
    }

    @Override
    public StructurePlacementType<?> type() {
        return null;
    }
}
