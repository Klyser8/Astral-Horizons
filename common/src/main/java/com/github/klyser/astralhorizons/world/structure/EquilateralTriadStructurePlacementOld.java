package com.github.klyser.astralhorizons.world.structure;

import com.github.klyser.astralhorizons.registry.AHStructurePlacementType;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Vec3i;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGeneratorStructureState;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;

import java.util.Optional;

/*public class EquilateralTriadStructurePlacement extends StructurePlacement {

    public static final int MAX_DISTANCE_BETWEEN_STRUCTURES = 50;
    public static final int MIN_DISTANCE_BETWEEN_STRUCTURES = 10;

    public static final Codec<EquilateralTriadStructurePlacement> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            Codec.intRange(0, Integer.MAX_VALUE).fieldOf("salt").forGetter(p -> p.salt),
            Codec.intRange(0, 4096).fieldOf("spacing").forGetter(p -> p.spacing),
            Codec.intRange(0, 4096).fieldOf("separation").forGetter(p -> p.separation),
            Codec.intRange(-128, 128).fieldOf("offset_x").forGetter(p -> p.offsetX),
            Codec.intRange(-128, 128).fieldOf("offset_z").forGetter(p -> p.offsetZ),
//            Codec.intRange(MIN_DISTANCE_BETWEEN_STRUCTURES, MAX_DISTANCE_BETWEEN_STRUCTURES - MIN_DISTANCE_BETWEEN_STRUCTURES).fieldOf("min_distance_between_structures").forGetter(p -> p.lowestDistanceBetweenStructures),
//            Codec.intRange(MIN_DISTANCE_BETWEEN_STRUCTURES * 2, MAX_DISTANCE_BETWEEN_STRUCTURES).fieldOf("max_distance_between_structures").forGetter(p -> p.highestDistanceBetweenStructures),
            TagKey.codec(Registries.BIOME).fieldOf("biome_tag").forGetter(p -> p.biomeTag)
    ).apply(inst, EquilateralTriadStructurePlacement::new));

    private final int salt;
    private final int spacing; //Average distance between neighboring generation attempts
    private final int separation; //Minimum distance between neighboring generation attempts
    private final int offsetX;
    private final int offsetZ;
//    private final int lowestDistanceBetweenStructures;
//    private final int highestDistanceBetweenStructures;
    private final TagKey<Biome> biomeTag;

    protected EquilateralTriadStructurePlacement(int salt,
                                                 int spacing,
                                                 int separation,
                                                 int offsetX,
                                                 int offsetZ,
                                                 *//*int lowestDistanceBetweenStructures,
                                                 int highestDistanceBetweenStructures,*//*
                                                 TagKey<Biome> biomeTag) {
        super(Vec3i.ZERO, FrequencyReductionMethod.DEFAULT, 1f, 0, Optional.empty());
        this.salt = salt;
        if (separation > spacing) {
            throw new IllegalArgumentException("""
                    Astral Horizons: minimum distance between structures (separation) must be lower than the average distance (spacing)!
                        Separation: %s.
                        Spacing: %s.
                    Please correct this.
                    """.formatted(separation, spacing));
        }
        this.spacing = spacing;
        this.separation = separation;
        this.offsetX = offsetX;
        this.offsetZ = offsetZ;
        *//*if (lowestDistanceBetweenStructures > highestDistanceBetweenStructures) {
            throw new IllegalArgumentException("""
                    Astral Horizons: minimum distance between structures must be lower than the maximum distance!
                        Minimum distance between structures: %s.
                        Maximum distance between structures: %s.
                    Please correct this.
                    """.formatted(lowestDistanceBetweenStructures, highestDistanceBetweenStructures));
        }
        this.lowestDistanceBetweenStructures = lowestDistanceBetweenStructures;
        this.highestDistanceBetweenStructures = highestDistanceBetweenStructures;*//*
        this.biomeTag = biomeTag;
    }

    @Override
    public StructurePlacementType<?> type() {
        return AHStructurePlacementType.EQUILATERAL_TRIAD.get();
    }

*//*    public ChunkPos getPotentialCenterStructureChunk(long seed, int regionX, int regionZ, WorldgenRandom worldgenRandom) {
        int chunkX = Math.floorDiv(regionX, this.spacing);
        int chunkZ = Math.floorDiv(regionZ, this.spacing);
        worldgenRandom.setLargeFeatureSeed(seed, chunkX, chunkZ);
        int bound = this.spacing - this.separation;
        int randomizedOffsetX = (worldgenRandom.nextInt(bound) + worldgenRandom.nextInt(bound)) / 2;
        int randomizedOffsetZ = (worldgenRandom.nextInt(bound) + worldgenRandom.nextInt(bound)) / 2;
        return new ChunkPos(chunkX * this.spacing + randomizedOffsetX, chunkZ * this.spacing + randomizedOffsetZ);
    }*//*

    public ChunkPos getPotentialStructureChunk(long seed, int regionX, int regionZ) {
        int i = Math.floorDiv(regionX, this.spacing);
        int j = Math.floorDiv(regionZ, this.spacing);
        WorldgenRandom worldgenRandom = new WorldgenRandom(new LegacyRandomSource(0L));
        worldgenRandom.setLargeFeatureWithSalt(seed, i, j, salt);
        int k = this.spacing - this.separation;
        int l = (worldgenRandom.nextInt(k) + worldgenRandom.nextInt(k)) / 2;
        int m = (worldgenRandom.nextInt(k) + worldgenRandom.nextInt(k)) / 2;
        return new ChunkPos(i * this.spacing + l, j * this.spacing + m);
    }

    @Override
    protected boolean isPlacementChunk(ChunkGeneratorStructureState structureState, int x, int z) {
        int offsetXPos = x + this.offsetX;
        int offsetZPos = z + this.offsetZ;
        ChunkPos chunkPos = getPotentialStructureChunk(structureState.getLevelSeed(), offsetXPos, offsetZPos);
         return offsetXPos == chunkPos.x && offsetZPos == chunkPos.z;
    }


    *//*public ChunkPos getPotentialCenterStructureChunk(long seed, int regionX, int regionZ, WorldgenRandom worldgenRandom) {
        int chunkX = Math.floorDiv(regionX, this.spacing);
        int chunkZ = Math.floorDiv(regionZ, this.spacing);
        worldgenRandom.setLargeFeatureSeed(seed, chunkX, chunkZ);
        int bound = this.spacing - this.separation;
        int offsetX = (worldgenRandom.nextInt(bound) + worldgenRandom.nextInt(bound)) / 2;
        int offsetZ = (worldgenRandom.nextInt(bound) + worldgenRandom.nextInt(bound)) / 2;
        return new ChunkPos(chunkX * this.spacing + offsetX, chunkZ * this.spacing + offsetZ);
    }

    private ChunkPos getPotentialTopVertexStructureChunk(long seed, int centerX, int centerZ, int triangleHeight,
                                                         ChunkPos centerChunkPos, WorldgenRandom worldgenRandom, double theta) {
        int chunkX = centerX + triangleHeight / 2;
        int chunkZ = centerZ;
        worldgenRandom.setLargeFeatureSeed(seed, chunkX, chunkZ);
        return rotateChunkPosAroundPivot(new ChunkPos(chunkX, chunkZ), centerChunkPos, theta);
    }

    @Override
    protected boolean isPlacementChunk(ChunkGeneratorStructureState structureState, int x, int z) {
        WorldgenRandom worldgenRandom = new WorldgenRandom(new LegacyRandomSource(0L));
        int triangleLength = Math.max(Math.abs(x), Math.abs(z));
        int triangleHeight = (int) Math.round((Math.sqrt(3) / 2) * triangleLength);
        double theta = worldgenRandom.nextDouble() * 2 * Math.PI;
        ChunkPos centerChunkPos = getPotentialCenterStructureChunk(structureState.getLevelSeed(), x, z, worldgenRandom);
        ChunkPos topVertexChunkPos = getPotentialTopVertexStructureChunk(structureState.getLevelSeed(), x, z, triangleHeight, centerChunkPos, worldgenRandom, theta);
        ChunkPos bottomRightVertexChunkPos = getPotentialBottomRightVertexStructureChunk(structureState.getLevelSeed(), x, z, triangleLength, triangleHeight, centerChunkPos, worldgenRandom, theta);
        ChunkPos bottomLeftVertexChunkPos = getPotentialBottomLeftVertexStructureChunk(structureState.getLevelSeed(), x, z, triangleLength, triangleHeight, centerChunkPos, worldgenRandom, theta);
        if (x == centerChunkPos.x && z == centerChunkPos.z) {
            return true;
        }
        return false;
    }

    private ChunkPos getPotentialBottomRightVertexStructureChunk(long seed, int centerX, int centerZ, int triangleLength, int triangleHeight,
                                                                ChunkPos centerChunkPos, WorldgenRandom worldgenRandom, double theta) {
        int chunkX = centerX + triangleHeight / 2;
        int chunkZ = centerZ + -triangleLength / 2;
        worldgenRandom.setLargeFeatureSeed(seed, chunkX, chunkZ);
        return rotateChunkPosAroundPivot(new ChunkPos(chunkX, chunkZ), centerChunkPos, theta);
    }

    private ChunkPos getPotentialBottomLeftVertexStructureChunk(long seed, int centerX, int centerZ, int triangleLength, int triangleHeight,
                                                                ChunkPos centerChunkPos, WorldgenRandom worldgenRandom, double theta) {
        int chunkX = centerX + -triangleHeight / 2;
        int chunkZ = centerZ + -triangleLength / 2;
        worldgenRandom.setLargeFeatureSeed(seed, chunkX, chunkZ);
        return rotateChunkPosAroundPivot(new ChunkPos(chunkX, chunkZ), centerChunkPos, theta);
    }

    private ChunkPos rotateChunkPosAroundPivot(ChunkPos pos, ChunkPos pivotPos, double theta) {
        int x = pos.x - pivotPos.x;
        int z = pos.z - pivotPos.z;

        double cosTheta = Math.cos(theta);
        double sinTheta = Math.sin(theta);

        int rotatedX = (int) Math.round(cosTheta * x - sinTheta * z);
        int rotatedZ = (int) Math.round(sinTheta * x + cosTheta * z);

        return new ChunkPos(pivotPos.x + rotatedX, pivotPos.z + rotatedZ);
    }*//*
}*/

