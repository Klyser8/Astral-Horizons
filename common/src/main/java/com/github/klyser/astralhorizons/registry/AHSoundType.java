package com.github.klyser.astralhorizons.registry;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;

public class AHSoundType extends SoundType {

    public static final SoundType ANOMADIRT = new AHSoundType(1.0f, 1.0f,
            AHSoundEvents.ANOMADIRT_BREAK.get(),
            AHSoundEvents.ANOMADIRT_INTERACT.get(),
            AHSoundEvents.ANOMADIRT_PLACE.get(),
            AHSoundEvents.ANOMADIRT_INTERACT.get(),
            AHSoundEvents.ANOMAGRASS_INTERACT.get());
    public static final SoundType ANOMAGRASS = new AHSoundType(1.0f, 1.0f,
            AHSoundEvents.ANOMAGRASS_BREAK.get(),
            AHSoundEvents.ANOMAGRASS_INTERACT.get(),
            AHSoundEvents.ANOMAGRASS_PLACE.get(),
            AHSoundEvents.ANOMAGRASS_INTERACT.get(),
            AHSoundEvents.ANOMAGRASS_INTERACT.get());
    public static final SoundType ANOMASTONE = new AHSoundType(1.0f, 1.0f,
            AHSoundEvents.ANOMASTONE_BREAK.get(),
            AHSoundEvents.ANOMASTONE_INTERACT.get(),
            AHSoundEvents.ANOMASTONE_PLACE.get(),
            AHSoundEvents.ANOMASTONE_INTERACT.get(),
            AHSoundEvents.ANOMASTONE_INTERACT.get());
    public static final SoundType LUTIEL = new AHSoundType(1.0f, 1.0f,
            AHSoundEvents.LUTIEL_BREAK.get(),
            AHSoundEvents.LUTIEL_INTERACT.get(),
            AHSoundEvents.LUTIEL_PLACE.get(),
            AHSoundEvents.LUTIEL_INTERACT.get(),
            AHSoundEvents.LUTIEL_INTERACT.get());
    public static final SoundType COBBLED_ANOMASTONE = new AHSoundType(1.0f, 1.0f,
            AHSoundEvents.COBBLED_ANOMASTONE_BREAK.get(),
            AHSoundEvents.COBBLED_ANOMASTONE_INTERACT.get(),
            AHSoundEvents.COBBLED_ANOMASTONE_PLACE.get(),
            AHSoundEvents.COBBLED_ANOMASTONE_INTERACT.get(),
            AHSoundEvents.COBBLED_ANOMASTONE_INTERACT.get());
    public static final SoundType ANOMASTONE_BRICKS = new AHSoundType(1.0f, 1.0f,
            AHSoundEvents.ANOMASTONE_BRICKS_BREAK.get(),
            AHSoundEvents.ANOMASTONE_BRICKS_INTERACT.get(),
            AHSoundEvents.ANOMASTONE_BRICKS_PLACE.get(),
            AHSoundEvents.ANOMASTONE_BRICKS_INTERACT.get(),
            AHSoundEvents.ANOMASTONE_BRICKS_INTERACT.get());
    public static final SoundType SCURANE_WOOD = new AHSoundType(1.0f, 1.0f,
            AHSoundEvents.SCURANE_WOOD_BREAK.get(),
            AHSoundEvents.SCURANE_WOOD_INTERACT.get(),
            AHSoundEvents.SCURANE_WOOD_PLACE.get(),
            AHSoundEvents.SCURANE_WOOD_INTERACT.get(),
            AHSoundEvents.SCURANE_WOOD_INTERACT.get());
    public static final SoundType ANOMASAND = new AHSoundType(1.0f, 1.0f,
            AHSoundEvents.ANOMASAND_BREAK.get(),
            AHSoundEvents.ANOMASAND_INTERACT.get(),
            AHSoundEvents.ANOMASAND_PLACE.get(),
            AHSoundEvents.ANOMASAND_INTERACT.get(),
            AHSoundEvents.ANOMASAND_INTERACT.get());


    public AHSoundType(float volume, float pitch, SoundEvent breakSound, SoundEvent stepSound, SoundEvent placeSound, SoundEvent hitSound, SoundEvent fallSound) {
        super(volume, pitch, breakSound, stepSound, placeSound, hitSound, fallSound);
    }
}
