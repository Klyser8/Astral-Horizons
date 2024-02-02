package com.github.klyser.astralhorizons.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.Tuple;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.Hashtable;
import java.util.Map;

public class AHFallingBlock extends FallingBlock implements CloakedBlock {
    public static final MapCodec<FallingBlock> CODEC = simpleCodec(properties -> new AHFallingBlock(properties, Blocks.AIR));
    protected final Block cloakBlock;
    public AHFallingBlock(Properties properties, Block cloakBlock) {
        super(properties);
        this.cloakBlock = cloakBlock;
    }

    @Override
    protected @NotNull MapCodec<? extends FallingBlock> codec() {
        return CODEC;
    }


    @Override
    public Tuple<Block, Block> getBlockTuple() {
        return new Tuple<>(this, cloakBlock);
    }

    @Override
    public Map<BlockState, BlockState> getBlockStateCloaks() {
        Map<BlockState, BlockState> cloaks = new Hashtable<>();
        cloaks.put(defaultBlockState(), cloakBlock.defaultBlockState());
        return cloaks;
    }
}
