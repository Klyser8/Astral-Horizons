package com.github.klyser.astralhorizons.mixin;

import com.github.klyser.astralhorizons.network.AHPacketData;
import com.github.klyser.astralhorizons.registry.AHTags;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.ColorResolver;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(BiomeColors.class)
public abstract class TweakAnomalousWaterColorMixin {

    @Inject(method = "method_23790", at = @At("HEAD"), cancellable = true)
    private static void tweakColorResolver(Biome biome, double d, double e, CallbackInfoReturnable<Integer> cir) {
        Optional<Boolean> maybeBiomeInTag = Optional.ofNullable(Minecraft.getInstance().getConnection())
                .map(ClientPacketListener::registryAccess)
                .map(registryAccess -> registryAccess.registryOrThrow(Registries.BIOME))
                .map(registry -> registry.wrapAsHolder(biome))
                .map(biomeHolder -> biomeHolder.is(AHTags.IS_ANOMALOUS));
        boolean wasDragonSlain = AHPacketData.wasDragonSlainOnce();
        if (wasDragonSlain) {
            return;
        }
        // If biome is in tag, then...
        if (maybeBiomeInTag.orElse(false)) {
            cir.setReturnValue(0x3F9CFF);
        }
    }
}
