package com.github.klyser.astralhorizons;

import com.github.klyser.astralhorizons.network.EnderDragonStatusPacket;
import com.github.klyser.astralhorizons.platform.CommonPlatformHelper;
import com.github.klyser.astralhorizons.util.AdvancementUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;

public class MixinCallbacks {

    public static void awardAdvancementPostDragonDeathCallback(Level level) {
        if (!level.isClientSide) {
            ResourceLocation advancementRL = new ResourceLocation(AstralHorizons.MOD_ID,"dragon_dead");
            ServerLevel serverLevel = (ServerLevel) level;
            for (int i = 0; i < serverLevel.players().size(); i++) {
                ServerPlayer player = serverLevel.players().get(i);
                AdvancementUtil.completeAdvancement(player, advancementRL, "tick");
            }
        }
    }

    public static void updateDragonStatusForClientsCallback(Level level) {
        if (!level.isClientSide) {
            ServerLevel serverLevel = (ServerLevel) level;
            for (int i = 0; i < serverLevel.players().size(); i++) {
                ServerPlayer player = serverLevel.players().get(i);
                CommonPlatformHelper.sendPacketToClient(new EnderDragonStatusPacket(true), EnderDragonStatusPacket.ID, player);
            }
        }
    }

}
