package com.github.klyser.astralhorizons.fabric.datagen.builder;

import com.github.klyser.astralhorizons.registry.AHBlocks;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.world.level.block.Block;

public class AHWoodBuilder extends AHBlockFamilyBuilder {

    public AHWoodBuilder(BlockModelGenerators blockModelGenerator, Block logBlock, Block woodBlock, Block strippedLogBlock, Block strippedWoodBlock, Block planksBlock) {
        super(blockModelGenerator, planksBlock);
        blockModelGenerator.woodProvider(logBlock).logWithHorizontal(logBlock).wood(woodBlock);
        blockModelGenerator.woodProvider(strippedLogBlock).logWithHorizontal(strippedLogBlock).wood(strippedWoodBlock);
    }

    public AHWoodBuilder withFenceGate(Block fenceGateBlock) {
        familyProvider = familyProvider.fenceGate(fenceGateBlock);
        return this;
    }

    public AHWoodBuilder withSign(Block signBlock) {

        familyProvider = familyProvider.sign(signBlock); //FIXME: This may not be correct.
        return this;
    }

    public AHWoodBuilder withHangingSign(Block particleBlock, Block hangingSignBlock, Block wallHangingSignBlock) {
        blockModelGenerator.createHangingSign(particleBlock, hangingSignBlock, wallHangingSignBlock);
        return this;
    }

    public AHWoodBuilder withDoor(Block doorBlock) {
        blockModelGenerator.createDoor(doorBlock);
        return this;
    }

    public AHWoodBuilder withTrapdoor(Block trapdoorBlock) {
        blockModelGenerator.createTrapdoor(trapdoorBlock);
        return this;
    }

    public AHWoodBuilder withLeaves(Block leavesBlock) {
        blockModelGenerator.createTrivialCube(leavesBlock);
        return this;
    }

}
