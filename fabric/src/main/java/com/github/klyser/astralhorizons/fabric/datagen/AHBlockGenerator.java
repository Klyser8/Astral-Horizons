package com.github.klyser.astralhorizons.fabric.datagen;

import com.github.klyser.astralhorizons.AstralHorizons;
import com.github.klyser.astralhorizons.fabric.datagen.builder.AHBlockFamilyBuilder;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.core.Direction;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;

public class AHBlockGenerator extends FabricModelProvider {

    public AHBlockGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerator) {
        createTrivialBlocks(blockModelGenerator);
        createBlockFamilies(blockModelGenerator);
        createWoods(blockModelGenerator);
        createHorizontallyRotatedTrivialBlock(blockModelGenerator, AHBlocks.ANOMALOUS_STONE_BRICKS.get(), TexturedModel.CUBE);
        createHorizontallyRotatedSlab(blockModelGenerator, AHBlocks.ANOMALOUS_STONE_BRICKS.get(), AHBlocks.ANOMALOUS_STONE_BRICK_SLAB.get());
        createTrivialStairs(blockModelGenerator, AHBlocks.ANOMALOUS_STONE_BRICKS.get(), AHBlocks.ANOMALOUS_STONE_BRICK_STAIRS.get());
        createTrivialWall(blockModelGenerator, AHBlocks.ANOMALOUS_STONE_BRICKS.get(), AHBlocks.ANOMALOUS_STONE_BRICK_WALL.get());
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {}

    private void createTrivialBlocks(BlockModelGenerators blockModelGenerator) {
        blockModelGenerator.createTrivialCube(AHBlocks.ANOMALOUS_DIRT.get());
        blockModelGenerator.createTrivialCube(AHBlocks.ANOMALOUS_SAND.get());
        blockModelGenerator.createTrivialCube(AHBlocks.CHISELED_ANOMALOUS_STONE_BRICKS.get());

        Block anomalousDirt = AHBlocks.ANOMALOUS_DIRT.get();
        Block anomalousGrassBlock = AHBlocks.ANOMALOUS_GRASS_BLOCK.get();
        ResourceLocation anomalousDirtBlockResourceLocation = TextureMapping.getBlockTexture(anomalousDirt);
        TextureMapping textureMapping = new TextureMapping()
                .put(TextureSlot.BOTTOM, anomalousDirtBlockResourceLocation).copyForced(TextureSlot.BOTTOM, TextureSlot.PARTICLE)
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(anomalousGrassBlock, "_top"))
                .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(anomalousGrassBlock, "_snow"));
        Variant variant = Variant.variant().with(VariantProperties.MODEL, ModelTemplates.CUBE_BOTTOM_TOP
                .createWithSuffix(anomalousGrassBlock, "_snow", textureMapping, blockModelGenerator.modelOutput));
        blockModelGenerator.createGrassLikeBlock(anomalousGrassBlock, new ResourceLocation(AstralHorizons.MOD_ID, "anomalous_grass_block"), variant);
    }

    private void createGrassBlock(BlockModelGenerators blockModelGenerator) {
        //TODO implement this
    }

    private void createTrivialStairs(BlockModelGenerators blockModelGenerator, Block fromBlock, Block stairsBlock) {
        TextureMapping textureMapping = TextureMapping.cube(fromBlock);
        ResourceLocation straightModelLocation = ModelTemplates.STAIRS_STRAIGHT.create(stairsBlock, textureMapping, blockModelGenerator.modelOutput);
        ResourceLocation innerModelLocation = ModelTemplates.STAIRS_INNER.create(stairsBlock, textureMapping, blockModelGenerator.modelOutput);
        ResourceLocation outerModelLocation = ModelTemplates.STAIRS_OUTER.create(stairsBlock, textureMapping, blockModelGenerator.modelOutput);
        blockModelGenerator.blockStateOutput.accept(BlockModelGenerators.createStairs(stairsBlock, innerModelLocation, straightModelLocation, outerModelLocation));
    }

    private void createTrivialWall(BlockModelGenerators blockModelGenerator, Block fromBlock, Block wallBlock) {
        TextureMapping textureMapping = TextureMapping.cube(fromBlock);
        ResourceLocation wallPostModelLocation = ModelTemplates.WALL_POST.create(wallBlock, textureMapping, blockModelGenerator.modelOutput);
        ResourceLocation wallLowSideModelLocation = ModelTemplates.WALL_LOW_SIDE.create(wallBlock, textureMapping, blockModelGenerator.modelOutput);
        ResourceLocation wallTallSideModelLocation = ModelTemplates.WALL_TALL_SIDE.create(wallBlock, textureMapping, blockModelGenerator.modelOutput);
        blockModelGenerator.blockStateOutput.accept(BlockModelGenerators.createWall(wallBlock, wallPostModelLocation, wallLowSideModelLocation, wallTallSideModelLocation));
        ResourceLocation wallInventoryModelLocation = ModelTemplates.WALL_INVENTORY.create(wallBlock, textureMapping, blockModelGenerator.modelOutput);
        blockModelGenerator.delegateItemModel(wallBlock, wallInventoryModelLocation);
    }

    private void createBlockFamilies(BlockModelGenerators blockModelGenerator) {
        new AHBlockFamilyBuilder(blockModelGenerator, AHBlocks.ANOMALOUS_COBBLESTONE.get())
                .withSlab(AHBlocks.ANOMALOUS_COBBLESTONE_SLAB.get())
                .withWall(AHBlocks.ANOMALOUS_COBBLESTONE_WALL.get())
                .withStairs(AHBlocks.ANOMALOUS_COBBLESTONE_STAIRS.get());
        new AHBlockFamilyBuilder(blockModelGenerator, AHBlocks.ANOMALOUS_STONE.get())
                .withSlab(AHBlocks.ANOMALOUS_STONE_SLAB.get())
                .withStairs(AHBlocks.ANOMALOUS_STONE_STAIRS.get())
                .withPressurePlate(AHBlocks.ANOMALOUS_STONE_PRESSURE_PLATE.get())
                .withButton(AHBlocks.ANOMALOUS_STONE_BUTTON.get());
    }

    private void createWoods(BlockModelGenerators blockModelGenerators) {
        createLog(blockModelGenerators, AHBlocks.ANOMALOUS_LOG.get(), AHBlocks.ANOMALOUS_WOOD.get());
    }

    private void createLog(BlockModelGenerators blockModelGenerators, Block logBlock, Block woodBlock) {
        BlockModelGenerators.WoodProvider woodProvider = blockModelGenerators.woodProvider(logBlock);
        woodProvider.logWithHorizontal(logBlock).wood(woodBlock);
    }

    private void createHorizontallyRotatedTrivialBlock(BlockModelGenerators blockModelGenerators, Block block, TexturedModel.Provider provider) {
        ResourceLocation resourceLocation = provider.create(block, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block, Variant.variant().with(VariantProperties.MODEL, resourceLocation)).with(
                PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.EAST, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.NORTH, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                        .select(Direction.SOUTH, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.WEST, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
        ));
    }

