package com.github.klyser.astralhorizons.world.feature.feature;

import com.github.klyser.astralhorizons.registry.AHBlocks;
import com.github.klyser.astralhorizons.world.feature.config.SimpleTreeFeatureConfig;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

import java.util.List;

public class SimpleTreeFeature extends Feature<SimpleTreeFeatureConfig> {
    public SimpleTreeFeature(Codec<SimpleTreeFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<SimpleTreeFeatureConfig> context) {
        RandomSource random = context.random();
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();

        SimpleTreeFeatureConfig config = context.config();
        ResourceLocation crown = config.crownStructureList().get(random.nextInt(config.crownStructureList().size()));
        Mirror mirror = config.randomMirror() ? Mirror.values()[random.nextInt(Mirror.values().length)] : Mirror.NONE;
        Rotation rotation = config.randomRotation() ? Rotation.values()[random.nextInt(Rotation.values().length)] : Rotation.NONE;
        int trunkLength = config.trunkLength().sample(random);

        // Origin = where the game picked to generate the tree.
        origin = origin.offset(0, trunkLength, 0); //
        StructureTemplateManager templateManager = level.getLevel().getServer().getStructureManager();
        StructureTemplate template = templateManager.getOrCreate(crown);
        ChunkPos chunkPos = new ChunkPos(origin);

        BoundingBox boundingBox = new BoundingBox(
                chunkPos.getMinBlockX() - 16,
                level.getMinBuildHeight(),
                chunkPos.getMinBlockZ() - 16,
                chunkPos.getMaxBlockX() + 16,
                level.getMaxBuildHeight(),
                chunkPos.getMaxBlockZ() + 16
        );

        StructurePlaceSettings placeSettings = new StructurePlaceSettings()
                .setBoundingBox(boundingBox)
                .setRandom(random);

        BlockPos.MutableBlockPos trunkPos = findCrownConnector(origin, template, placeSettings).mutable(); //Offset the origin by the trunkpos?
        int xOffset = origin.getX() - trunkPos.getX();
        int zOffset = origin.getZ() - trunkPos.getZ();

        BlockPos centerPos = origin.offset(xOffset, 0, zOffset);
        placeSettings.setRotationPivot(new BlockPos(-xOffset, 0, -zOffset)).setRotation(rotation);
        template.placeInWorld(level, centerPos, centerPos, placeSettings, random, Block.UPDATE_ALL);
        do {
            level.setBlock(origin, config.trunkProvider().getState(random, origin), Block.UPDATE_ALL);
            origin = origin.below();
        } while (!level.getBlockState(origin).canOcclude() && origin.getY() > -63);
        return true;
    }

    private BlockPos findCrownConnector(BlockPos origin, StructureTemplate template, StructurePlaceSettings settings) {
        List<StructureTemplate.StructureBlockInfo> structureBlockInfos = template.filterBlocks(origin, settings, AHBlocks.STRIPPED_SCURANE_LOG.get());
        return structureBlockInfos.get(0).pos(); //The trees should have only one "connector" block.
    }

}
