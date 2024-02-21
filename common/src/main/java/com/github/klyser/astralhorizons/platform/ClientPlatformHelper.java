package com.github.klyser.astralhorizons.platform;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class ClientPlatformHelper {

    @ExpectPlatform
    public static void setBlockRenderType(Block block, RenderType renderType) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends ParticleType<ParticleOptions>> Supplier<T> registerParticleType(String name, Supplier<T> particle) {
        throw new AssertionError();
    }

}
