package com.github.klyser.astralhorizons.mixin;

import com.github.klyser.astralhorizons.network.AHPacketData;
import com.github.klyser.astralhorizons.registry.AHBiomes;
import com.github.klyser.astralhorizons.registry.AHTags;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.ColorResolver;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.Optional;

@Mixin(BiomeColors.class)
public abstract class TweakAnomalousWaterColorMixin {

    //TODO Figure out how to coloar water properly
    /*@ModifyArg(method = "getAverageWaterColor", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/renderer/BiomeColors;" +
                    "getAverageColor(Lnet/minecraft/world/level/BlockAndTintGetter;Lnet/minecraft/core/BlockPos;" +
                    "Lnet/minecraft/world/level/ColorResolver;)I"), index = 2)
    private static ColorResolver tweakColorResolver(BlockAndTintGetter level, BlockPos blockPos, ColorResolver original) {
        return (biome, d, e) -> {
            Optional<Boolean> maybeBiomeInTag = Optional.ofNullable(Minecraft.getInstance().getConnection())
                    .map(ClientPacketListener::registryAccess)
                    .map(registryAccess -> registryAccess.registryOrThrow(Registries.BIOME))
                    .map(registry -> registry.wrapAsHolder(biome))
                    .map(biomeHolder -> biomeHolder.is(AHTags.IS_ANOMALOUS));
            System.out.println("maybeBiomeInTag = " + maybeBiomeInTag);
            return 0;
        };
    }*/
}
