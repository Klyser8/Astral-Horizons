package com.github.klyser.astralhorizons.block.vegetation;

import com.github.klyser.astralhorizons.block.CloakedBlock;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import com.mojang.serialization.MapCodec;
import de.dafuqs.revelationary.api.revelations.RevelationAware;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Hashtable;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("deprecation")
public class TwistedTendrilStemBlock extends GrowingPlantBodyBlock implements SimpleWaterloggedBlock, CloakedBlock {
    protected static final VoxelShape SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);
    public static final MapCodec<TwistedTendrilStemBlock> CODEC = simpleCodec(properties -> new TwistedTendrilStemBlock(properties, Blocks.AIR));
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected final Block cloakBlock;

    public TwistedTendrilStemBlock(Properties properties, Block cloakBlock) {
        super(properties, Direction.UP, SHAPE, true);
        this.cloakBlock = cloakBlock;
        registerDefaultState(defaultBlockState()
                .setValue(WATERLOGGED, false));
        RevelationAware.register(this);
    }

    @Override
    protected MapCodec<? extends TwistedTendrilStemBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
        super.createBlockStateDefinition(builder);
    }

    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) AHBlocks.TWISTED_TENDRIL_HEAD.get();
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.getValue(WATERLOGGED)) {
            return Fluids.WATER.getSource(false);
        }
        return super.getFluidState(state);
    }

    @Override
    protected boolean canAttachTo(BlockState state) {
        return ((TwistedTendrilHeadBlock) getHeadBlock()).canAttachTo(state); // Cast due to weird protected access
    }

    @Override
    protected BlockState updateHeadAfterConvertedFromBody(BlockState head, BlockState body) {
        body = body.setValue(WATERLOGGED, head.getValue(WATERLOGGED));
        return body;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(level, pos);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
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

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        getHeadBlock().entityInside(state, level, pos, entity);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        BlockState headState = null;
        BlockPos abovePos = pos.above();
        while (headState == null) {
            BlockState aboveState = level.getBlockState(abovePos);
            if (aboveState.is(getHeadBlock())) {
                headState = aboveState;
            }
            if (aboveState.isAir()) {
                return true;
            }
            abovePos = abovePos.above();
        }
        return !headState.getValue(TwistedTendrilHeadBlock.SPROUTED);
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        Optional<BlockPos> optional = this.getHeadPos(level, pos, state.getBlock());
        BlockPos headPos;
        if (optional.isEmpty()) {
            if (state.is(getHeadBlock())) {
                headPos = pos;
            } else {
                return;
            }
        } else {
            headPos = optional.get();
        }
        BlockState headState = level.getBlockState(headPos);
        TwistedTendrilHeadBlock headBlock = (TwistedTendrilHeadBlock) getHeadBlock();
        int age = headState.getValue(TwistedTendrilHeadBlock.AGE);
        int blocksToGrow = headBlock.getBlocksToGrowWhenBonemealed(random);
        while (blocksToGrow > 0) {
            if (!headBlock.canGrowInto(level.getBlockState(headPos.relative(this.growthDirection)))) {
                break;
            }
            BlockState oldState = level.getBlockState(headPos);
            boolean wasOldStateWater = oldState.getOptionalValue(WATERLOGGED).orElseGet(() -> oldState.is(Blocks.WATER));
            level.setBlockAndUpdate(headPos, headState
                    .setValue(TwistedTendrilHeadBlock.AGE, age)
                    .setValue(WATERLOGGED, wasOldStateWater));
            headPos = headPos.relative(this.growthDirection);
            age = 0;
            blocksToGrow--;
        }
    }

    private Optional<BlockPos> getHeadPos(BlockGetter level, BlockPos pos, Block block) {
        return BlockUtil.getTopConnectedBlock(level, pos, block, this.growthDirection, this.getHeadBlock());
    }
}
