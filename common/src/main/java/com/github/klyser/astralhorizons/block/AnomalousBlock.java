package com.github.klyser.astralhorizons.block;

import de.dafuqs.revelationary.api.revelations.RevelationAware;
import net.minecraft.util.Tuple;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Hashtable;
import java.util.Map;

public class AnomalousBlock extends Block implements CloakedBlock {
    protected final Block cloakBlock;
    public AnomalousBlock(Properties properties, Block cloakBlock) {
        super(properties);
        this.cloakBlock = cloakBlock;
        RevelationAware.register(this);
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
