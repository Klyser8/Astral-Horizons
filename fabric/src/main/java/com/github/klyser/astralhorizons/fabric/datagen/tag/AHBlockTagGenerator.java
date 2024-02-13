package com.github.klyser.astralhorizons.fabric.datagen.tag;

import com.github.klyser.astralhorizons.registry.AHBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

import static com.github.klyser.astralhorizons.registry.AHTags.*;

public class AHBlockTagGenerator extends FabricTagProvider.BlockTagProvider {

    public AHBlockTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }


    @Override
    protected void addTags(HolderLookup.Provider arg) {
        addPickaxeTags();
        addShovelTags();
        addAxeTags();
        addHoeTags();
        addAnomalousDirtTag();
        addWallTags();
        addAnomalousVegetationTag();
    }

    private void addPickaxeTags() {
        getOrCreateTagBuilder(MINEABLE_PICKAXE)
                .add(AHBlocks.COBBLED_ANOMASTONE.get())
                .add(AHBlocks.ANOMASTONE.get())
                .add(AHBlocks.ANOMASTONE_BRICKS.get())
                .add(AHBlocks.ANOMASTONE_BRICK_STAIRS.get())
                .add(AHBlocks.ANOMASTONE_BRICK_SLAB.get())
                .add(AHBlocks.ANOMASTONE_BRICK_WALL.get())
                .add(AHBlocks.CHISELED_ANOMASTONE_BRICKS.get())
                .add(AHBlocks.ANOMASTONE_STAIRS.get())
                .add(AHBlocks.ANOMASTONE_SLAB.get())
                .add(AHBlocks.ANOMASTONE_PRESSURE_PLATE.get())
                .add(AHBlocks.ANOMASTONE_BUTTON.get())
                .add(AHBlocks.COBBLED_ANOMASTONE_STAIRS.get())
                .add(AHBlocks.COBBLED_ANOMASTONE_SLAB.get())
                .add(AHBlocks.COBBLED_ANOMASTONE_WALL.get())
                .add(AHBlocks.CHLORITE.get())
                .add(AHBlocks.CHLORITE_SLAB.get())
                .add(AHBlocks.CHLORITE_STAIRS.get())
                .add(AHBlocks.CHLORITE_WALL.get())
                .add(AHBlocks.CHLORITE_BRICKS.get())
                .add(AHBlocks.CHLORITE_BRICK_SLAB.get())
                .add(AHBlocks.CHLORITE_BRICK_STAIRS.get())
                .add(AHBlocks.CHLORITE_BRICK_WALL.get())
                .add(AHBlocks.SIDEROCK.get())
                .add(AHBlocks.SIDEROCK_SLAB.get())
                .add(AHBlocks.SIDEROCK_STAIRS.get())
                .add(AHBlocks.SIDEROCK_WALL.get())
                .add(AHBlocks.SIDEROCK_BRICKS.get())
                .add(AHBlocks.SIDEROCK_BRICK_SLAB.get())
                .add(AHBlocks.SIDEROCK_BRICK_STAIRS.get())
                .add(AHBlocks.SIDEROCK_BRICK_WALL.get())
                .add(AHBlocks.AURANITE.get())
                .add(AHBlocks.AURANITE_SLAB.get())
                .add(AHBlocks.AURANITE_STAIRS.get())
                .add(AHBlocks.AURANITE_WALL.get())
                .add(AHBlocks.AURANITE_BRICKS.get())
                .add(AHBlocks.AURANITE_BRICK_SLAB.get())
                .add(AHBlocks.AURANITE_BRICK_STAIRS.get())
                .add(AHBlocks.AURANITE_BRICK_WALL.get())
                .add(AHBlocks.ANOMASANDSTONE.get())
                .add(AHBlocks.ANOMASANDSTONE_SLAB.get())
                .add(AHBlocks.ANOMASANDSTONE_STAIRS.get())
                .add(AHBlocks.ANOMASANDSTONE_WALL.get())
                .add(AHBlocks.SMOOTH_ANOMASANDSTONE.get())
                .add(AHBlocks.SMOOTH_ANOMASANDSTONE_SLAB.get())
                .add(AHBlocks.SMOOTH_ANOMASANDSTONE_STAIRS.get())
                .add(AHBlocks.CUT_ANOMASANDSTONE.get())
                .add(AHBlocks.CUT_ANOMASANDSTONE_SLAB.get())
                .add(AHBlocks.ANOMALICE.get());
    }
    private void addShovelTags() {
        getOrCreateTagBuilder(MINEABLE_SHOVEL)
                .add(AHBlocks.ANOMAGRASS_BLOCK.get())
                .add(AHBlocks.ANOMADIRT.get())
                .add(AHBlocks.ANOMASAND.get())
                .add(AHBlocks.ANOMASNOW_BLOCK.get());
    }
    private void addAxeTags() {
        getOrCreateTagBuilder(MINEABLE_AXE)
                .add(AHBlocks.SCURANE_LOG.get());
    }
    private void addHoeTags() {
        getOrCreateTagBuilder(MINEABLE_HOE)
                .add(AHBlocks.SCURANE_LEAVES.get());
    }
    private void addWallTags() {
        getOrCreateTagBuilder(WALLS)
                .add(AHBlocks.COBBLED_ANOMASTONE_WALL.get())
                .add(AHBlocks.ANOMASTONE_BRICK_WALL.get())
                .add(AHBlocks.CHLORITE_WALL.get())
                .add(AHBlocks.CHLORITE_BRICK_WALL.get())
                .add(AHBlocks.SIDEROCK_WALL.get())
                .add(AHBlocks.SIDEROCK_BRICK_WALL.get())
                .add(AHBlocks.AURANITE_WALL.get())
                .add(AHBlocks.AURANITE_BRICK_WALL.get())
                .add(AHBlocks.ANOMASANDSTONE_WALL.get());
    }
    private void addAnomalousDirtTag() {
        getOrCreateTagBuilder(ANOMALOUS_DIRT)
                .add(AHBlocks.ANOMADIRT.get())
                .add(AHBlocks.ANOMAGRASS_BLOCK.get())
        ;
    }
    private void addAnomalousVegetationTag() {
        getOrCreateTagBuilder(ANOMALOUS_VEGETATION)
                .add(AHBlocks.ANOMALOUS_SHORT_GRASS.get())
                .add(AHBlocks.SICKENED_SHRUB.get())
                .add(AHBlocks.SCURANE_LEAVES.get());
    }
}
