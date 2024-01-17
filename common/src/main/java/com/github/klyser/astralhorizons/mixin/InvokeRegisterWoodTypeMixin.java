package com.github.klyser.astralhorizons.mixin;

import net.minecraft.world.level.block.state.properties.WoodType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(WoodType.class)
public interface InvokeRegisterWoodTypeMixin {

//    @Invoker
//    WoodType invokeRegister(WoodType woodType);

    @Invoker
    static WoodType invokeRegister(WoodType woodType) {
        throw new AssertionError();
    }

}
