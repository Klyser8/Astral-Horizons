package com.github.klyser.astralhorizons.world.feature.feature;

import com.github.klyser.astralhorizons.block.vegetation.TwistedTendrilHeadBlock;
import com.github.klyser.astralhorizons.block.vegetation.TwistedTendrilStemBlock;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class TwistedTendrilFeature extends Feature<NoneFeatureConfiguration> {

    public static final int MAX_OVERALL_HEIGHT = 25;
    public TwistedTendrilFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        return placeTwistedTendril(context);
    }

    public boolean placeTwistedTendril(FeaturePlaceContext<NoneFeatureConfiguration> context) {
//        System.out.println("\n----------------------------");
//        System.out.println("TwistedTendrilFeature.placeTwistedTendril");
        int amountPlaced = 0;
        WorldGenLevel worldGenLevel = context.level();
        BlockPos origin = context.origin();
        RandomSource randomSource = context.random();
        int yHeight = worldGenLevel.getHeight(Heightmap.Types.OCEAN_FLOOR, origin.getX(), origin.getZ());
        BlockPos currentPos = new BlockPos(origin.getX(), yHeight, origin.getZ());
        if (worldGenLevel.getBlockState(currentPos).is(Blocks.WATER)) {
//            System.out.println("Current position is water");
            BlockState headState = AHBlocks.TWISTED_TENDRIL_HEAD.get().defaultBlockState();
            BlockState stemState = AHBlocks.TWISTED_TENDRIL_STEM.get().defaultBlockState();
            int maxOutOfWaterHeight = 3 + randomSource.nextInt(4);
            int currentYOutOfWater = 0;
            int headAge = randomSource.nextFloat() > 0.2 ? TwistedTendrilHeadBlock.MAX_AGE : 24;
            while (amountPlaced <= MAX_OVERALL_HEIGHT) {
                boolean isTargetPosInWater = worldGenLevel.getBlockState(currentPos).is(Blocks.WATER);
                boolean canStemSurvive = stemState.canSurvive(worldGenLevel, currentPos);
                if (canStemSurvive) {
//                    System.out.println("Stem can survive at y: " + amountPlaced);
                    if (currentYOutOfWater == maxOutOfWaterHeight) {
//                        System.out.println("Current Y out of water is max");
                        worldGenLevel.setBlock(currentPos, headState
                                .setValue(TwistedTendrilHeadBlock.AGE, headAge)
                                .setValue(TwistedTendrilHeadBlock.WATERLOGGED, false)
                                .setValue(TwistedTendrilHeadBlock.SPROUTED, headAge == TwistedTendrilHeadBlock.MAX_AGE),
                                Block.UPDATE_ALL);
                        break;
                    } else {
//                        System.out.println("Placing stem at current pos");
                        worldGenLevel.setBlock(currentPos, stemState.setValue(TwistedTendrilStemBlock.WATERLOGGED, isTargetPosInWater), 2);
                    }
                    if (!isTargetPosInWater) {
                        currentYOutOfWater++;
                    }
                    amountPlaced++;
                } else {
//                    System.out.println("Stem can't survive at current pos");
                    break;
                }
                currentPos = currentPos.above();
            }
            if (amountPlaced > 0) { //Converts last placed block into head
//                System.out.println("Converting last placed block into head");
                boolean isCurrentPosInWater = worldGenLevel.getBlockState(currentPos).is(Blocks.WATER);
                boolean blockIsntHead = !worldGenLevel.getBlockState(currentPos).is(AHBlocks.TWISTED_TENDRIL_HEAD.get());
                if (blockIsntHead) {
//                    System.out.println("Placing head at below pos");
                    worldGenLevel.setBlock(currentPos, headState
                            .setValue(TwistedTendrilHeadBlock.AGE, headAge)
                            .setValue(TwistedTendrilHeadBlock.WATERLOGGED, isCurrentPosInWater)
                            .setValue(TwistedTendrilHeadBlock.SPROUTED, headAge == TwistedTendrilHeadBlock.MAX_AGE),
                            Block.UPDATE_ALL);
                    amountPlaced++;
                }
            }
        }
        return amountPlaced > 0;
    }
}
