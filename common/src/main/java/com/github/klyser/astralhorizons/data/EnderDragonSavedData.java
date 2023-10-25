package com.github.klyser.astralhorizons.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;
import org.jetbrains.annotations.NotNull;

import static com.github.klyser.astralhorizons.AstralHorizons.MOD_ID;

public class EnderDragonSavedData extends SavedData {

    private static final String DATA_NAME = MOD_ID + ".ender_dragon_kill";

    private boolean dragonDefeated = false;

    @Override
    public @NotNull CompoundTag save(CompoundTag compoundTag) {
        compoundTag.putBoolean(DATA_NAME, dragonDefeated);
        return compoundTag;
    }

}