/*    private void createHorizontallyRotatedSlab(BlockModelGenerators blockModelGenerators, Block fromBlock, Block slabBlock) {
        TextureMapping textureMapping = TextureMapping.cube(fromBlock);
        ResourceLocation bottomHalfModelLocation = ModelTemplates.SLAB_BOTTOM.create(slabBlock, textureMapping, blockModelGenerators.modelOutput);
        ResourceLocation topHalfModelLocation = ModelTemplates.SLAB_TOP.create(slabBlock, textureMapping, blockModelGenerators.modelOutput);
        ResourceLocation doubleModelLocation = ModelLocationUtils.getModelLocation(fromBlock);

        MultiVariantGenerator multiVariantGenerator = MultiVariantGenerator.multiVariant(slabBlock);

        // Maps directions to their respective Y rotations.
        Map<Direction, VariantProperties.Rotation> directionRotationMap = new HashMap<>();
        directionRotationMap.put(Direction.EAST, VariantProperties.Rotation.R0);
        directionRotationMap.put(Direction.NORTH, VariantProperties.Rotation.R270);
        directionRotationMap.put(Direction.SOUTH, VariantProperties.Rotation.R90);
        directionRotationMap.put(Direction.WEST, VariantProperties.Rotation.R180);

        PropertyDispatch.C2<SlabType, Direction> properties = PropertyDispatch.properties(BlockStateProperties.SLAB_TYPE, BlockStateProperties.HORIZONTAL_FACING);

        // Loop through each SlabType and Direction combination
        for (SlabType slabType : SlabType.values()) {
            ResourceLocation modelLocation;
            if (slabType == SlabType.BOTTOM) {
                modelLocation = bottomHalfModelLocation;
            } else if (slabType == SlabType.TOP) {
                modelLocation = topHalfModelLocation;
            } else { // DOUBLE
                modelLocation = doubleModelLocation;
            }
            for (Map.Entry<Direction, VariantProperties.Rotation> entry : directionRotationMap.entrySet()) {
                System.out.println("Combination: " + slabType + ", " + entry.getKey() + ", " + entry.getValue());
                multiVariantGenerator.with(
                        properties.select(
                                slabType, entry.getKey(), Variant.merge(
                                        Variant.variant().with(VariantProperties.MODEL, modelLocation),
                                        Variant.variant().with(VariantProperties.Y_ROT, entry.getValue())
                                )
                        )
                );
            }
        }

        blockModelGenerators.blockStateOutput.accept(multiVariantGenerator);
    }*/


    private void createHorizontallyRotatedSlab(BlockModelGenerators blockModelGenerators, Block fromBlock, Block slabBlock) {
        TextureMapping textureMapping = TextureMapping.cube(fromBlock);
        ResourceLocation bottomHalfModelLocation = ModelTemplates.SLAB_BOTTOM.create(slabBlock, textureMapping, blockModelGenerators.modelOutput);
        ResourceLocation topHalfModelLocation = ModelTemplates.SLAB_TOP.create(slabBlock, textureMapping, blockModelGenerators.modelOutput);
        ResourceLocation doubleModelLocation = ModelLocationUtils.getModelLocation(fromBlock);
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.multiVariant(slabBlock).with(
                PropertyDispatch.properties(BlockStateProperties.SLAB_TYPE, BlockStateProperties.HORIZONTAL_FACING)
                    .select(
                            SlabType.BOTTOM, Direction.EAST, Variant.merge(
                                    Variant.variant().with(VariantProperties.MODEL, bottomHalfModelLocation),
                                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0)
                            )
                    )
                    .select(
                            SlabType.BOTTOM, Direction.NORTH, Variant.merge(
                                    Variant.variant().with(VariantProperties.MODEL, bottomHalfModelLocation),
                                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                            )
                    )
                    .select(
                            SlabType.BOTTOM, Direction.SOUTH, Variant.merge(
                                    Variant.variant().with(VariantProperties.MODEL, bottomHalfModelLocation),
                                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                            )
                    )
                    .select(
                            SlabType.BOTTOM, Direction.WEST, Variant.merge(
                                    Variant.variant().with(VariantProperties.MODEL, bottomHalfModelLocation),
                                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                            )
                    )
                    .select(
                            SlabType.TOP, Direction.EAST, Variant.merge(
                                    Variant.variant().with(VariantProperties.MODEL, topHalfModelLocation),
                                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0)
                            )
                    )
                    .select(
                            SlabType.TOP, Direction.NORTH, Variant.merge(
                                    Variant.variant().with(VariantProperties.MODEL, topHalfModelLocation),
                                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                            )
                    )
                    .select(
                            SlabType.TOP, Direction.SOUTH, Variant.merge(
                                    Variant.variant().with(VariantProperties.MODEL, topHalfModelLocation),
                                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                            )
                    )
                    .select(
                            SlabType.TOP, Direction.WEST, Variant.merge(
                                    Variant.variant().with(VariantProperties.MODEL, topHalfModelLocation),
                                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                            )
                    )
                    .select(
                            SlabType.DOUBLE, Direction.EAST, Variant.merge(
                                    Variant.variant().with(VariantProperties.MODEL, doubleModelLocation),
                                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0)
                            )
                    )
                    .select(
                            SlabType.DOUBLE, Direction.NORTH, Variant.merge(
                                    Variant.variant().with(VariantProperties.MODEL, doubleModelLocation),
                                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                            )
                    )
                    .select(
                            SlabType.DOUBLE, Direction.SOUTH, Variant.merge(
                                    Variant.variant().with(VariantProperties.MODEL, doubleModelLocation),
                                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                            )
                    )
                    .select(
                            SlabType.DOUBLE, Direction.WEST, Variant.merge(
                                    Variant.variant().with(VariantProperties.MODEL, doubleModelLocation),
                                    Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                            )
                    )
        ));
    }

    /*private void createHorizontallyRotatedStairs(BlockModelGenerators blockModelGenerators, Block fromBlock, Block stairsBlock) {
        TextureMapping textureMapping = TextureMapping.cube(fromBlock);
        ResourceLocation straightModelLocation = ModelTemplates.STAIRS_STRAIGHT.create(stairsBlock, textureMapping, blockModelGenerators.modelOutput);
        ResourceLocation innerModelLocation = ModelTemplates.STAIRS_INNER.create(stairsBlock, textureMapping, blockModelGenerators.modelOutput);
        ResourceLocation outerModelLocation = ModelTemplates.STAIRS_OUTER.create(stairsBlock, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.multiVariant(stairsBlock).with(
                PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.HALF, BlockStateProperties.STAIRS_SHAPE)
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.INNER_LEFT, Variant.variant()
                                .with(VariantProperties.MODEL, innerModelLocation)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.UV_LOCK, true))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.INNER_RIGHT, Variant.variant()
                                .with(VariantProperties.MODEL, innerModelLocation))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.OUTER_LEFT, Variant.variant()
                                .with(VariantProperties.MODEL, outerModelLocation)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.UV_LOCK, true))
                        .select(Direction.EAST, Half.BOTTOM, StairsShape.OUTER_RIGHT, Variant.variant()
                                .with(VariantProperties.MODEL, straightModelLocation))

                ));
    }*/
}
