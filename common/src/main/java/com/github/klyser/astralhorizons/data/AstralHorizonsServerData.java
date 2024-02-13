package com.github.klyser.astralhorizons.data;

import com.github.klyser.astralhorizons.AstralHorizons;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.SavedData;
import org.jetbrains.annotations.NotNull;

public class AstralHorizonsServerData extends SavedData {
    public static final String DRAGON_SLAIN_KEY = "dragon_slain";
    private boolean dragonSlainOnce;

    public static AstralHorizonsServerData getOrCreate(MinecraftServer server) {
        ServerLevel level = server.getLevel(Level.OVERWORLD);
        if (level == null) {
            AstralHorizons.LOGGER.error("Could not get overworld level for server.");
            return null;
        }
        //noinspection DataFlowIssue
        return level.getDataStorage().computeIfAbsent(
                new Factory<>(AstralHorizonsServerData::create, AstralHorizonsServerData::load, null),
                AstralHorizons.MOD_ID);
    }

    private static AstralHorizonsServerData load(CompoundTag compoundTag) {
        boolean dragonSlainOnce = compoundTag.getBoolean(DRAGON_SLAIN_KEY);
        return new AstralHorizonsServerData(dragonSlainOnce);
    }

    private static AstralHorizonsServerData create() {
        return new AstralHorizonsServerData(false);
    }

    private AstralHorizonsServerData(boolean dragonSlainOnce) {
        this.dragonSlainOnce = dragonSlainOnce;
    }

    public void setDragonSlainOnce(boolean dragonSlainOnce) {
        this.dragonSlainOnce = dragonSlainOnce;
        setDirty();
    }

    public boolean dragonSlainOnce() {
        return dragonSlainOnce;
    }

    @Override
    public @NotNull CompoundTag save(CompoundTag compoundTag) {
        compoundTag.putBoolean(DRAGON_SLAIN_KEY, dragonSlainOnce);
        return compoundTag;
    }
}
