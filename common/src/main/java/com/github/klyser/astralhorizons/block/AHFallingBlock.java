package com.github.klyser.astralhorizons.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.FallingBlock;
import org.jetbrains.annotations.NotNull;

public class AHFallingBlock extends FallingBlock {

    public static final MapCodec<FallingBlock> CODEC = simpleCodec(AHFallingBlock::new);
    public AHFallingBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull MapCodec<? extends FallingBlock> codec() {
        return CODEC;
    }
}
