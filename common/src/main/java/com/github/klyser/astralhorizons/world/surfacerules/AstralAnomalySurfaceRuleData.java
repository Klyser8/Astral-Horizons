package com.github.klyser.astralhorizons.world.surfacerules;

import com.github.klyser.astralhorizons.registry.AHBiomes;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class AstralAnomalySurfaceRuleData {

    private static final SurfaceRules.RuleSource ANOMALOUS_DIRT = makeStateRule(AHBlocks.ANOMALOUS_DIRT.get());
    private static final SurfaceRules.RuleSource ANOMALOUS_GRASS_BLOCK = makeStateRule(AHBlocks.ANOMALOUS_GRASS_BLOCK.get());
    private static final SurfaceRules.RuleSource ANOMALOUS_STONE = makeStateRule(AHBlocks.ANOMALOUS_STONE.get());

    public static final SurfaceRules.RuleSource ASTRAL_ANOMALY = SurfaceRules.sequence(
            SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AHBlocks.ANOMALOUS_GRASS_BLOCK.get().defaultBlockState())),
            SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(AHBlocks.ANOMALOUS_DIRT.get().defaultBlockState())),
            SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(10, false, CaveSurface.FLOOR), SurfaceRules.state(AHBlocks.ANOMALOUS_STONE.get().defaultBlockState())),
            SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(10, false, CaveSurface.CEILING), SurfaceRules.state(AHBlocks.ANOMALOUS_STONE.get().defaultBlockState()))
    );

    public static SurfaceRules.RuleSource makeRules() {
        return ASTRAL_ANOMALY;
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

}
