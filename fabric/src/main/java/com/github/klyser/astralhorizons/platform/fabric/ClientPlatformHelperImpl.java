package com.github.klyser.astralhorizons.platform.fabric;

import com.github.klyser.astralhorizons.AstralHorizons;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class ClientPlatformHelperImpl {

    public static void setBlockRenderType(Block block, RenderType renderType) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, renderType);
    }

    public static <T extends ParticleType<ParticleOptions>> Supplier<T> registerParticleType(String name, Supplier<T> particle) {
        T registry = Registry.register(BuiltInRegistries.PARTICLE_TYPE, AstralHorizons.id(name), particle.get());
        return () -> registry;
    }
}
