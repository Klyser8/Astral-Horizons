package com.github.klyser.astralhorizons.mixin;

import com.github.klyser.astralhorizons.network.AHPacketData;
import com.github.klyser.astralhorizons.registry.AHTags;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ClientLevel.class)
public abstract class TweakAnomalousSkyColorMixin {

    @ModifyExpressionValue(method = "method_32689", at = @At(value = "INVOKE", target =
            "Lnet/minecraft/world/level/biome/BiomeManager;getNoiseBiomeAtQuart(III)Lnet/minecraft/core/Holder;"))
    private static Holder<Biome> tweakNoiseBiomeAtQuart(Holder<Biome> holder, @Share("holderRef") LocalRef<Holder<Biome>> holderRef) {
        holderRef.set(holder);
        return holder;
    }

    @ModifyExpressionValue(method = "method_32689", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/biome/Biome;getSkyColor()I"))
    private static int getTweakedSkyColor(int original, @Share("holderRef") LocalRef<Holder<Biome>> holderRef) {
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
        return 0x9CEDFF;
    }

}