public class EquilateralTriadStructurePlacementOld extends RandomSpreadStructurePlacement {
    public static final Codec<EquilateralTriadStructurePlacementOld> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            Vec3i.offsetCodec(16).optionalFieldOf("locate_offset", Vec3i.ZERO).forGetter(EquilateralTriadStructurePlacementOld::locateOffset),
            FrequencyReductionMethod.CODEC.optionalFieldOf("frequency_reduction_method", FrequencyReductionMethod.DEFAULT).forGetter(EquilateralTriadStructurePlacementOld::frequencyReductionMethod),
            Codec.floatRange(0.0F, 1.0F).optionalFieldOf("frequency", 1.0F).forGetter(EquilateralTriadStructurePlacementOld::frequency),
            ExtraCodecs.NON_NEGATIVE_INT.fieldOf("salt").forGetter(EquilateralTriadStructurePlacementOld::salt),
            ExclusionZone.CODEC.optionalFieldOf("exclusion_zone").forGetter(EquilateralTriadStructurePlacementOld::exclusionZone),
            Codec.intRange(0, Integer.MAX_VALUE).fieldOf("spacing").forGetter(EquilateralTriadStructurePlacementOld::spacing),
            Codec.intRange(0, Integer.MAX_VALUE).fieldOf("separation").forGetter(EquilateralTriadStructurePlacementOld::separation),
            RandomSpreadType.CODEC.optionalFieldOf("spread_type", RandomSpreadType.LINEAR).forGetter(EquilateralTriadStructurePlacementOld::spreadType),
            Codec.intRange(-128, 128).fieldOf("xOffset").forGetter(EquilateralTriadStructurePlacementOld::xOffset),
            Codec.intRange(-128, 128).fieldOf("zOffset").forGetter(EquilateralTriadStructurePlacementOld::zOffset)
    ).apply(instance, instance.stable(EquilateralTriadStructurePlacementOld::new)));

    private final int spacing;
    private final int separation;
    private final int salt;
    private final RandomSpreadType spreadType; //Just... Start over. This class kinda works.
    private final int xOffset;
    private final int zOffset;

    public EquilateralTriadStructurePlacementOld(Vec3i locationOffset,
                                                 FrequencyReductionMethod frequencyReductionMethod,
                                                 float frequency,
                                                 int salt,
                                                 Optional<ExclusionZone> exclusionZone,
                                                 int spacing,
                                                 int separation,
                                                 RandomSpreadType spreadType,
                                                 int xOffset,
                                                 int zOffset
    ) {
        super(locationOffset, frequencyReductionMethod, frequency, salt, exclusionZone, spacing, separation, spreadType);
        this.spacing = spacing;
        this.separation = separation;
        this.spreadType = spreadType;
        this.salt = salt;
        this.xOffset = xOffset;
        this.zOffset = zOffset;
    }

    @Override
    public int spacing() {
        return spacing;
    }

    @Override
    public int separation() {
        return separation;
    }

    public int xOffset() {
        return this.xOffset;
    }

    public int zOffset() {
        return this.zOffset;
    }

    @Override
    public ChunkPos getPotentialStructureChunk(long seed, int x, int z) {
        return new ChunkPos(x, z);
    }

    @Override
    protected boolean isPlacementChunk(ChunkGeneratorStructureState chunkGeneratorStructureState, int x, int z) {
        int newXPos = x + xOffset();
        int newZPos = z + zOffset();

        ChunkPos chunkpos = this.getOriginalPotentialStructureChunk(chunkGeneratorStructureState.getLevelSeed(), newXPos, newZPos);
        return chunkpos.x == newXPos && chunkpos.z == newZPos;
    }

    public ChunkPos getOriginalPotentialStructureChunk(long l, int i, int j) {
        int k = Math.floorDiv(i, this.spacing);
        int m = Math.floorDiv(j, this.spacing);
        WorldgenRandom worldgenRandom = new WorldgenRandom(new LegacyRandomSource(0L));
        worldgenRandom.setLargeFeatureWithSalt(l, k, m, this.salt());
        int n = this.spacing - this.separation;
        int o = this.spreadType.evaluate(worldgenRandom, n);
        int p = this.spreadType.evaluate(worldgenRandom, n);
        return new ChunkPos(k * this.spacing + o, m * this.spacing + p);
    }

    @Override
    public StructurePlacementType<?> type() {
        return AHStructurePlacementType.MODIFIED_CONCENTRIC_RINGS.get();
    }
}
