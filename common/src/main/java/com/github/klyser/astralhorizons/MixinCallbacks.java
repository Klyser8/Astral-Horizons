package com.github.klyser.astralhorizons;

import com.github.klyser.astralhorizons.AstralHorizons;
import com.github.klyser.astralhorizons.util.AdvancementUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;

public class MixinCallbacks {

    public static void AwardAdvancementPostDragonDeathCallback(Level level) {
        if (!level.isClientSide) {
            ResourceLocation advancementRL = new ResourceLocation(AstralHorizons.MOD_ID,"dragon_dead");
            ServerLevel serverLevel = (ServerLevel) level;
            for (int i = 0; i < serverLevel.players().size(); i++) {
                ServerPlayer player = serverLevel.players().get(i);
                AdvancementUtil.completeAdvancement(player, advancementRL, "tick"); //TODO implement on join advancement giving, and test AdvancementUtil
            }
        }
    }

}
