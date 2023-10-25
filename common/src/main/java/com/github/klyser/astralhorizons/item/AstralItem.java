package com.github.klyser.astralhorizons.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public abstract class AstralItem extends Item implements Fadeable {

    protected boolean faded = false;

    public AstralItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, @NotNull Level level, @NotNull Entity entity,
                              int slotId, boolean isSelected) {
        // Every minute, check the player's dimension and fade the item if they're not in the astral realm.
        if (level.getGameTime() % 1200 == 0) {
            //TODO: Change this to happen when the player is NOT in the astral realm.
            this.setFaded(level.dimension().equals(Level.OVERWORLD));
        }
    }

    @Override
    public boolean isFaded() {
        return false;
    }

    @Override
    public void setFaded(boolean faded) {
        this.faded = faded;
    }
}
