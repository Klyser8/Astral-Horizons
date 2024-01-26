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
        registerMusic();
        registerSFX();
    }

    private void registerMusic() {
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

    private void registerSFX() {
        add(AHSoundEvents.ANOMADIRT_BREAK.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.anomadirt.break")
                .with(sound(AstralHorizons.id("block/anomadirt/break/break1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomadirt/break/break2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomadirt/break/break3"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomadirt/break/break4"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.ANOMADIRT_PLACE.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.anomadirt.place")
                .with(sound(AstralHorizons.id("block/anomadirt/place/place1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomadirt/place/place2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomadirt/place/place3"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomadirt/place/place4"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.ANOMADIRT_INTERACT.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.anomadirt.interact")
                .with(sound(AstralHorizons.id("block/anomadirt/interact/interact1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomadirt/interact/interact2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomadirt/interact/interact3"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomadirt/interact/interact4"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomadirt/interact/interact5"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.ANOMAGRASS_BREAK.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.anomagrass.break")
                .with(sound(AstralHorizons.id("block/anomagrass/break/break1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomagrass/break/break2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomagrass/break/break3"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.ANOMAGRASS_PLACE.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.anomagrass.place")
                .with(sound(AstralHorizons.id("block/anomagrass/place/place1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomagrass/place/place2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomagrass/place/place3"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.ANOMAGRASS_INTERACT.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.anomagrass.interact")
                .with(sound(AstralHorizons.id("block/anomagrass/interact/interact1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomagrass/interact/interact2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomagrass/interact/interact3"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomagrass/interact/interact4"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.ANOMASTONE_BREAK.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.anomastone.break")
                .with(sound(AstralHorizons.id("block/anomastone/break/break1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomastone/break/break2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomastone/break/break3"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomastone/break/break4"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.ANOMASTONE_PLACE.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.anomastone.place")
                .with(sound(AstralHorizons.id("block/anomastone/place/place1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomastone/place/place2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomastone/place/place3"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomastone/place/place4"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.ANOMASTONE_INTERACT.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.anomastone.interact")
                .with(sound(AstralHorizons.id("block/anomastone/interact/interact1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomastone/interact/interact2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomastone/interact/interact3"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomastone/interact/interact4"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomastone/interact/interact5"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomastone/interact/interact6"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.LUTIEL_BREAK.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.lutiel.break")
                .with(sound(AstralHorizons.id("block/lutiel/break/break1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/lutiel/break/break2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/lutiel/break/break3"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.LUTIEL_PLACE.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.lutiel.place")
                .with(sound(AstralHorizons.id("block/lutiel/place/place1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/lutiel/place/place2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/lutiel/place/place3"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.LUTIEL_INTERACT.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.lutiel.interact")
                .with(sound(AstralHorizons.id("block/lutiel/interact/interact1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/lutiel/interact/interact2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/lutiel/interact/interact3"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/lutiel/interact/interact4"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.COBBLED_ANOMASTONE_BREAK.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.cobbled_anomastone.break")
                .with(sound(AstralHorizons.id("block/cobbled_anomastone/break/break1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/cobbled_anomastone/break/break2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/cobbled_anomastone/break/break3"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.COBBLED_ANOMASTONE_PLACE.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.cobbled_anomastone.place")
                .with(sound(AstralHorizons.id("block/cobbled_anomastone/place/place1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/cobbled_anomastone/place/place2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/cobbled_anomastone/place/place3"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.COBBLED_ANOMASTONE_INTERACT.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.cobbled_anomastone.interact")
                .with(sound(AstralHorizons.id("block/cobbled_anomastone/interact/interact1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/cobbled_anomastone/interact/interact2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/cobbled_anomastone/interact/interact3"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/cobbled_anomastone/interact/interact4"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.ANOMASTONE_BRICKS_BREAK.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.anomastone_bricks.break")
                .with(sound(AstralHorizons.id("block/anomastone_bricks/break/break1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomastone_bricks/break/break2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomastone_bricks/break/break3"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.ANOMASTONE_BRICKS_PLACE.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.anomastone_bricks.place")
                .with(sound(AstralHorizons.id("block/anomastone_bricks/place/place1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomastone_bricks/place/place2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomastone_bricks/place/place3"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.ANOMASTONE_BRICKS_INTERACT.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.anomastone_bricks.interact")
                .with(sound(AstralHorizons.id("block/anomastone_bricks/interact/interact1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomastone_bricks/interact/interact2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomastone_bricks/interact/interact3"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomastone_bricks/interact/interact4"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.SCURANE_WOOD_BREAK.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.scurane_wood.break")
                .with(sound(AstralHorizons.id("block/scurane_wood/break/break1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/scurane_wood/break/break2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/scurane_wood/break/break3"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/scurane_wood/break/break4"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.SCURANE_WOOD_PLACE.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.scurane_wood.place")
                .with(sound(AstralHorizons.id("block/scurane_wood/place/place1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/scurane_wood/place/place2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/scurane_wood/place/place3"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/scurane_wood/place/place4"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.SCURANE_WOOD_INTERACT.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.scurane_wood.interact")
                .with(sound(AstralHorizons.id("block/scurane_wood/interact/interact1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/scurane_wood/interact/interact2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/scurane_wood/interact/interact3"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/scurane_wood/interact/interact4"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/scurane_wood/interact/interact5"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.ANOMASAND_BREAK.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.anomasand.break")
                .with(sound(AstralHorizons.id("block/anomasand/break/break1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomasand/break/break2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomasand/break/break3"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomasand/break/break4"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.ANOMASAND_PLACE.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.anomasand.place")
                .with(sound(AstralHorizons.id("block/anomasand/place/place1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomasand/place/place2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomasand/place/place3"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomasand/place/place4"), SoundDefinition.SoundType.SOUND)));
        add(AHSoundEvents.ANOMASAND_INTERACT.get().getLocation(), definition()
                .subtitle("subtitles.astralhorizons.block.anomasand.interact")
                .with(sound(AstralHorizons.id("block/anomasand/interact/interact1"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomasand/interact/interact2"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomasand/interact/interact3"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomasand/interact/interact4"), SoundDefinition.SoundType.SOUND),
                        sound(AstralHorizons.id("block/anomasand/interact/interact5"), SoundDefinition.SoundType.SOUND)));
    }
}
