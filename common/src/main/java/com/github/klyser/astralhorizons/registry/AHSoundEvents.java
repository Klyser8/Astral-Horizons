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
    public static final Supplier<SoundEvent> ANOMADIRT_BREAK = registerSoundEvent("anomadirt_break", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("anomadirt_break")));
    public static final Supplier<SoundEvent> ANOMADIRT_PLACE = registerSoundEvent("anomadirt_place", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("anomadirt_place")));
    public static final Supplier<SoundEvent> ANOMADIRT_INTERACT = registerSoundEvent("anomadirt_interact", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("anomadirt_interact")));
    public static final Supplier<SoundEvent> ANOMAGRASS_BREAK = registerSoundEvent("anomagrass_break", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("anomagrass_break")));
    public static final Supplier<SoundEvent> ANOMAGRASS_PLACE = registerSoundEvent("anomagrass_place", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("anomagrass_place")));
    public static final Supplier<SoundEvent> ANOMAGRASS_INTERACT = registerSoundEvent("anomagrass_interact", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("anomagrass_interact")));
    public static final Supplier<SoundEvent> ANOMASTONE_BREAK = registerSoundEvent("anomastone_break", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("anomastone_break")));
    public static final Supplier<SoundEvent> ANOMASTONE_PLACE = registerSoundEvent("anomastone_place", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("anomastone_place")));
    public static final Supplier<SoundEvent> ANOMASTONE_INTERACT = registerSoundEvent("anomastone_interact", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("anomastone_interact")));
    public static final Supplier<SoundEvent> LUTIEL_PLACE = registerSoundEvent("lutiel_place", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("lutiel_place")));
    public static final Supplier<SoundEvent> LUTIEL_BREAK = registerSoundEvent("lutiel_break", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("lutiel_break")));
    public static final Supplier<SoundEvent> LUTIEL_INTERACT = registerSoundEvent("lutiel_interact", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("lutiel_interact")));
    public static final Supplier<SoundEvent> COBBLED_ANOMASTONE_BREAK = registerSoundEvent("cobbled_anomastone_break", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("cobbled_anomastone_break")));
    public static final Supplier<SoundEvent> COBBLED_ANOMASTONE_PLACE = registerSoundEvent("cobbled_anomastone_place", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("cobbled_anomastone_place")));
    public static final Supplier<SoundEvent> COBBLED_ANOMASTONE_INTERACT = registerSoundEvent("cobbled_anomastone_interact", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("cobbled_anomastone_interact")));
    public static final Supplier<SoundEvent> ANOMASTONE_BRICKS_BREAK = registerSoundEvent("anomastone_bricks_break", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("anomastone_bricks_break")));
    public static final Supplier<SoundEvent> ANOMASTONE_BRICKS_PLACE = registerSoundEvent("anomastone_bricks_place", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("anomastone_bricks_place")));
    public static final Supplier<SoundEvent> ANOMASTONE_BRICKS_INTERACT = registerSoundEvent("anomastone_bricks_interact", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("anomastone_bricks_interact")));
    public static final Supplier<SoundEvent> SCURANE_WOOD_BREAK = registerSoundEvent("scurane_wood_break", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("scurane_wood_break")));
    public static final Supplier<SoundEvent> SCURANE_WOOD_PLACE = registerSoundEvent("scurane_wood_place", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("scurane_wood_place")));
    public static final Supplier<SoundEvent> SCURANE_WOOD_INTERACT = registerSoundEvent("scurane_wood_interact", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("scurane_wood_interact")));
    public static final Supplier<SoundEvent> ANOMASAND_BREAK = registerSoundEvent("anomasand_break", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("anomasand_break")));
    public static final Supplier<SoundEvent> ANOMASAND_PLACE = registerSoundEvent("anomasand_place", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("anomasand_place")));
    public static final Supplier<SoundEvent> ANOMASAND_INTERACT = registerSoundEvent("anomasand_interact", () ->
            SoundEvent.createVariableRangeEvent(AstralHorizons.id("anomasand_interact")));
}
