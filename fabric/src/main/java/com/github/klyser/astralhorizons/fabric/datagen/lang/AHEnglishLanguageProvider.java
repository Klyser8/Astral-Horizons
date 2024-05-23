package com.github.klyser.astralhorizons.fabric.datagen.lang;

import com.github.klyser.astralhorizons.registry.AHBlocks;
import com.github.klyser.astralhorizons.registry.AHCreativeModeTabs;
import com.github.klyser.astralhorizons.registry.AHItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;



public class AHEnglishLanguageProvider extends AHLanguageProvider {
    public AHEnglishLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    protected void addItemTranslations() {
        translationBuilder.add(AHItems.ANOMADIRT.get(), "Anomadirt");
        translationBuilder.add(AHItems.ANOMASTONE.get(), "Anomastone");
        translationBuilder.add(AHItems.ANOMAGRASS_BLOCK.get(), "Anomagrass Block");
        translationBuilder.add(AHItems.LUTIEL.get(), "Lutiel");
        translationBuilder.add(AHItems.ANOMASTONE_SLAB.get(), "Anomastone Slab");
        translationBuilder.add(AHItems.ANOMASTONE_STAIRS.get(), "Anomastone Stairs");
        translationBuilder.add(AHItems.ANOMASTONE_PRESSURE_PLATE.get(), "Anomastone Pressure Plate");
        translationBuilder.add(AHItems.ANOMASTONE_BUTTON.get(), "Anomastone Button");
        translationBuilder.add(AHItems.COBBLED_ANOMASTONE.get(), "Cobbled Anomastone");
        translationBuilder.add(AHItems.COBBLED_ANOMASTONE_SLAB.get(), "Cobbled Anomastone Slab");
        translationBuilder.add(AHItems.COBBLED_ANOMASTONE_STAIRS.get(), "Cobbled Anomastone Stairs");
        translationBuilder.add(AHItems.COBBLED_ANOMASTONE_WALL.get(), "Cobbled Anomastone Wall");
        translationBuilder.add(AHItems.ANOMASTONE_BRICKS.get(), "Anomastone Bricks");
        translationBuilder.add(AHItems.ANOMASTONE_BRICK_STAIRS.get(), "Anomastone Brick Stairs");
        translationBuilder.add(AHItems.ANOMASTONE_BRICK_SLAB.get(), "Anomastone Brick Slab");
        translationBuilder.add(AHItems.ANOMASTONE_BRICK_WALL.get(), "Anomastone Brick Wall");
        translationBuilder.add(AHItems.CHISELED_ANOMASTONE_BRICKS.get(), "Chiseled Anomastone Bricks");
        translationBuilder.add(AHItems.CHLORITE.get(), "Chlorite");
        translationBuilder.add(AHItems.CHLORITE_SLAB.get(), "Chlorite Slab");
        translationBuilder.add(AHItems.CHLORITE_STAIRS.get(), "Chlorite Stairs");
        translationBuilder.add(AHItems.CHLORITE_WALL.get(), "Chlorite Wall");
        translationBuilder.add(AHItems.CHLORITE_BRICKS.get(), "Chlorite Bricks");
        translationBuilder.add(AHItems.CHLORITE_BRICK_SLAB.get(), "Chlorite Brick Slab");
        translationBuilder.add(AHItems.CHLORITE_BRICK_STAIRS.get(), "Chlorite Brick Stairs");
        translationBuilder.add(AHItems.CHLORITE_BRICK_WALL.get(), "Chlorite Brick Wall");
        translationBuilder.add(AHItems.SIDEROCK.get(), "Siderock");
        translationBuilder.add(AHItems.SIDEROCK_SLAB.get(), "Siderock Slab");
        translationBuilder.add(AHItems.SIDEROCK_STAIRS.get(), "Siderock Stairs");
        translationBuilder.add(AHItems.SIDEROCK_WALL.get(), "Siderock Wall");
        translationBuilder.add(AHItems.SIDEROCK_BRICKS.get(), "Siderock Bricks");
        translationBuilder.add(AHItems.SIDEROCK_BRICK_SLAB.get(), "Siderock Brick Slab");
        translationBuilder.add(AHItems.SIDEROCK_BRICK_STAIRS.get(), "Siderock Brick Stairs");
        translationBuilder.add(AHItems.SIDEROCK_BRICK_WALL.get(), "Siderock Brick Wall");
        translationBuilder.add(AHItems.AURANITE.get(), "Auranite");
        translationBuilder.add(AHItems.AURANITE_SLAB.get(), "Auranite Slab");
        translationBuilder.add(AHItems.AURANITE_STAIRS.get(), "Auranite Stairs");
        translationBuilder.add(AHItems.AURANITE_WALL.get(), "Auranite Wall");
        translationBuilder.add(AHItems.AURANITE_BRICKS.get(), "Auranite Bricks");
        translationBuilder.add(AHItems.AURANITE_BRICK_SLAB.get(), "Auranite Brick Slab");
        translationBuilder.add(AHItems.AURANITE_BRICK_STAIRS.get(), "Auranite Brick Stairs");
        translationBuilder.add(AHItems.AURANITE_BRICK_WALL.get(), "Auranite Brick Wall");
        translationBuilder.add(AHItems.ANOMASAND.get(), "Anomasand");
        translationBuilder.add(AHItems.ANOMASANDSTONE.get(), "Anomasandstone");
        translationBuilder.add(AHItems.ANOMASANDSTONE_SLAB.get(), "Anomasandstone Slab");
        translationBuilder.add(AHItems.ANOMASANDSTONE_STAIRS.get(), "Anomasandstone Stairs");
        translationBuilder.add(AHItems.ANOMASANDSTONE_WALL.get(), "Anomasandstone Wall");
        translationBuilder.add(AHItems.SMOOTH_ANOMASANDSTONE.get(), "Smooth Anomasandstone");
        translationBuilder.add(AHItems.SMOOTH_ANOMASANDSTONE_SLAB.get(), "Smooth Anomasandstone Slab");
        translationBuilder.add(AHItems.SMOOTH_ANOMASANDSTONE_STAIRS.get(), "Smooth Anomasandstone Stairs");
        translationBuilder.add(AHItems.CUT_ANOMASANDSTONE.get(), "Cut Anomasandstone");
        translationBuilder.add(AHItems.CUT_ANOMASANDSTONE_SLAB.get(), "Cut Anomasandstone Slab");
        translationBuilder.add(AHItems.ANOMALICE.get(), "Anomalice");
        translationBuilder.add(AHItems.ANOMASNOW_BLOCK.get(), "Anomasnow Block");
        translationBuilder.add(AHItems.SCURANE_LOG.get(), "Scurane Log");
        translationBuilder.add(AHItems.SCURANE_WOOD.get(), "Scurane Wood");
        translationBuilder.add(AHItems.STRIPPED_SCURANE_LOG.get(), "Stripped Scurane Log");
        translationBuilder.add(AHItems.STRIPPED_SCURANE_WOOD.get(), "Stripped Scurane Wood");
        translationBuilder.add(AHItems.SCURANE_LEAVES.get(), "Scurane Leaves");
        translationBuilder.add(AHItems.SCURANE_PLANKS.get(), "Scurane Planks");
        translationBuilder.add(AHItems.SCURANE_SLAB.get(), "Scurane Slab");
        translationBuilder.add(AHItems.SCURANE_STAIRS.get(), "Scurane Stairs");
        translationBuilder.add(AHItems.SCURANE_FENCE.get(), "Scurane Fence");
        translationBuilder.add(AHItems.SCURANE_FENCE_GATE.get(), "Scurane Fence Gate");
        translationBuilder.add(AHItems.SCURANE_DOOR.get(), "Scurane Door");
        translationBuilder.add(AHItems.SCURANE_TRAPDOOR.get(), "Scurane Trapdoor");
        translationBuilder.add(AHItems.SCURANE_PRESSURE_PLATE.get(), "Scurane Pressure Plate");
        translationBuilder.add(AHItems.SCURANE_BUTTON.get(), "Scurane Button");
        translationBuilder.add(AHItems.ANOMALOUS_SHORT_GRASS.get(), "Anomalous Short Grass");
        translationBuilder.add(AHItems.SICKENED_SHRUB.get(), "Sickened Shrub");

    }

