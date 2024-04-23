package com.github.klyser.astralhorizons;

import com.github.klyser.astralhorizons.data.AstralHorizonsServerData;
import com.github.klyser.astralhorizons.network.AHPacketData;
import com.github.klyser.astralhorizons.network.EnderDragonStatusPacket;
import com.github.klyser.astralhorizons.platform.CommonPlatformHelper;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import com.github.klyser.astralhorizons.registry.AHTags;
import com.github.klyser.astralhorizons.util.AdvancementUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class MixinCallbacks {

    /**
     * Callback method for when the dragon is slain.
     *
     * @param level the level the dragon was slain in.
     */
    public static void handleDragonDeathCallback(Level level) {
        if (!level.isClientSide) {
            ServerLevel serverLevel = (ServerLevel) level;
            AstralHorizonsServerData data = AstralHorizonsServerData.getOrCreate(level.getServer());
            if (data == null) {
                AstralHorizons.LOGGER.warn("Server data is null, cannot handle dragon death callback.");
                return;
            }
            if (data.dragonSlainOnce()) {
                return;
            }
            data.setDragonSlainOnce(true);
            ResourceLocation advancementRL = AstralHorizons.id("dragon_dead");
            for (int i = 0; i < serverLevel.players().size(); i++) {
                ServerPlayer player = serverLevel.players().get(i);
                CommonPlatformHelper.sendPacketToClient(new EnderDragonStatusPacket(true), EnderDragonStatusPacket.ID, player);
                AdvancementUtil.completeAdvancement(player, advancementRL, "tick");
            }
        }
    }

    public static Block checkBoneMealBiome(Block original, Level level, BlockPos pos) {
        if (level.getBiome(pos).is(AHTags.IS_ANOMALOUS)) {
            return AHBlocks.ANOMALOUS_SEAGRASS.get();
        } else {
            return original;
        }
    }

}
