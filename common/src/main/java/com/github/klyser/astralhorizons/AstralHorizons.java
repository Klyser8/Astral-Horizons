package com.github.klyser.astralhorizons;

import com.github.klyser.astralhorizons.registry.AHBlocks;
import com.github.klyser.astralhorizons.registry.AHCreativeModeTabs;
import com.github.klyser.astralhorizons.registry.AHItems;
import com.github.klyser.astralhorizons.util.AdvancementUtil;
import com.github.klyser.astralhorizons.world.region.AstralAnomalyRegion;
import com.github.klyser.astralhorizons.world.surfacerules.AstralAnomalySurfaceRuleData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.dimension.end.EndDragonFight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

public class AstralHorizons
{
	public static final String MOD_ID = "astralhorizons";
	public static final Logger LOGGER = LogManager.getLogger();

	public static void init() {
		AHItems.init();
		AHCreativeModeTabs.init();
		AHBlocks.init();
	}

	/**
	 * Awards the dragon_dead advancement to the given player if the dragon is dead.
	 * Used to grant the advancement to players who join after the dragon is killed.
	 *
	 * @param player the player to award the advancement to
	 */
	public static void awardDragonDeadAdvancement(Player player) {
		if (player.level().isClientSide) {
			return;
		}
		ServerLevel serverLevel = (ServerLevel) player.level();
		EndDragonFight.Data dragonFightData = serverLevel.getServer().getWorldData().endDragonFightData();
		if (dragonFightData.dragonKilled()) {
			AdvancementUtil.completeAdvancement((ServerPlayer) player, new ResourceLocation(AstralHorizons.MOD_ID, "dragon_dead"), "tick");
		}
	}

	public static Runnable initTerrablender() {
		return () -> {
			Regions.register(new AstralAnomalyRegion(new ResourceLocation(AstralHorizons.MOD_ID, "astral_anomaly"), RegionType.OVERWORLD, 2));

			SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, AstralAnomalySurfaceRuleData.makeRules());
		};
	}
}
