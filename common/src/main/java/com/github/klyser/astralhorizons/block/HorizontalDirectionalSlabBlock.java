package com.github.klyser.astralhorizons.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class HorizontalDirectionalSlabBlock extends SlabBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public HorizontalDirectionalSlabBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        super.createBlockStateDefinition(builder);
    }
    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        BlockState clickedBlockState = context.getLevel().getBlockState(blockPos);
        if (clickedBlockState.is(this)) {
            return clickedBlockState.setValue(TYPE, SlabType.DOUBLE).setValue(WATERLOGGED, false);
        }
        FluidState fluidState = context.getLevel().getFluidState(blockPos);
        BlockState slabState = this.defaultBlockState().setValue(TYPE, SlabType.BOTTOM).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        Direction direction = context.getClickedFace();
        // Block states are immutable, so we have to assign it to itself.
        slabState = slabState.setValue(FACING, context.getHorizontalDirection().getOpposite());
        if (direction == Direction.DOWN || direction != Direction.UP && context.getClickLocation().y - (double)blockPos.getY() > 0.5) {
            return slabState.setValue(TYPE, SlabType.TOP);
        }
        return slabState;
    }
}
