package com.github.klyser.astralhorizons.block;

import de.dafuqs.revelationary.api.revelations.RevelationAware;
import net.minecraft.core.Direction;
import net.minecraft.util.Tuple;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Hashtable;
import java.util.Map;

public class AnomalousRotatedPillarBlock extends RotatedPillarBlock implements CloakedBlock {
    protected final Block cloakBlock;
    public AnomalousRotatedPillarBlock(Properties properties, Block cloakBlock) {
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
        for (Direction.Axis axis : Direction.Axis.values()) {
            cloaks.put(defaultBlockState().setValue(AXIS, axis), cloakBlock.defaultBlockState().setValue(AXIS, axis));
        }
        return cloaks;
    }
}
