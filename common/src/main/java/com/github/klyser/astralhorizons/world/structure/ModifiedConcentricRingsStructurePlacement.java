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
import java.util.Random;

public class ModifiedConcentricRingsStructurePlacement extends ConcentricRingsStructurePlacement {

    public static final Codec<ModifiedConcentricRingsStructurePlacement> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            Codec.INT.fieldOf("salt").forGetter(ModifiedConcentricRingsStructurePlacement::salt),
            Codec.INT.fieldOf("distance").forGetter(ModifiedConcentricRingsStructurePlacement::distance),
            Codec.INT.fieldOf("spread").forGetter(ModifiedConcentricRingsStructurePlacement::spread),
            Codec.intRange(1, 512).fieldOf("count").forGetter(ModifiedConcentricRingsStructurePlacement::count),
            Codec.INT.optionalFieldOf("min_distance_from_origin", 0).forGetter(ModifiedConcentricRingsStructurePlacement::minDistanceFromOrigin),
            Codec.INT.optionalFieldOf("max_distance_from_origin", 0).forGetter(ModifiedConcentricRingsStructurePlacement::maxDistanceFromOrigin),
            Codec.intRange(0, 359).optionalFieldOf("rotation_offset", 0).forGetter(ModifiedConcentricRingsStructurePlacement::rotationOffset),
            RegistryCodecs.homogeneousList(Registries.BIOME).fieldOf("preferred_biomes").forGetter(ModifiedConcentricRingsStructurePlacement::preferredBiomes)
    ).apply(instance, ModifiedConcentricRingsStructurePlacement::new));

    private final int minDistanceFromOrigin;
    private final int maxDistanceFromOrigin;
    private final int rotationOffset;

    protected ModifiedConcentricRingsStructurePlacement(int salt, int distance, int spread, int count,
                                                        int minDistanceFromOrigin, int maxDistanceFromOrigin, int rotationOffset,
                                                        HolderSet<Biome> preferredBiomes) {
        super(Vec3i.ZERO, FrequencyReductionMethod.DEFAULT, 1.0f, salt, Optional.empty(), distance, spread, count, preferredBiomes);
        if (minDistanceFromOrigin > maxDistanceFromOrigin) {
            throw new IllegalArgumentException("""
                        Astral Horizons: minimum distance from the origin cannot be greater than the maximum distance from the origin.
                            Minimum distance from origin: %s.
                            Maximum distance from origin: %s.
                        Please correct this.
                        """.formatted(minDistanceFromOrigin, maxDistanceFromOrigin));
        }
        this.minDistanceFromOrigin = minDistanceFromOrigin;
        this.maxDistanceFromOrigin = maxDistanceFromOrigin;
        this.rotationOffset = rotationOffset;
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

    public int minDistanceFromOrigin() {
        return minDistanceFromOrigin;
    }

    public int maxDistanceFromOrigin() {
        return maxDistanceFromOrigin;
    }

    public int rotationOffset() {
        return rotationOffset;
    }

    public ChunkPos rotateChunkPosAroundCenterChunk(ChunkPos chunkPos) {
        return rotateChunkPosAroundCenterChunk(chunkPos.x, chunkPos.z);
    }

    public ChunkPos rotateChunkPosAroundCenterChunk(int x, int z) { // Rotation may not be working as expected. Meh, whatever.
        long seed = combineToSeed(x, z);
        Random seededRandom = new Random(seed);

        int distance = generatePredictableRandomDistance(seededRandom);
        double angleRadians = Math.toRadians(generatePredictableRandomRotation(seededRandom) + rotationOffset());

        int rotatedX = (int) (Math.cos(angleRadians) * distance);
        int rotatedZ = (int) (Math.sin(angleRadians) * distance);
        return new ChunkPos(rotatedX + x, rotatedZ + z);
    }

    private int generatePredictableRandomDistance(Random seededRandom) {
        return seededRandom.nextInt(maxDistanceFromOrigin - minDistanceFromOrigin + 1) + minDistanceFromOrigin;
    }

    private int generatePredictableRandomRotation(Random seededRandom) {
        return seededRandom.nextInt(360);
    }

    private long combineToSeed(int x, int z) {
        long seed = 31L * (31L * (long) salt() + x) + z;
        return seed;
    }
}
