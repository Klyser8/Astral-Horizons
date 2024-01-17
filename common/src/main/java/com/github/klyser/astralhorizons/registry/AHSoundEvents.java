package com.github.klyser.astralhorizons.registry;

import com.github.klyser.astralhorizons.AstralHorizons;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

import static com.github.klyser.astralhorizons.platform.CommonPlatformHelper.registerSoundEvent;

public class AHSoundEvents {

    public static void init() {}

    public static final Supplier<SoundEvent> ASTRAL_ANOMALY_SURFACE = registerSoundEvent("astral_anomaly_surface", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("astral_anomaly_surface")));
    public static final Supplier<SoundEvent> ASTRAL_ANOMALY_CAVES = registerSoundEvent("discovery", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("astral_anomaly_caves")));

}
