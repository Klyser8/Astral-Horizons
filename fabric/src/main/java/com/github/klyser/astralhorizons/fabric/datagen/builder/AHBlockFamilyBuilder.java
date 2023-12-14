package com.github.klyser.astralhorizons.fabric.datagen.builder;

import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.world.level.block.Block;

/**
 * Builder for block families.
 */
public class AHBlockFamilyBuilder {

    private BlockModelGenerators.BlockFamilyProvider familyProvider;

    public AHBlockFamilyBuilder(BlockModelGenerators blockModelGenerator, Block block) {
        this.familyProvider = blockModelGenerator.family(block);
    }

    /**
     * Adds a slab to the block family.
     *
     * @param buttonBlock the slab block
     * @return this builder
     */
    public AHBlockFamilyBuilder withButton(Block buttonBlock) {
        familyProvider = familyProvider.button(buttonBlock);
        return this;
    }

    /**
     * Adds a button to the block family.
     *
     * @param wallBlock the wall block
     * @return this builder
     */
    public AHBlockFamilyBuilder withWall(Block wallBlock) {
        familyProvider = familyProvider.wall(wallBlock);
        return this;
    }

    /**
     * Adds a door to the block family.
     *
     * @param fenceBlock the fence block
     * @return this builder
     */
    public AHBlockFamilyBuilder withFence(Block fenceBlock) {
        familyProvider = familyProvider.fence(fenceBlock);
        return this;
    }

    /**
     * Adds a fence gate to the block family.
     *
     * @param fenceGateBlock the fence gate block
     * @return this builder
     */
    public AHBlockFamilyBuilder withFenceGate(Block fenceGateBlock) {
        familyProvider = familyProvider.fenceGate(fenceGateBlock);
        return this;
    }

    /**
     * Adds a pressure plate to the block family.
     *
     * @param pressurePlateBlock the pressure plate block
     * @return this builder
     */
    public AHBlockFamilyBuilder withPressurePlate(Block pressurePlateBlock) {
        familyProvider = familyProvider.pressurePlate(pressurePlateBlock);
        return this;
    }

    /**
     * Adds a sign to the block family.
     *
     * @param signBlock the sign block
     * @return this builder
     */
    public AHBlockFamilyBuilder withSign(Block signBlock) {
        familyProvider = familyProvider.sign(signBlock);
        return this;
    }

    /**
     * Adds a slab to the block family.
     *
     * @param slabBlock the slab block
     * @return this builder
     */
    public AHBlockFamilyBuilder withSlab(Block slabBlock) {
        familyProvider = familyProvider.slab(slabBlock);
        return this;
    }

    /**
     * Adds a stairs to the block family.
     *
     * @param stairsBlock the stairs block
     * @return this builder
     */
    public AHBlockFamilyBuilder withStairs(Block stairsBlock) {
        familyProvider = familyProvider.stairs(stairsBlock);
        return this;
    }
}
