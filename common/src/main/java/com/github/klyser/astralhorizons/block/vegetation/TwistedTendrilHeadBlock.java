package com.github.klyser.astralhorizons.block.vegetation;

import com.github.klyser.astralhorizons.MixinCallbacks;
import com.github.klyser.astralhorizons.block.CloakedBlock;
import com.github.klyser.astralhorizons.registry.AHBlockStateProperties;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import com.github.klyser.astralhorizons.registry.AHItems;
import com.github.klyser.astralhorizons.registry.AHTags;
import com.mojang.serialization.MapCodec;
import de.dafuqs.revelationary.api.revelations.RevelationAware;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Tuple;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Hashtable;
import java.util.Map;
import java.util.function.ToIntFunction;

public class TwistedTendrilHeadBlock extends GrowingPlantHeadBlock implements SimpleWaterloggedBlock, CloakedBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty SPROUTED = AHBlockStateProperties.SPROUTED;
    public static final int SPROUT_AGE = 25;
    private static final double AGE_PER_TICK_PROBABILITY = 0.15;
    protected static final VoxelShape NORMAL_SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 12.0, 12.0);
    protected static final VoxelShape SPROUTED_SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 15.0, 12.0);
    protected final Block cloakBlock;
    public static final MapCodec<TwistedTendrilHeadBlock> CODEC = simpleCodec(properties -> new TwistedTendrilHeadBlock(properties, Blocks.AIR));

    public TwistedTendrilHeadBlock(Properties properties, Block cloakBlock) {
        super(properties, Direction.UP, SPROUTED_SHAPE, true, AGE_PER_TICK_PROBABILITY);
        this.cloakBlock = cloakBlock;
        registerDefaultState(defaultBlockState()
                .setValue(WATERLOGGED, false)
                .setValue(SPROUTED, false));
        RevelationAware.register(this);
    }

    @Override
    protected MapCodec<? extends TwistedTendrilHeadBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
        builder.add(SPROUTED);
        super.createBlockStateDefinition(builder);
    }

    @Override
    protected Block getBodyBlock() {
        return AHBlocks.TWISTED_TENDRIL_STEM.get();
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.getValue(WATERLOGGED)) {
            return Fluids.WATER.getSource(false);
        }
        return super.getFluidState(state);
    }

    @Override
    public boolean canGrowInto(BlockState state) {
        //TODO: should only grow in anomalous biomes
        return state.is(Blocks.WATER) || state.isAir();
    }

    public BlockState getStateForAge(int age) {
        return defaultBlockState().setValue(AGE, age);
    }

    public int getAge(BlockState state) {
        return state.getValue(AGE);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(SPROUTED);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(level, pos);
        if (state.getValue(SPROUTED)) {
            return SPROUTED_SHAPE.move(offset.x, offset.y, offset.z);
        }
        return NORMAL_SHAPE.move(offset.x, offset.y, offset.z);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos originPos, RandomSource random) {
        if (!level.getBiome(originPos).is(AHTags.IS_ANOMALOUS)) {
            return;
        }
        // Age the plant
        if (getAge(state) < MAX_AGE && random.nextFloat() < AGE_PER_TICK_PROBABILITY * 5) {
            level.setBlock(originPos, getStateForAge(state.getValue(AGE) + 1).setValue(WATERLOGGED, state.getValue(WATERLOGGED)), Block.UPDATE_ALL);
        }

        // Make plant sprout
        if (!state.getValue(WATERLOGGED) && getAge(state) == SPROUT_AGE && !state.getValue(SPROUTED)) {
            level.setBlock(originPos, state.setValue(SPROUTED, true), Block.UPDATE_ALL);
            return;
        }

        // Whether the plant should grow out of the water
        int maxHeight = calculateMaxHeightBasedOnPosition(level, originPos);
        if (calculateCurrentHeightOutOfWater(level, originPos) >= maxHeight) {
            return;
        }

        // Grow the plant
        BlockPos offsetPos = originPos.relative(this.growthDirection);
        BlockState offsetBlockState = level.getBlockState(offsetPos);
        if (this.canGrowInto(offsetBlockState) && state.getValue(AGE) == MAX_AGE - 1) {
            BlockState plantAboveState = this.defaultBlockState();
            if (!offsetBlockState.isAir()) {
                plantAboveState = plantAboveState.setValue(WATERLOGGED, true);
            }
            level.setBlockAndUpdate(offsetPos, plantAboveState);
        }
    }

    @Override
    protected BlockState updateBodyAfterConvertedFromHead(BlockState head, BlockState body) {
        body = body.setValue(WATERLOGGED, head.getValue(WATERLOGGED));
        return body;
    }
    @Override
    public boolean canAttachTo(BlockState state) {
        return state.is(AHBlocks.ANOMADIRT.get()) || state.is(AHBlocks.LUTIEL.get()) || state.is(AHBlocks.ANOMASAND.get())
                || state.is(AHBlocks.TWISTED_TENDRIL_STEM.get()) || state.is(AHBlocks.TWISTED_TENDRIL_HEAD.get())
                || state.is(AHBlocks.ANOMAGRASS_BLOCK.get());
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
        boolean isInWater = fluidState.is(FluidTags.WATER) && fluidState.getAmount() == 8;
        BlockState belowState = context.getLevel().getBlockState(context.getClickedPos().below());
        boolean isOnPlant = (belowState.is(this) && !belowState.getValue(SPROUTED)) ||
                belowState.is(getBodyBlock());
        if (isInWater || isOnPlant) {
            return defaultBlockState().setValue(WATERLOGGED,
                    context.getLevel().getFluidState(context.getClickedPos()).is(Fluids.WATER) ||
                            context.getLevel().getFluidState(context.getClickedPos()).is(Fluids.FLOWING_WATER)
            );
        } else {
            return null;
        }
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

    public static ToIntFunction<BlockState> emission(int lightLevel) {
        return blockState -> blockState.getValue(AHBlockStateProperties.SPROUTED) ? lightLevel : 0;
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        entity.resetFallDistance();
        if (entity.onGround()) {
            entity.setDeltaMovement(entity.getDeltaMovement().multiply(0.5, 1, 0.5));
        } else {
            entity.setDeltaMovement(entity.getDeltaMovement().multiply(0.95, 0.9, 0.95));
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (state.getValue(SPROUTED)) {
            Block.popResource(level, pos, new ItemStack(AHItems.STARFLARE_BLOSSOM.get(), 1));
            float pitch = Mth.randomBetween(level.random, 0.8F, 1.2F);
            level.playSound(null, pos, SoundEvents.CAVE_VINES_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, pitch); //TODO replace with custom sound
            BlockState blockState = state.setValue(SPROUTED, false).setValue(AGE, 0);
            level.setBlock(pos, blockState, Block.UPDATE_ALL);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockState));
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return !state.getValue(SPROUTED);
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        boolean isBlockBelowSoil = !level.getBlockState(pos.below()).is(getBodyBlock());
        if (isBlockBelowSoil || state.getValue(WATERLOGGED)) {
            ((TwistedTendrilStemBlock) getBodyBlock()).performBonemeal(level, random, pos, state);
        } else {
            level.setBlock(pos, state.setValue(SPROUTED, true), Block.UPDATE_ALL);
        }
    }

    @Override
    public int getBlocksToGrowWhenBonemealed(RandomSource random) {
        return random.nextInt(3) + 2;
    }

    private int calculateMaxHeightBasedOnPosition(ServerLevel level, BlockPos pos)  {
        long seed = level.getSeed();
        int maxHeight = (int) (seed % 2) + 2;
        maxHeight += pos.getX() % 3;
        maxHeight += pos.getZ() % 3;
        maxHeight += pos.getY() % 2;
        return (maxHeight % 7) + 2;
    }

    private int calculateCurrentHeightOutOfWater(Level level, BlockPos originPos) {
        int heightOutOfWater = 1;
        while (true) {
            BlockState stateBelow = level.getBlockState(originPos.below(heightOutOfWater));
            boolean isNotPlantOrIsNotWaterlogged = (!stateBelow.is(this ) && !stateBelow.is(getBodyBlock())) || stateBelow.getValue(WATERLOGGED);
            if (isNotPlantOrIsNotWaterlogged) {
                break;
            }
            heightOutOfWater++;
        }
        return heightOutOfWater;
    }

}
