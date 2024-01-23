package com.github.klyser.astralhorizons.world.structure;

import com.github.klyser.astralhorizons.registry.AHStructurePlacementType;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkGeneratorStructureState;
import net.minecraft.world.level.levelgen.structure.placement.*;

import java.util.List;
import java.util.Optional;

public class ModifiedConcentricRingsStructurePlacement extends ConcentricRingsStructurePlacement {

    public static final Codec<ModifiedConcentricRingsStructurePlacement> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            Codec.INT.fieldOf("salt").forGetter(ModifiedConcentricRingsStructurePlacement::salt),
            Codec.INT.fieldOf("distance").forGetter(ModifiedConcentricRingsStructurePlacement::distance),
            Codec.INT.fieldOf("spread").forGetter(ModifiedConcentricRingsStructurePlacement::spread),
            Codec.intRange(1, 512).fieldOf("count").forGetter(ModifiedConcentricRingsStructurePlacement::count),
            Codec.INT.optionalFieldOf("offset_x").forGetter(ModifiedConcentricRingsStructurePlacement::offsetX),
            Codec.INT.optionalFieldOf("offset_z").forGetter(ModifiedConcentricRingsStructurePlacement::offsetZ),
            RegistryCodecs.homogeneousList(Registries.BIOME).fieldOf("preferred_biomes").forGetter(ModifiedConcentricRingsStructurePlacement::preferredBiomes)
    ).apply(instance, ModifiedConcentricRingsStructurePlacement::new));

    private final Optional<Integer> offsetX;
    private final Optional<Integer> offsetZ;
    protected ModifiedConcentricRingsStructurePlacement(int salt, int distance, int spread, int count, Optional<Integer> offsetX, Optional<Integer> offsetZ, HolderSet<Biome> preferredBiomes) {
        super(Vec3i.ZERO, FrequencyReductionMethod.DEFAULT, 1.0f, salt, Optional.empty(), distance, spread, count, preferredBiomes);
        this.offsetX = offsetX;
        this.offsetZ = offsetZ;
    }

    @Override
    protected boolean isPlacementChunk(ChunkGeneratorStructureState structureState, int x, int z) {
        List<ChunkPos> ringPositionsFor = structureState.getRingPositionsFor(this);
        if (ringPositionsFor == null) {     //If the structure has no ring positions, then return false to prevent the structure from generating.
            return false;
        }
        ChunkPos matchingChunkPos = null;   //Initialize a variable to store the matching chunk position.
        for (ChunkPos chunkPos : ringPositionsFor) {    //Iterates through each chunk position.
            if (x == chunkPos.x && z == chunkPos.z) {
                matchingChunkPos = chunkPos;
            }
        }
        return matchingChunkPos != null;
    }

    @Override
    public StructurePlacementType<?> type() {
        return AHStructurePlacementType.MODIFIED_CONCENTRIC_RINGS.get();
    }

    public Optional<Integer> offsetX() {
        return offsetX;
    }

    public Optional<Integer> offsetZ() {
        return offsetZ;
    }
}