    @Override
    protected void addBlockTranslations() {
        /*translationBuilder.add(AHBlocks.ANOMADIRT.get(), "Anomadirt");
        translationBuilder.add(AHBlocks.ANOMASTONE.get(), "Anomastone");
        translationBuilder.add(AHBlocks.ANOMAGRASS_BLOCK.get(), "Anomagrass Block");
        translationBuilder.add(AHBlocks.LUTIEL.get(), "Lutiel");
        translationBuilder.add(AHBlocks.ANOMASTONE_SLAB.get(), "Anomastone Slab");
        translationBuilder.add(AHBlocks.ANOMASTONE_STAIRS.get(), "Anomastone Stairs");
        translationBuilder.add(AHBlocks.ANOMASTONE_PRESSURE_PLATE.get(), "Anomastone Pressure Plate");
        translationBuilder.add(AHBlocks.ANOMASTONE_BUTTON.get(), "Anomastone Button");
        translationBuilder.add(AHBlocks.COBBLED_ANOMASTONE.get(), "Cobbled Anomastone");
        translationBuilder.add(AHBlocks.COBBLED_ANOMASTONE_SLAB.get(), "Cobbled Anomastone Slab");
        translationBuilder.add(AHBlocks.COBBLED_ANOMASTONE_STAIRS.get(), "Cobbled Anomastone Stairs");
        translationBuilder.add(AHBlocks.COBBLED_ANOMASTONE_WALL.get(), "Cobbled Anomastone Wall");
        translationBuilder.add(AHBlocks.ANOMASTONE_BRICKS.get(), "Anomastone Bricks");
        translationBuilder.add(AHBlocks.ANOMASTONE_BRICK_STAIRS.get(), "Anomastone Brick Stairs");
        translationBuilder.add(AHBlocks.ANOMASTONE_BRICK_SLAB.get(), "Anomastone Brick Slab");
        translationBuilder.add(AHBlocks.ANOMASTONE_BRICK_WALL.get(), "Anomastone Brick Wall");
        translationBuilder.add(AHBlocks.CHISELED_ANOMASTONE_BRICKS.get(), "Chiseled Anomastone Bricks");
        translationBuilder.add(AHBlocks.CHLORITE.get(), "Chlorite");
        translationBuilder.add(AHBlocks.CHLORITE_SLAB.get(), "Chlorite Slab");
        translationBuilder.add(AHBlocks.CHLORITE_STAIRS.get(), "Chlorite Stairs");
        translationBuilder.add(AHBlocks.CHLORITE_WALL.get(), "Chlorite Wall");
        translationBuilder.add(AHBlocks.CHLORITE_BRICKS.get(), "Chlorite Bricks");
        translationBuilder.add(AHBlocks.CHLORITE_BRICK_SLAB.get(), "Chlorite Brick Slab");
        translationBuilder.add(AHBlocks.CHLORITE_BRICK_STAIRS.get(), "Chlorite Brick Stairs");
        translationBuilder.add(AHBlocks.CHLORITE_BRICK_WALL.get(), "Chlorite Brick Wall");
        translationBuilder.add(AHBlocks.SIDEROCK.get(), "Siderock");
        translationBuilder.add(AHBlocks.SIDEROCK_SLAB.get(), "Siderock Slab");
        translationBuilder.add(AHBlocks.SIDEROCK_STAIRS.get(), "Siderock Stairs");
        translationBuilder.add(AHBlocks.SIDEROCK_WALL.get(), "Siderock Wall");
        translationBuilder.add(AHBlocks.SIDEROCK_BRICKS.get(), "Siderock Bricks");
        translationBuilder.add(AHBlocks.SIDEROCK_BRICK_SLAB.get(), "Siderock Brick Slab");
        translationBuilder.add(AHBlocks.SIDEROCK_BRICK_STAIRS.get(), "Siderock Brick Stairs");
        translationBuilder.add(AHBlocks.SIDEROCK_BRICK_WALL.get(), "Siderock Brick Wall");
        translationBuilder.add(AHBlocks.AURANITE.get(), "Auranite");
        translationBuilder.add(AHBlocks.AURANITE_SLAB.get(), "Auranite Slab");
        translationBuilder.add(AHBlocks.AURANITE_STAIRS.get(), "Auranite Stairs");
        translationBuilder.add(AHBlocks.AURANITE_WALL.get(), "Auranite Wall");
        translationBuilder.add(AHBlocks.AURANITE_BRICKS.get(), "Auranite Bricks");
        translationBuilder.add(AHBlocks.AURANITE_BRICK_SLAB.get(), "Auranite Brick Slab");
        translationBuilder.add(AHBlocks.AURANITE_BRICK_STAIRS.get(), "Auranite Brick Stairs");
        translationBuilder.add(AHBlocks.AURANITE_BRICK_WALL.get(), "Auranite Brick Wall");
        translationBuilder.add(AHBlocks.ANOMASAND.get(), "Anomasand");
        translationBuilder.add(AHBlocks.ANOMASANDSTONE.get(), "Anomasandstone");
        translationBuilder.add(AHBlocks.ANOMASANDSTONE_SLAB.get(), "Anomasandstone Slab");
        translationBuilder.add(AHBlocks.ANOMASANDSTONE_STAIRS.get(), "Anomasandstone Stairs");
        translationBuilder.add(AHBlocks.ANOMASANDSTONE_WALL.get(), "Anomasandstone Wall");
        translationBuilder.add(AHBlocks.SMOOTH_ANOMASANDSTONE.get(), "Smooth Anomasandstone");
        translationBuilder.add(AHBlocks.SMOOTH_ANOMASANDSTONE_SLAB.get(), "Smooth Anomasandstone Slab");
        translationBuilder.add(AHBlocks.SMOOTH_ANOMASANDSTONE_STAIRS.get(), "Smooth Anomasandstone Stairs");
        translationBuilder.add(AHBlocks.CUT_ANOMASANDSTONE.get(), "Cut Anomasandstone");
        translationBuilder.add(AHBlocks.CUT_ANOMASANDSTONE_SLAB.get(), "Cut Anomasandstone Slab");
        translationBuilder.add(AHBlocks.ANOMALICE.get(), "Anomalice");
        translationBuilder.add(AHBlocks.ANOMASNOW_BLOCK.get(), "Anomasnow Block");
        translationBuilder.add(AHBlocks.SCURANE_LOG.get(), "Scurane Log");
        translationBuilder.add(AHBlocks.SCURANE_WOOD.get(), "Scurane Wood");
        translationBuilder.add(AHBlocks.STRIPPED_SCURANE_LOG.get(), "Stripped Scurane Log");
        translationBuilder.add(AHBlocks.STRIPPED_SCURANE_WOOD.get(), "Stripped Scurane Wood");
        translationBuilder.add(AHBlocks.SCURANE_LEAVES.get(), "Scurane Leaves");
        translationBuilder.add(AHBlocks.SCURANE_PLANKS.get(), "Scurane Planks");
        translationBuilder.add(AHBlocks.SCURANE_SLAB.get(), "Scurane Slab");
        translationBuilder.add(AHBlocks.SCURANE_STAIRS.get(), "Scurane Stairs");
        translationBuilder.add(AHBlocks.SCURANE_FENCE.get(), "Scurane Fence");
        translationBuilder.add(AHBlocks.SCURANE_FENCE_GATE.get(), "Scurane Fence Gate");
        translationBuilder.add(AHBlocks.SCURANE_DOOR.get(), "Scurane Door");
        translationBuilder.add(AHBlocks.SCURANE_TRAPDOOR.get(), "Scurane Trapdoor");
        translationBuilder.add(AHBlocks.SCURANE_PRESSURE_PLATE.get(), "Scurane Pressure Plate");
        translationBuilder.add(AHBlocks.SCURANE_BUTTON.get(), "Scurane Button");
        translationBuilder.add(AHBlocks.ANOMALOUS_SHORT_GRASS.get(), "Anomalous Short Grass");
        translationBuilder.add(AHBlocks.SICKENED_SHRUB.get(), "Sickened Shrub");*/
    }

    @Override
    protected void addItemGroupTranslations() {
        translationBuilder.add(AHCreativeModeTabs.ITEMS.get().getDisplayName().getString(), "Anomalous Items");
        translationBuilder.add(AHCreativeModeTabs.BLOCKS.get().getDisplayName().getString(), "Anomalous Blocks");
    }
}
