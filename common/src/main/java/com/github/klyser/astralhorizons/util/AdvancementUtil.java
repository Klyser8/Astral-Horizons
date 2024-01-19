package com.github.klyser.astralhorizons.util;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

/**
 * author: Tslat
 *
 * Utility class for advancement-related methods.
 */
public final class AdvancementUtil {

	/**
	 * Returns the AdvancementHolder for the given ResourceLocation.
	 * Requires a ServerLevel to be passed in.
	 *
	 * @param level the ServerLevel to get the AdvancementHolder from
	 * @param resourceLocation the ResourceLocation of the advancement
	 * @return the AdvancementHolder for the given ResourceLocation
	 */
	public static AdvancementHolder getAdvancementHolder(ServerLevel level, ResourceLocation resourceLocation) {
		return level.getServer().getAdvancements().get(resourceLocation);
	}

	/**
	 * Completes the given advancement for the given player.
	 * Requires the criterion to be passed in.
	 *
	 * @param player the player to complete the advancement for
	 * @param resourceLocation the ResourceLocation of the advancement
	 * @param criterion the criterion to complete
	 * @return true if the advancement was completed, false otherwise
	 */
	public static boolean completeAdvancement(ServerPlayer player, ResourceLocation resourceLocation, String criterion) {
		AdvancementHolder adv = getAdvancementHolder(player.serverLevel(), resourceLocation);

		if (adv != null)
			return player.getAdvancements().award(adv, criterion);

		return false;
	}

	/**
	 * Returns true if the given advancement is completed for the given player.
	 *
	 * @param player the player to check
	 * @param resourceLocation the ResourceLocation of the advancement
	 * @return true if the given advancement is completed for the given player
	 */
	public static boolean isAdvancementCompleted(ServerPlayer player, ResourceLocation resourceLocation) {
		AdvancementHolder adv = getAdvancementHolder(player.serverLevel(), resourceLocation);

		if (adv != null)
			return player.getAdvancements().getOrStartProgress(adv).isDone();

		return false;
	}
}