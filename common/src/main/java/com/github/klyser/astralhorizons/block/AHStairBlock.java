package com.github.klyser.astralhorizons.block;

import net.minecraft.util.Tuple;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.StairsShape;

import java.util.Hashtable;
import java.util.Map;

public class AHStairBlock extends StairBlock implements CloakedBlock {
    protected final Block cloakBlock;
    public AHStairBlock(BlockState baseState, Properties properties, Block cloakBlock) {
        super(baseState, properties);
        this.cloakBlock = cloakBlock;
    }

    @Override
    public Tuple<Block, Block> getBlockTuple() {
        return new Tuple<>(this, cloakBlock);
    }

    @Override
    public Map<BlockState, BlockState> getBlockStateCloaks() {
        Map<BlockState, BlockState> cloaks = new Hashtable<>();
        for (StairsShape stairShape : StairsShape.values()) {
            cloaks.put(defaultBlockState().setValue(SHAPE, stairShape), cloakBlock.defaultBlockState().setValue(SHAPE, stairShape));
        }
        return cloaks;
    }
}
