package com.github.klyser.astralhorizons.world.feature.feature;

import com.github.klyser.astralhorizons.registry.AHBlocks;
import com.github.klyser.astralhorizons.world.feature.config.BoulderFeatureConfig;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoulderFeature extends Feature<BoulderFeatureConfig> {
    public BoulderFeature(Codec<BoulderFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<BoulderFeatureConfig> context) {
        RandomSource random = context.random();
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();

        BoulderFeatureConfig config = context.config();
        ResourceLocation boulder = config.boulderNbts().get(random.nextInt(config.boulderNbts().size()));
        WeightedStateProvider weightedStateProvider = config.saltAndPepperBlocks();
        Mirror mirror = config.randomMirror() ? Mirror.values()[random.nextInt(Mirror.values().length)] : Mirror.NONE;
        Rotation rotation = config.randomRotation() ? Rotation.values()[random.nextInt(Rotation.values().length)] : Rotation.NONE;

        StructureTemplateManager templateManager = level.getLevel().getServer().getStructureManager();
        StructureTemplate template = templateManager.getOrCreate(boulder);
        ChunkPos chunkPos = new ChunkPos(origin);

        BoundingBox boundingBox = new BoundingBox(
                chunkPos.getMinBlockX() - 16,
                level.getMinBuildHeight(),
                chunkPos.getMinBlockZ() - 16,
                chunkPos.getMaxBlockX() + 16,
                level.getMaxBuildHeight(),
                chunkPos.getMaxBlockZ() + 16
        );
        StructurePlaceSettings placeSettings = new StructurePlaceSettings().setBoundingBox(boundingBox).setRandom(random);
        Vec3i size = template.getSize();
        BlockPos centerPos = origin.offset(-size.getX() / 2, 0, -size.getZ() / 2);
        BlockPos offsetPos = template.getZeroPositionWithTransform(centerPos.atY(origin.getY()), mirror, rotation);

        template.placeInWorld(level, offsetPos, offsetPos, placeSettings, random, Block.UPDATE_ALL);
        replaceBlocks(random, offsetPos, template, placeSettings, weightedStateProvider).forEach((pos, state) -> {
            if (!state.is(AHBlocks.ANOMASTONE.get())) {
                level.setBlock(pos, state, Block.UPDATE_ALL);
            }
        });
        return true;
    }

    private Map<BlockPos, BlockState> replaceBlocks(RandomSource random, BlockPos origin, StructureTemplate template, StructurePlaceSettings placeSettings, WeightedStateProvider weightedStateProvider) {
        List<StructureTemplate.StructureBlockInfo> structureBlockInfos = template.filterBlocks(origin, placeSettings, AHBlocks.ANOMASTONE.get());
        Map<BlockPos, BlockState> states = new HashMap<>();
        for (StructureTemplate.StructureBlockInfo structureBlockInfo : structureBlockInfos) {
            states.put(structureBlockInfo.pos(), weightedStateProvider.getState(random, structureBlockInfo.pos()));
        }
        return states;
    }

}
