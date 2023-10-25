package com.github.klyser.astralhorizons.mixin;

import com.github.klyser.astralhorizons.MixinCallbacks;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnderDragon.class)
public abstract class AwardAdvancementPostDragonDeathMixin extends Mob {

    public AwardAdvancementPostDragonDeathMixin(EntityType<? extends EnderDragon> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "tickDeath", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/entity/boss/enderdragon/EnderDragon;" +
                    "gameEvent(Lnet/minecraft/world/level/gameevent/GameEvent;)V"))
    private void awardAdvancementPostDragonDeath(CallbackInfo ci) {
        MixinCallbacks.AwardAdvancementPostDragonDeathCallback(level());
        //serverLevel.getServer().getWorldData().endDragonFightData().dragonKilled();???
    }
}