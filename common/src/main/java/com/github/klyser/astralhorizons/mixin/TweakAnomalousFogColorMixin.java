package com.github.klyser.astralhorizons.mixin;

import com.github.klyser.astralhorizons.network.AHPacketData;
import com.github.klyser.astralhorizons.registry.AHTags;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.material.FogType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FogRenderer.class)
public abstract class TweakAnomalousFogColorMixin {

    @ModifyExpressionValue(method = "method_24873", at = @At(value = "INVOKE", target =
            "Lnet/minecraft/world/level/biome/BiomeManager;getNoiseBiomeAtQuart(III)Lnet/minecraft/core/Holder;"))
    private static Holder<Biome> tweakNoiseBiomeAtQuart(Holder<Biome> holder, @Share("holderRef") LocalRef<Holder<Biome>> holderRef) {
        holderRef.set(holder);
        return holder;
    }

    @ModifyExpressionValue(method = "method_24873", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/biome/Biome;getFogColor()I"))
    private static int getTweakedFogColor(int original, @Share("holderRef") LocalRef<Holder<Biome>> holderRef) {
        Holder<Biome> biome = holderRef.get();
        boolean wasDragonSlain = AHPacketData.wasDragonSlainOnce();
        if (biome == null) {
            return original;
        }
        if (!biome.is(AHTags.IS_ANOMALOUS)) {
            return original;
        }
        if (wasDragonSlain) {
            return original;
        }
        return 0xDAF5F9;
    }

    @ModifyVariable(method = "setupColor", at = @At(value = "STORE", ordinal = 0), index = 9)
    private static int changeWaterFogColor(int value, Camera activeRenderInfo, float partialTicks, ClientLevel level, int renderDistanceChunks, float bossColorModifier) {
        // Replace with your desired value or logic
        Holder<Biome> biome = level.getBiome(BlockPos.containing(activeRenderInfo.getPosition()));
        if (!biome.is(AHTags.IS_ANOMALOUS)) {
            return biome.value().getWaterFogColor();
        }
        boolean wasDragonSlain = AHPacketData.wasDragonSlainOnce();
        if (wasDragonSlain) {
            return biome.value().getWaterFogColor();
        }
        return 0x6CBEFD;
    }

}
