package com.github.klyser.astralhorizons.registry;

import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.level.saveddata.maps.MapDecoration;

import java.util.List;
import java.util.function.Consumer;

public class AHVillagerTrades {

    public static final List<VillagerTrades.ItemListing> ASTRAL_GATEWAY_TREASURE_MAP_FOR_EMERALDS =
        List.of(new VillagerTrades.TreasureMapForEmeralds(
                48,
                AHTags.ON_ASTRAL_GATEWAY_MAPS,
                "filled_map.astral_gateway",
                MapDecoration.Type.BANNER_CYAN,
                1,
                16
        ));

}
