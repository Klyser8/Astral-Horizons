package com.github.klyser.astralhorizons;

import com.github.klyser.astralhorizons.registry.*;
import com.github.klyser.astralhorizons.util.AdvancementUtil;
import com.github.klyser.astralhorizons.world.region.AstralAnomalyRegion;
import com.github.klyser.astralhorizons.world.surfacerule.AHSurfaceRules;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.dimension.end.EndDragonFight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

public class AstralHorizons
{
	public static final String MOD_ID = "astralhorizons";
	@SuppressWarnings("unused")
	public static final Logger LOGGER = LogManager.getLogger();

	public static void init() {
		AHBlocks.init();
		AHItems.init();
		AHCreativeModeTabs.init();
		AHSoundEvents.init();
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

	public static void initTerrablender() {
		Regions.register(new AstralAnomalyRegion(id("anomalous_region"), 25));
		SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, AHSurfaceRules.makeRules());
	}

	/**
	 * Creates a new ResourceLocation with the given name and the Astral Horizons mod id.
	 * @param name the name of the resource
	 * @return the new ResourceLocation
	 */
	public static ResourceLocation id(String name) {
		return new ResourceLocation(MOD_ID, name);
	}
}
