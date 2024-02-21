package com.github.klyser.astralhorizons.block.vegetation;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class AnomalousBushBlock extends BushBlock {

    @Nullable private final TagKey<Block> mayPlaceOnTag;
    @Nullable private final Block mayPlaceOnBlock;
    public static final MapCodec<AnomalousBushBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            AnomalousBushBlock.propertiesCodec(), TagKey.hashedCodec(Registries.BLOCK).fieldOf("may_place_on").forGetter(block -> block.mayPlaceOnTag)
    ).apply(instance, AnomalousBushBlock::new));
    public AnomalousBushBlock(Properties properties, TagKey<Block> mayPlaceOnTag) {
        super(properties);
        this.mayPlaceOnTag = mayPlaceOnTag;
        this.mayPlaceOnBlock = null;
    }

    public AnomalousBushBlock(Properties properties, Block mayPlaceOnTag) {
        super(properties);
        this.mayPlaceOnTag = null;
        this.mayPlaceOnBlock = mayPlaceOnTag;
    }

    @SuppressWarnings("DataFlowIssue")
    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        if (mayPlaceOnTag != null) {
            return state.is(mayPlaceOnTag);
        } else {
            return state.is(mayPlaceOnBlock);
        }
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }
}
