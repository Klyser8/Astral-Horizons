package com.github.klyser.astralhorizons.mixin;

import com.github.klyser.astralhorizons.world.structure.ModifiedConcentricRingsStructurePlacement;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkGeneratorStructureState;
import net.minecraft.world.level.levelgen.structure.placement.ConcentricRingsStructurePlacement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.function.Supplier;

/**
 * Mixin which injects new ring positions to ChunkGeneratorStructureState.
 * These are used by the ModifiedConcentricRingsStructurePlacement to generate astral gateways in a
 * concentric ring pattern, while ensuring that the structure does not use the same positions that Strongholds do.
 */
@Mixin(ChunkGeneratorStructureState.class)
public class ChunkGeneratorStructureStateMixin {
    @ModifyArg(method = "generateRingPositions", at = @At(value = "INVOKE", target =
            "Ljava/util/concurrent/CompletableFuture;" +
                    "supplyAsync(Ljava/util/function/Supplier;Ljava/util/concurrent/Executor;)" +
                    "Ljava/util/concurrent/CompletableFuture;"))
    private Supplier<ChunkPos> adjustRingPositions(Supplier<ChunkPos> originalSupplier, @Local(argsOnly = true) ConcentricRingsStructurePlacement structurePlacement) {
        if (structurePlacement instanceof ModifiedConcentricRingsStructurePlacement modifiedStructurePlacement) {
            if (modifiedStructurePlacement.rotationOffset() == 0
                    && modifiedStructurePlacement.minDistanceFromOrigin() == 0
                    && modifiedStructurePlacement.maxDistanceFromOrigin() == 0) {
                System.out.println("(" + originalSupplier.get().x * 16 + "," + originalSupplier.get().z * 16 + ")");
                return originalSupplier;
            }
            return () -> {
                ChunkPos pos = originalSupplier.get();
                ChunkPos rotatedChunkPos = modifiedStructurePlacement.rotateChunkPosAroundCenterChunk(pos);
                System.out.println("(" + rotatedChunkPos.x * 16 + "," + rotatedChunkPos.z * 16 + ")");
                return rotatedChunkPos;
            };
        }
        return originalSupplier;
    }
}
