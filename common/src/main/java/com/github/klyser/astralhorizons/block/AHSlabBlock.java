package com.github.klyser.astralhorizons.block;

import net.minecraft.util.Tuple;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;

import java.util.Hashtable;
import java.util.Map;

public class AHSlabBlock extends SlabBlock implements CloakedBlock {
    protected final Block cloakBlock;
    public AHSlabBlock(Properties properties, Block cloakBlock) {
        super(properties);
        this.cloakBlock = cloakBlock;
    }

    @Override
    public Tuple<Block, Block> getBlockTuple() {
        return new Tuple<>(this, cloakBlock);
    }

    @Override
    public Map<BlockState, BlockState> getBlockStateCloaks() {
        Map<BlockState, BlockState> cloaks = new Hashtable<>();
        for (SlabType slabType : SlabType.values()) {
            cloaks.put(defaultBlockState().setValue(TYPE, slabType), cloakBlock.defaultBlockState().setValue(TYPE, slabType));
        }
        return cloaks;
    }
}
