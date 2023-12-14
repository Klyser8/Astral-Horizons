package com.github.klyser.astralhorizons.registry;

import com.github.klyser.astralhorizons.AstralHorizons;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class AHBlockSetTypes {

    public static final BlockSetType ANOMALOUS_STONE = blockSet("anomalous_stone");

    private static BlockSetType blockSet(String id) {
        return BlockSetType.register(new BlockSetType(AstralHorizons.MOD_ID + ":" + id));
    }

    private static BlockSetType blockSet(String id, SoundType soundType, SoundEvent doorClose, SoundEvent doorOpen,
                                         SoundEvent trapdoorClose, SoundEvent trapdoorOpen,
                                         SoundEvent pressurePlateClickOff, SoundEvent pressurePlateClickOn,
                                         SoundEvent buttonClickOff, SoundEvent buttonClickOn) {
        //FIXME what do the three booleans do?
        return BlockSetType.register(new BlockSetType(AstralHorizons.MOD_ID + ":" + id, true, true, true, BlockSetType.PressurePlateSensitivity.EVERYTHING, soundType, doorClose, doorOpen, trapdoorClose, trapdoorOpen, pressurePlateClickOff, pressurePlateClickOn, buttonClickOff, buttonClickOn));
    }

}
