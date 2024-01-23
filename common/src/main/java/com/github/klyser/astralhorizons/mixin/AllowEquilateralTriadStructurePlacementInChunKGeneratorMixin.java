package com.github.klyser.astralhorizons.mixin;

import net.minecraft.world.level.chunk.ChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ChunkGenerator.class)
public class AllowEquilateralTriadStructurePlacementInChunKGeneratorMixin {

/*    @WrapOperation(
            method = "findNearestMapStructure",
            constant = @Constant(classValue = RandomSpreadStructurePlacement.class, ordinal = 0)
    )
    private boolean allowNewStructurePlacementType(Object obj, Operation<Boolean> original) {
        return original.call(obj) || obj instanceof EquilateralTriadStructurePlacement;
    }*/

}
