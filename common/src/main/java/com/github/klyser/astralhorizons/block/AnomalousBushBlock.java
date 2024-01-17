package com.github.klyser.astralhorizons.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;

public class AnomalousBushBlock extends BushBlock {

    private final TagKey<Block> mayPlaceOn;
    public static final MapCodec<AnomalousBushBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            AnomalousBushBlock.propertiesCodec(), TagKey.hashedCodec(Registries.BLOCK).fieldOf("may_place_on").forGetter(block -> block.mayPlaceOn)
    ).apply(instance, AnomalousBushBlock::new));
    public AnomalousBushBlock(Properties properties, TagKey<Block> mayPlaceOn) {
        super(properties);
        this.mayPlaceOn = mayPlaceOn;
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(mayPlaceOn);
    }
}
