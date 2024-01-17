package com.github.klyser.astralhorizons.fabric.datagen;

import com.github.klyser.astralhorizons.AstralHorizons;
import com.github.klyser.astralhorizons.registry.AHSoundEvents;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;

import static com.github.klyser.astralhorizons.fabric.datagen.SoundDefinition.Sound.sound;
import static com.github.klyser.astralhorizons.fabric.datagen.SoundDefinition.definition;

public class AHSoundEventGenerator extends SoundsJsonProvider {
    public AHSoundEventGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void registerSounds() {
        add(AHSoundEvents.ASTRAL_ANOMALY_SURFACE.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.song.astral_anomaly_surface")
                .with(sound(AstralHorizons.id("music/open_anomaly"), SoundDefinition.SoundType.SOUND).stream(),
                        sound(AstralHorizons.id("music/discovery"), SoundDefinition.SoundType.SOUND).stream(),
                        sound(AstralHorizons.id("music/tainted_winds"), SoundDefinition.SoundType.SOUND).stream()));
        add(AHSoundEvents.ASTRAL_ANOMALY_CAVES.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.song.astral_anomaly_caves")
                .with(sound(AstralHorizons.id("music/crystals"), SoundDefinition.SoundType.SOUND).stream(),
                        sound(AstralHorizons.id("music/discovery"), SoundDefinition.SoundType.SOUND).stream()));
    }
}
