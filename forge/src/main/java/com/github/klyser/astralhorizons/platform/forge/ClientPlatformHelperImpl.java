package com.github.klyser.astralhorizons.platform.forge;

import com.github.klyser.astralhorizons.AstralHorizons;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ClientPlatformHelperImpl {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, AstralHorizons.MOD_ID);

    public static void setBlockRenderType(Block block, RenderType renderType) {
        ItemBlockRenderTypes.setRenderLayer(block, RenderType.cutout());
    }

    public static <T extends ParticleType<ParticleOptions>> Supplier<T> registerParticleType(String name, Supplier<T> particle) {
        return PARTICLE_TYPES.register(name, particle);
    }
}
