package com.github.klyser.astralhorizons.mixin;

import com.github.klyser.astralhorizons.MixinCallbacks;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Debug(export = true)
@Mixin(BoneMealItem.class)
public class InjectBoneMealUsageInAnomalousBiomes {

    @ModifyExpressionValue(method = "growWaterPlant", at = @At(value = "FIELD",
            target = "Lnet/minecraft/world/level/block/Blocks;SEAGRASS:Lnet/minecraft/world/level/block/Block;"))
    private static Block replaceSeagrassWithAnomalousSeagrass(Block original, ItemStack stack, Level level, BlockPos pos, @Nullable Direction clickedSide) {
        return MixinCallbacks.checkBoneMealBiome(original, level, pos);
    }

}
