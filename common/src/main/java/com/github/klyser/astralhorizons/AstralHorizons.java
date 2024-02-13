package com.github.klyser.astralhorizons;

import com.github.klyser.astralhorizons.registry.*;
import com.github.klyser.astralhorizons.world.region.AstralAnomalyRegion;
import com.github.klyser.astralhorizons.world.surfacerule.AHSurfaceRules;
import net.minecraft.resources.ResourceLocation;
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
		AHStructurePlacementType.init();
		AHFeatures.init();
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
