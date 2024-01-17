package com.github.klyser.astralhorizons.world.surfacerule;

import com.github.klyser.astralhorizons.registry.AHBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class AstralAnomalySurfaceRuleData {

    private static final SurfaceRules.RuleSource ANOMALOUS_DIRT = makeStateRule(AHBlocks.ANOMADIRT.get());
    private static final SurfaceRules.RuleSource ANOMALOUS_GRASS_BLOCK = makeStateRule(AHBlocks.ANOMAGRASS_BLOCK.get());
    private static final SurfaceRules.RuleSource ANOMALOUS_STONE = makeStateRule(AHBlocks.ANOMASTONE.get());
    private static final SurfaceRules.RuleSource ANOMALOUS_SAND = makeStateRule(AHBlocks.ANOMASAND.get());

/*    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, ANOMALOUS_GRASS_BLOCK), ANOMALOUS_DIRT);
        SurfaceRules.RuleSource sandSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, ANOMALOUS_SAND), ANOMALOUS_SAND);
        return SurfaceRules.or(grassSurface, sandSurface, ANOMALOUS_STONE);
    }*/

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

}
