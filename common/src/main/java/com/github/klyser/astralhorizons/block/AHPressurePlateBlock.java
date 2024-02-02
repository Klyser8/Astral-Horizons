package com.github.klyser.astralhorizons.block;

import net.minecraft.util.Tuple;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.Hashtable;
import java.util.Map;

public class AHPressurePlateBlock extends PressurePlateBlock implements CloakedBlock{
    protected final Block cloakBlock;
    public AHPressurePlateBlock(BlockSetType blockSetType, Properties properties, Block cloakBlock) {
        super(blockSetType, properties);
        this.cloakBlock = cloakBlock;
    }

    @Override
    public Tuple<Block, Block> getBlockTuple() {
        return new Tuple<>(this, cloakBlock);
    }

    @Override
    public Map<BlockState, BlockState> getBlockStateCloaks() { //TODO implement
        return new Hashtable<>();
    }
}
