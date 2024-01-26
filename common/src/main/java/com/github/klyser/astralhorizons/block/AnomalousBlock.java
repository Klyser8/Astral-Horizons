package com.github.klyser.astralhorizons.block;

import com.github.klyser.astralhorizons.client.ClientPacketData;
import com.github.klyser.astralhorizons.registry.AHBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class AnomalousBlock extends Block {
    public static final BooleanProperty DRAGON_DEFEATED = BooleanProperty.create("dragon_defeated");
    public AnomalousBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(DRAGON_DEFEATED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DRAGON_DEFEATED);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (ClientPacketData.isDragonDead()) {
            if (!state.getValue(DRAGON_DEFEATED)) {
                state.setValue(DRAGON_DEFEATED, true);
            }
        }
    }
}
