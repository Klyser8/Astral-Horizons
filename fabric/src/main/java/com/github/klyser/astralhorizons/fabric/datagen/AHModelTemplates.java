package com.github.klyser.astralhorizons.fabric.datagen;

import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class AHModelTemplates {

    public static final ModelTemplate CUBE_SINGLE_TINT = create("cube_single_tint", TextureSlot.ALL);

    private static ModelTemplate create(TextureSlot... requiredSlots) {
        return new ModelTemplate(Optional.empty(), Optional.empty(), requiredSlots);
    }

    private static ModelTemplate create(String blockModelLocation, TextureSlot ... requiredSlots) {
        return new ModelTemplate(Optional.of(new ResourceLocation("minecraft", "block/" + blockModelLocation)), Optional.empty(), requiredSlots);
    }

    private static ModelTemplate createItem(String itemModelLocation, TextureSlot ... requiredSlots) {
        return new ModelTemplate(Optional.of(new ResourceLocation("minecraft", "item/" + itemModelLocation)), Optional.empty(), requiredSlots);
    }

    private static ModelTemplate create(String blockModelLocation, String suffix, TextureSlot ... requiredSlots) {
        return new ModelTemplate(Optional.of(new ResourceLocation("minecraft", "block/" + blockModelLocation)), Optional.of(suffix), requiredSlots);
    }

}
