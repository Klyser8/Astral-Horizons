package com.github.klyser.astralhorizons.fabric.datagen;

import com.github.klyser.astralhorizons.AstralHorizons;
import com.github.klyser.astralhorizons.fabric.datagen.builder.AHBlockFamilyBuilder;
import com.github.klyser.astralhorizons.fabric.datagen.builder.AHWoodBuilder;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import com.github.klyser.astralhorizons.registry.AHItems;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;

import static net.minecraft.data.models.model.TextureMapping.getBlockTexture;

public class AHModelProvider extends FabricModelProvider {

    public AHModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerator) {
        createTrivialBlocks(blockModelGenerator);
        createCrossBlocks(blockModelGenerator);
        createBlockFamilies(blockModelGenerator);
        createWoods(blockModelGenerator);
        createHorizontallyRotatedTrivialBlock(blockModelGenerator, AHBlocks.ANOMASTONE_BRICKS.get(), TexturedModel.CUBE);
        createHorizontallyRotatedSlab(blockModelGenerator, AHBlocks.ANOMASTONE_BRICKS.get(), AHBlocks.ANOMASTONE_BRICK_SLAB.get());
        createTrivialStairs(blockModelGenerator, AHBlocks.ANOMASTONE_BRICKS.get(), AHBlocks.ANOMASTONE_BRICK_STAIRS.get());
        createTrivialWall(blockModelGenerator, AHBlocks.ANOMASTONE_BRICKS.get(), AHBlocks.ANOMASTONE_BRICK_WALL.get());

        createSandstone(blockModelGenerator);
        createRandomlyRotatedBlock(blockModelGenerator, AHBlocks.LUTIEL.get());
        createDoubleBlock(blockModelGenerator);
        createLeavesBlock(blockModelGenerator);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        generateFlatItemFromCrossBlock(itemModelGenerator, AHItems.SICKENED_SHRUB.get(), AHBlocks.SICKENED_SHRUB.get());
        generateFlatItemFromCrossBlock(itemModelGenerator, AHItems.ANOMALOUS_SHORT_GRASS.get(), AHBlocks.ANOMALOUS_SHORT_GRASS.get()); //FIXME why won't this generate?
        generateFlatItemFromCrossBlock(itemModelGenerator, AHItems.SCURANE_SAPLING.get(), AHBlocks.SCURANE_SAPLING.get());
        itemModelGenerator.generateFlatItem(AHItems.STARFLARE_BLOSSOM.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(AHItems.ANOMALOUS_SEAGRASS.get(), ModelTemplates.FLAT_ITEM);
//        itemModelGenerator.(AHItems.ANOMAGRASS_BLOCK.get(), ModelTemplates.FLAT_ITEM); //TODO figure out how to create blockitem item models.
    }

    private void generateFlatItemFromCrossBlock(ItemModelGenerators itemModelGenerator, Item item, Block block) {
        ResourceLocation blockTexture = TextureMapping.getBlockTexture(block);
        ModelTemplates.FLAT_ITEM.create(ModelLocationUtils.getModelLocation(item), TextureMapping.layer0(blockTexture), itemModelGenerator.output);
    }

    private void createTrivialBlocks(BlockModelGenerators blockModelGenerator) {
        blockModelGenerator.createTrivialCube(AHBlocks.ANOMADIRT.get());
        blockModelGenerator.createTrivialCube(AHBlocks.ANOMASAND.get());
        blockModelGenerator.createTrivialCube(AHBlocks.CHISELED_ANOMASTONE_BRICKS.get());
        blockModelGenerator.createTrivialCube(AHBlocks.ANOMALICE.get());
        TextureMapping snowBlockMapping = TextureMapping.cube(AstralHorizons.id("block/anomasnow"));
        blockModelGenerator.createTrivialBlock(AHBlocks.ANOMASNOW_BLOCK.get(), snowBlockMapping, ModelTemplates.CUBE_ALL);
        blockModelGenerator.createTrivialBlock(AHBlocks.ANOMALOUS_SEAGRASS.get(), TexturedModel.SEAGRASS);
    }

    public void createLeavesBlock(BlockModelGenerators blockModelGenerators) {
        ResourceLocation leafModelLocation = ModelTemplates.LEAVES.create(
                AHBlocks.SCURANE_LEAVES.get(),
                TextureMapping.cube(AstralHorizons.id("block/scurane_leaves")),
                blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(AHBlocks.SCURANE_LEAVES.get(), leafModelLocation));
    }

    private void createCrossBlocks(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createCrossBlock(AHBlocks.SICKENED_SHRUB.get(), BlockModelGenerators.TintState.TINTED);
        blockModelGenerators.createCrossBlock(AHBlocks.ANOMALOUS_SHORT_GRASS.get(), BlockModelGenerators.TintState.TINTED);
        blockModelGenerators.createCrossBlock(AHBlocks.SCURANE_SAPLING.get(), BlockModelGenerators.TintState.NOT_TINTED);
    }

    private void createSandstone(BlockModelGenerators blockModelGenerators) {
        createTopBottomWithWallBlock(blockModelGenerators, AHBlocks.ANOMASANDSTONE.get());
        createTrivialWall(blockModelGenerators, AHBlocks.ANOMASANDSTONE.get(), AHBlocks.ANOMASANDSTONE_WALL.get());
        createTopBottomWithWallSlab(blockModelGenerators, AHBlocks.ANOMASANDSTONE.get(), AHBlocks.ANOMASANDSTONE_SLAB.get());
        createTopBottomWithWallStairs(blockModelGenerators, AHBlocks.ANOMASANDSTONE.get(), AHBlocks.ANOMASANDSTONE_STAIRS.get());

        blockModelGenerators.createTrivialBlock(AHBlocks.SMOOTH_ANOMASANDSTONE.get(), TextureMapping.cube(AstralHorizons.id("block/anomasandstone_top")), ModelTemplates.CUBE_ALL);
        //TODO: Make slab and stairs for smooth sandstone. Look into texture mapping, and look at the line above for reference.
        createTrivialStairs(blockModelGenerators, TextureMapping.cube(AstralHorizons.id("block/anomasandstone_top")), AHBlocks.SMOOTH_ANOMASANDSTONE_STAIRS.get());
        createTrivialSlab(blockModelGenerators, AHBlocks.SMOOTH_ANOMASANDSTONE.get(), TextureMapping.cube(AstralHorizons.id("block/anomasandstone_top")), AHBlocks.SMOOTH_ANOMASANDSTONE_SLAB.get());

        createBlockWithDistinctTop(blockModelGenerators, AHBlocks.CUT_ANOMASANDSTONE.get(),
                AstralHorizons.id("block/cut_anomasandstone"),
                getBlockTexture(AHBlocks.ANOMASANDSTONE.get(), "_top"));
        createSlabWithDistinctTop(blockModelGenerators, AHBlocks.CUT_ANOMASANDSTONE.get(), AHBlocks.CUT_ANOMASANDSTONE_SLAB.get(),
                AstralHorizons.id("block/cut_anomasandstone"),
                getBlockTexture(AHBlocks.ANOMASANDSTONE.get(), "_top"));
    }

    private void createTopBottomWithWallBlock(BlockModelGenerators blockModelGenerators, Block block) {
        // Sandstone like block with top and bottom textures and a wall texture.
        ResourceLocation resourceLocation = TexturedModel.TOP_BOTTOM_WITH_WALL.create(block, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, resourceLocation));
    }

    private void createDoubleBlock(BlockModelGenerators blockModelGenerators) {
        ResourceLocation resourceLocation = blockModelGenerators.createSuffixedVariant(AHBlocks.ANOMALOUS_TALL_SEAGRASS.get(), "_top", ModelTemplates.SEAGRASS, TextureMapping::defaultTexture);
        ResourceLocation resourceLocation2 = blockModelGenerators.createSuffixedVariant(AHBlocks.ANOMALOUS_TALL_SEAGRASS.get(), "_bottom", ModelTemplates.SEAGRASS, TextureMapping::defaultTexture);
        blockModelGenerators.createDoubleBlock(AHBlocks.ANOMALOUS_TALL_SEAGRASS.get(), resourceLocation, resourceLocation2);
    }

    private void createTopBottomWithWallSlab(BlockModelGenerators blockModelGenerators, Block fromBlock, Block slabBlock) {
        ResourceLocation fromBlockResourceLocation = ModelLocationUtils.getModelLocation(fromBlock);
        TextureMapping slabMapping = new TextureMapping()
                .put(TextureSlot.WALL, fromBlockResourceLocation)
                .put(TextureSlot.SIDE, fromBlockResourceLocation)
                .put(TextureSlot.TOP, getBlockTexture(fromBlock, "_top"))
                .put(TextureSlot.BOTTOM, getBlockTexture(fromBlock, "_bottom"));

        ResourceLocation bottomHalfModelLocation = ModelTemplates.SLAB_BOTTOM.create(slabBlock, slabMapping, blockModelGenerators.modelOutput);
        ResourceLocation topHalfModelLocation = ModelTemplates.SLAB_TOP.create(slabBlock, slabMapping, blockModelGenerators.modelOutput);
        ResourceLocation doubleModelLocation = ModelLocationUtils.getModelLocation(fromBlock);

        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSlab(slabBlock, bottomHalfModelLocation, topHalfModelLocation, doubleModelLocation));
    }

    private void createBlockWithDistinctTop(BlockModelGenerators blockModelGenerators, Block block, ResourceLocation textureLocation, ResourceLocation topTextureLocation) {
        TextureMapping textureMapping = new TextureMapping()
                .put(TextureSlot.SIDE, textureLocation)
                .put(TextureSlot.END, topTextureLocation);

        ResourceLocation blockModelLocation = ModelTemplates.CUBE_COLUMN.create(block, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, blockModelLocation));
    }

    private void createSlabWithDistinctTop(BlockModelGenerators blockModelGenerators, Block fromBlock, Block slabBlock, ResourceLocation textureLocation, ResourceLocation topTextureLocation) {
        TextureMapping textureMapping = new TextureMapping()
                .put(TextureSlot.BOTTOM, topTextureLocation)
                .put(TextureSlot.SIDE, textureLocation)
                .put(TextureSlot.TOP, topTextureLocation);

        ResourceLocation bottomHalfModelLocation = ModelTemplates.SLAB_BOTTOM.create(slabBlock, textureMapping, blockModelGenerators.modelOutput);
        ResourceLocation topHalfModelLocation = ModelTemplates.SLAB_TOP.create(slabBlock, textureMapping, blockModelGenerators.modelOutput);
        ResourceLocation doubleModelLocation = ModelLocationUtils.getModelLocation(fromBlock);

        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSlab(slabBlock, bottomHalfModelLocation, topHalfModelLocation, doubleModelLocation));
    }

    private void createTopBottomWithWallStairs(BlockModelGenerators blockModelGenerators, Block fromBlock, Block stairsBlock) {
        ResourceLocation fromBlockResourceLocation = ModelLocationUtils.getModelLocation(fromBlock);
        TextureMapping stairsMapping = new TextureMapping()
                .put(TextureSlot.WALL, fromBlockResourceLocation)
                .put(TextureSlot.SIDE, fromBlockResourceLocation)
                .put(TextureSlot.TOP, getBlockTexture(fromBlock, "_top"))
                .put(TextureSlot.BOTTOM, getBlockTexture(fromBlock, "_bottom"));

        @SuppressWarnings("DuplicatedCode")
        ResourceLocation straightModelLocation = ModelTemplates.STAIRS_STRAIGHT.create(stairsBlock, stairsMapping, blockModelGenerators.modelOutput);
        ResourceLocation innerModelLocation = ModelTemplates.STAIRS_INNER.create(stairsBlock, stairsMapping, blockModelGenerators.modelOutput);
        ResourceLocation outerModelLocation = ModelTemplates.STAIRS_OUTER.create(stairsBlock, stairsMapping, blockModelGenerators.modelOutput);

        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createStairs(stairsBlock, innerModelLocation, straightModelLocation, outerModelLocation));
    }

    private void createRandomlyRotatedBlock(BlockModelGenerators blockModelGenerators, Block block) {
        ResourceLocation resourceLocation = TexturedModel.CUBE.create(block, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block,
                Variant.variant().with(VariantProperties.MODEL, resourceLocation),
                Variant.variant().with(VariantProperties.MODEL, resourceLocation)
                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90),
                Variant.variant().with(VariantProperties.MODEL, resourceLocation)
                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180),
                Variant.variant().with(VariantProperties.MODEL, resourceLocation)
                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270),
                Variant.variant().with(VariantProperties.MODEL, resourceLocation)
                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90),
                Variant.variant().with(VariantProperties.MODEL, resourceLocation)
                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90),
                Variant.variant().with(VariantProperties.MODEL, resourceLocation)
                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180),
                Variant.variant().with(VariantProperties.MODEL, resourceLocation)
                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270),
                Variant.variant().with(VariantProperties.MODEL, resourceLocation)
                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180),
                Variant.variant().with(VariantProperties.MODEL, resourceLocation)
                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90),
                Variant.variant().with(VariantProperties.MODEL, resourceLocation)
                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180),
                Variant.variant().with(VariantProperties.MODEL, resourceLocation)
                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270),
                Variant.variant().with(VariantProperties.MODEL, resourceLocation)
                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270),
                Variant.variant().with(VariantProperties.MODEL, resourceLocation)
                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90),
                Variant.variant().with(VariantProperties.MODEL, resourceLocation)
                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180),
                Variant.variant().with(VariantProperties.MODEL, resourceLocation)
                        .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
                        .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)));

    }

    private void createTrivialStairs(BlockModelGenerators blockModelGenerator, Block fromBlock, Block stairsBlock) {
        TextureMapping textureMapping = TextureMapping.cube(fromBlock);
        ResourceLocation straightModelLocation = ModelTemplates.STAIRS_STRAIGHT.create(stairsBlock, textureMapping, blockModelGenerator.modelOutput);
        ResourceLocation innerModelLocation = ModelTemplates.STAIRS_INNER.create(stairsBlock, textureMapping, blockModelGenerator.modelOutput);
        ResourceLocation outerModelLocation = ModelTemplates.STAIRS_OUTER.create(stairsBlock, textureMapping, blockModelGenerator.modelOutput);
        blockModelGenerator.blockStateOutput.accept(BlockModelGenerators.createStairs(stairsBlock, innerModelLocation, straightModelLocation, outerModelLocation));
    }

    private void createTrivialStairs(BlockModelGenerators blockModelGenerator, TextureMapping textureMapping, Block stairsBlock) {
        ResourceLocation straightModelLocation = ModelTemplates.STAIRS_STRAIGHT.create(stairsBlock, textureMapping, blockModelGenerator.modelOutput);
        ResourceLocation innerModelLocation = ModelTemplates.STAIRS_INNER.create(stairsBlock, textureMapping, blockModelGenerator.modelOutput);
        ResourceLocation outerModelLocation = ModelTemplates.STAIRS_OUTER.create(stairsBlock, textureMapping, blockModelGenerator.modelOutput);
        blockModelGenerator.blockStateOutput.accept(BlockModelGenerators.createStairs(stairsBlock, innerModelLocation, straightModelLocation, outerModelLocation));
    }

    private void createTrivialSlab(BlockModelGenerators blockModelGenerator, Block fromBlock, Block slabBlock) {
        TextureMapping textureMapping = TextureMapping.cube(fromBlock);
        ResourceLocation bottomHalfModelLocation = ModelTemplates.SLAB_BOTTOM.create(slabBlock, textureMapping, blockModelGenerator.modelOutput);
        ResourceLocation topHalfModelLocation = ModelTemplates.SLAB_TOP.create(slabBlock, textureMapping, blockModelGenerator.modelOutput);
        ResourceLocation doubleModelLocation = ModelLocationUtils.getModelLocation(fromBlock);
        blockModelGenerator.blockStateOutput.accept(BlockModelGenerators.createSlab(slabBlock, bottomHalfModelLocation, topHalfModelLocation, doubleModelLocation));
    }

    private void createTrivialSlab(BlockModelGenerators blockModelGenerator, Block fromBlock, TextureMapping textureMapping, Block slabBlock) {
        ResourceLocation bottomHalfModelLocation = ModelTemplates.SLAB_BOTTOM.create(slabBlock, textureMapping, blockModelGenerator.modelOutput);
        ResourceLocation topHalfModelLocation = ModelTemplates.SLAB_TOP.create(slabBlock, textureMapping, blockModelGenerator.modelOutput);
        ResourceLocation doubleModelLocation = ModelLocationUtils.getModelLocation(fromBlock);
        blockModelGenerator.blockStateOutput.accept(BlockModelGenerators.createSlab(slabBlock, bottomHalfModelLocation, topHalfModelLocation, doubleModelLocation));
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
        new AHBlockFamilyBuilder(blockModelGenerator, AHBlocks.COBBLED_ANOMASTONE.get())
                .withSlab(AHBlocks.COBBLED_ANOMASTONE_SLAB.get())
                .withWall(AHBlocks.COBBLED_ANOMASTONE_WALL.get())
                .withStairs(AHBlocks.COBBLED_ANOMASTONE_STAIRS.get());
        new AHBlockFamilyBuilder(blockModelGenerator, AHBlocks.ANOMASTONE.get())
                .withSlab(AHBlocks.ANOMASTONE_SLAB.get())
                .withStairs(AHBlocks.ANOMASTONE_STAIRS.get())
                .withPressurePlate(AHBlocks.ANOMASTONE_PRESSURE_PLATE.get())
                .withButton(AHBlocks.ANOMASTONE_BUTTON.get());
        new AHBlockFamilyBuilder(blockModelGenerator, AHBlocks.CHLORITE.get())
                .withSlab(AHBlocks.CHLORITE_SLAB.get())
                .withStairs(AHBlocks.CHLORITE_STAIRS.get())
                .withWall(AHBlocks.CHLORITE_WALL.get());
        new AHBlockFamilyBuilder(blockModelGenerator, AHBlocks.CHLORITE_BRICKS.get())
                .withSlab(AHBlocks.CHLORITE_BRICK_SLAB.get())
                .withStairs(AHBlocks.CHLORITE_BRICK_STAIRS.get())
                .withWall(AHBlocks.CHLORITE_BRICK_WALL.get());
        new AHBlockFamilyBuilder(blockModelGenerator, AHBlocks.SIDEROCK.get())
                .withSlab(AHBlocks.SIDEROCK_SLAB.get())
                .withStairs(AHBlocks.SIDEROCK_STAIRS.get())
                .withWall(AHBlocks.SIDEROCK_WALL.get());
        new AHBlockFamilyBuilder(blockModelGenerator, AHBlocks.SIDEROCK_BRICKS.get())
                .withSlab(AHBlocks.SIDEROCK_BRICK_SLAB.get())
                .withStairs(AHBlocks.SIDEROCK_BRICK_STAIRS.get())
                .withWall(AHBlocks.SIDEROCK_BRICK_WALL.get());
        new AHBlockFamilyBuilder(blockModelGenerator, AHBlocks.AURANITE.get())
                .withSlab(AHBlocks.AURANITE_SLAB.get())
                .withStairs(AHBlocks.AURANITE_STAIRS.get())
                .withWall(AHBlocks.AURANITE_WALL.get());
        new AHBlockFamilyBuilder(blockModelGenerator, AHBlocks.AURANITE_BRICKS.get())
                .withSlab(AHBlocks.AURANITE_BRICK_SLAB.get())
                .withStairs(AHBlocks.AURANITE_BRICK_STAIRS.get())
                .withWall(AHBlocks.AURANITE_BRICK_WALL.get());
    }

    private void createWoods(BlockModelGenerators blockModelGenerators) {
        new AHWoodBuilder(blockModelGenerators, AHBlocks.SCURANE_LOG.get(), AHBlocks.SCURANE_WOOD.get(),
                AHBlocks.STRIPPED_SCURANE_LOG.get(), AHBlocks.STRIPPED_SCURANE_WOOD.get(),
                AHBlocks.SCURANE_PLANKS.get())
                .withDoor(AHBlocks.SCURANE_DOOR.get())
                .withTrapdoor(AHBlocks.SCURANE_TRAPDOOR.get())
//                .withSign(AHBlocks.SCURANE_SIGN.get())
                .withFenceGate(AHBlocks.SCURANE_FENCE_GATE.get())
//                .withHangingSign(AHBlocks.SCURANE_PLANKS.get(), AHBlocks.SCURANE_HANGING_SIGN.get(), AHBlocks.SCURANE_WALL_HANGING_SIGN.get())
                .withSlab(AHBlocks.SCURANE_SLAB.get())
                .withFence(AHBlocks.SCURANE_FENCE.get())
                .withStairs(AHBlocks.SCURANE_STAIRS.get())
                .withButton(AHBlocks.SCURANE_BUTTON.get())
                .withPressurePlate(AHBlocks.SCURANE_PRESSURE_PLATE.get());
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
}
