package com.github.klyser.astralhorizons.block.vegetation;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;

public class AnomalousSaplingBlock extends SaplingBlock {
    private final TagKey<Block> mayPlaceOn;
    public static final MapCodec<AnomalousSaplingBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            TreeGrower.CODEC.fieldOf("tree_grower").forGetter(block -> block.treeGrower),
            AnomalousSaplingBlock.propertiesCodec(),
            TagKey.hashedCodec(Registries.BLOCK).fieldOf("may_place_on").forGetter(block -> block.mayPlaceOn)
    ).apply(instance, AnomalousSaplingBlock::new));
    public AnomalousSaplingBlock(TreeGrower treeGrower, Properties properties, TagKey<Block> mayPlaceOn) {
        super(treeGrower, properties);
        this.mayPlaceOn = mayPlaceOn;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(mayPlaceOn);
    }
}
