package com.github.klyser.astralhorizons.registry;

import com.github.klyser.astralhorizons.mixin.InvokeRegisterWoodTypeMixin;
import net.minecraft.world.level.block.state.properties.WoodType;

public class AHWoodType {

    public static void init() {}

    public static final WoodType SCURANE = InvokeRegisterWoodTypeMixin.invokeRegister(new WoodType("scurane", AHBlockSetType.SCURANE));


}
