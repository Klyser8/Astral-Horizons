package com.github.klyser.astralhorizons.world.surfacerule;

import com.github.klyser.astralhorizons.registry.AHBiomes;
import com.github.klyser.astralhorizons.registry.AHBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class AHSurfaceRules {

    private static final SurfaceRules.RuleSource BEDROCK = SurfaceRules.state(Blocks.BEDROCK.defaultBlockState());
    private static final SurfaceRules.ConditionSource IN_WATER = SurfaceRules.not(SurfaceRules.waterBlockCheck(-1, 0));
    private static final SurfaceRules.ConditionSource ABOVE_SEA_LEVEL = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), -2); // -2 adds randomization to the level which the rule is applied at, vertically.
    private static final SurfaceRules.ConditionSource ABOVE_Y_0 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(0), 0);
    private static final SurfaceRules.ConditionSource ABOVE_Y_32 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(32), 2);
    private static final SurfaceRules.ConditionSource ABOVE_BOTTOM_OF_OCEAN = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(50), -2);

    public static SurfaceRules.RuleSource makeRules() {
        return SurfaceRules.sequence(FLUSHED_TWISTED_SURFACE, ANOMALOUS_BEACH, ANOMALOUS_RIVER);
    }
    private static final SurfaceRules.RuleSource FLUSHED_TWISTED_SURFACE = SurfaceRules.sequence(
            SurfaceRules.ifTrue(SurfaceRules.isBiome(AHBiomes.FLUSHED_ASTRAL_ANOMALY, AHBiomes.TWISTED_ASTRAL_ANOMALY),
                    SurfaceRules.sequence(
                            SurfaceRules.ifTrue(
                                    ABOVE_SEA_LEVEL, SurfaceRules.ifTrue(
                                            SurfaceRules.not(IN_WATER), SurfaceRules.ifTrue(
                                                    SurfaceRules.abovePreliminarySurface(), SurfaceRules.sequence(
                                                            SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AHBlocks.ANOMAGRASS_BLOCK.get().defaultBlockState())),
                                                            SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(AHBlocks.ANOMADIRT.get().defaultBlockState()))
                                                    )
                                            )
                                    )
                            ),
                            SurfaceRules.ifTrue(
                                    ABOVE_Y_0, SurfaceRules.ifTrue(
                                            IN_WATER, SurfaceRules.sequence(
                                                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AHBlocks.ANOMADIRT.get().defaultBlockState())), //TODO add sand disk features.
                                                    SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(AHBlocks.ANOMADIRT.get().defaultBlockState()))
                                            )
                                    )
                            ),
                            SurfaceRules.ifTrue(
                                    SurfaceRules.yBlockCheck(VerticalAnchor.absolute(-56), -1), SurfaceRules.state(AHBlocks.ANOMASTONE.get().defaultBlockState())
                            )
                    )
            )
    );

    private static final SurfaceRules.RuleSource ANOMALOUS_BEACH = SurfaceRules.sequence(
            SurfaceRules.ifTrue(SurfaceRules.isBiome(AHBiomes.ANOMALOUS_BEACH), SurfaceRules.sequence(
                    SurfaceRules.ifTrue(
                            ABOVE_BOTTOM_OF_OCEAN, SurfaceRules.sequence(
                                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AHBlocks.ANOMASAND.get().defaultBlockState())),
                                    SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(AHBlocks.ANOMASAND.get().defaultBlockState())),
                                    SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SurfaceRules.state(AHBlocks.ANOMASANDSTONE.get().defaultBlockState())),
                                    SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SurfaceRules.state(AHBlocks.ANOMASTONE.get().defaultBlockState()))
                            )
                    ),
                    SurfaceRules.ifTrue(
                            SurfaceRules.yBlockCheck(VerticalAnchor.absolute(-56), -1), SurfaceRules.state(AHBlocks.ANOMASTONE.get().defaultBlockState())
                    )
            ))
    );

    private static final SurfaceRules.RuleSource ANOMALOUS_RIVER = SurfaceRules.sequence(
            SurfaceRules.ifTrue(SurfaceRules.isBiome(AHBiomes.ANOMALOUS_RIVER), SurfaceRules.sequence(
                    SurfaceRules.ifTrue(
                            ABOVE_BOTTOM_OF_OCEAN, SurfaceRules.sequence(
                                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AHBlocks.ANOMADIRT.get().defaultBlockState())),
                                    SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(AHBlocks.ANOMADIRT.get().defaultBlockState())),
                                    SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SurfaceRules.state(AHBlocks.ANOMASTONE.get().defaultBlockState())),
                                    SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SurfaceRules.state(AHBlocks.ANOMASTONE.get().defaultBlockState()))
                            )
                    ),
                    SurfaceRules.ifTrue(
                            SurfaceRules.yBlockCheck(VerticalAnchor.absolute(-56), -1), SurfaceRules.state(AHBlocks.ANOMASTONE.get().defaultBlockState())
                    )
            ))
    );
    private static final SurfaceRules.RuleSource ERODED_SURFACE = SurfaceRules.sequence(
            SurfaceRules.ifTrue(SurfaceRules.isBiome(AHBiomes.ERODED_ASTRAL_ANOMALY), SurfaceRules.sequence(
                    SurfaceRules.ifTrue(
                            SurfaceRules.abovePreliminarySurface(), SurfaceRules.sequence(
                                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AHBlocks.ANOMASAND.get().defaultBlockState())),
                                    SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(AHBlocks.ANOMASAND.get().defaultBlockState())),
                                    SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SurfaceRules.state(AHBlocks.ANOMASANDSTONE.get().defaultBlockState())),
                                    SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SurfaceRules.state(AHBlocks.ANOMASTONE.get().defaultBlockState()))
                            )
                    )
            ))
    );

    public static final SurfaceRules.RuleSource FRIGID_SURFACE = SurfaceRules.sequence(
            SurfaceRules.ifTrue(SurfaceRules.isBiome(AHBiomes.FRIGID_ASTRAL_ANOMALY), SurfaceRules.sequence(
                    /*SurfaceRules.ifTrue(
                            SurfaceRules.abovePreliminarySurface(), SurfaceRules.sequence(
                                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AHBlocks.ANOMALOUS_SNOW_BLOCK.get().defaultBlockState())),
                                    SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(AHBlocks.ANOMALOUS_ICE.get().defaultBlockState())),
                                    SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SurfaceRules.state(AHBlocks.ANOMALOUS_STONE.get().defaultBlockState())),
                                    SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SurfaceRules.state(AHBlocks.ANOMALOUS_STONE.get().defaultBlockState()))
                            )
                    ),*/
                    SurfaceRules.ifTrue(
                            SurfaceRules.not(SurfaceRules.abovePreliminarySurface()), SurfaceRules.sequence(
                                    SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 2, CaveSurface.FLOOR), SurfaceRules.state(AHBlocks.ANOMASTONE.get().defaultBlockState()))
//                                    SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(5, true, 2, CaveSurface.CEILING), SurfaceRules.state(AHBlocks.ANOMALOUS_ICE.get().defaultBlockState()))
//                                    SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 12, CaveSurface.CEILING), SurfaceRules.state(AHBlocks.ANOMALOUS_STONE.get().defaultBlockState())),
//                                    SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 20, CaveSurface.CEILING), SurfaceRules.state(AHBlocks.ANOMALOUS_ICE.get().defaultBlockState())),
//
//                                    SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(AHBlocks.ANOMALOUS_STONE.get().defaultBlockState())),
//                                    SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 2, CaveSurface.FLOOR), SurfaceRules.state(AHBlocks.ANOMALOUS_ICE.get().defaultBlockState())),
//                                    SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 10, CaveSurface.FLOOR), SurfaceRules.state(AHBlocks.ANOMALOUS_STONE.get().defaultBlockState())),
//                                    SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 12, CaveSurface.FLOOR), SurfaceRules.state(AHBlocks.ANOMALOUS_ICE.get().defaultBlockState()))

                            )
                    )
            ))
    );

    //DIRT BLOCKS WITH GRASS ON TOP LAYER, EXTENDED THROUGHOUT WHOLE BIOME, ABOVE SEA LEVEL AND NOT UNDERWATER.
    /*public static final SurfaceRules.RuleSource GRASS_BLOCK_SURFACE = SurfaceRules.sequence(
            SurfaceRules.ifTrue(SurfaceRules.isBiome(AHBiomes.FLUSHED_ASTRAL_ANOMALY, AHBiomes.TWISTED_ASTRAL_ANOMALY),
                    SurfaceRules.ifTrue(
                          ABOVE_SEA_LEVEL, SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.sequence(
                                    SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AHBlocks.ANOMALOUS_GRASS_BLOCK.get().defaultBlockState())),
                                    SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(AHBlocks.ANOMALOUS_DIRT.get().defaultBlockState()))
                                    )
                            )
                    )
            )
    );*/
    //GRASS BLOCK EXTENDING THROUGHOUT ENTIRE BIOME, ABOVE SEA LEVEL AND NOT UNDER WATER
    /*public static final SurfaceRules.RuleSource GRASS_BLOCK_SURFACE = SurfaceRules.sequence(
            SurfaceRules.ifTrue(SurfaceRules.isBiome(AHBiomes.FLUSHED_ASTRAL_ANOMALY, AHBiomes.TWISTED_ASTRAL_ANOMALY),
                    SurfaceRules.ifTrue(
                          ABOVE_SEA_LEVEL, SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.state(AHBlocks.ANOMALOUS_GRASS_BLOCK.get().defaultBlockState()))
                    )));*/

    // GRASS BLOCK EXTENDING THROUGHOUT THE ENTIRE BIOME, ABOVE SEA LEVEL (Y=62)
    /*public static final SurfaceRules.RuleSource GRASS_BLOCK_SURFACE = SurfaceRules.sequence(
            SurfaceRules.ifTrue(SurfaceRules.isBiome(AHBiomes.FLUSHED_ASTRAL_ANOMALY, AHBiomes.TWISTED_ASTRAL_ANOMALY),
                    SurfaceRules.ifTrue(
                          ABOVE_SEA_LEVEL, SurfaceRules.state(AHBlocks.ANOMALOUS_GRASS_BLOCK.get().defaultBlockState())
                    )));*/

    // GRASS BLOCK EXTENDING THROUGHOUT THE ENTIRE BIOME
    /*public static final SurfaceRules.RuleSource GRASS_BLOCK_SURFACE = SurfaceRules.sequence(
            SurfaceRules.ifTrue(SurfaceRules.isBiome(AHBiomes.FLUSHED_ASTRAL_ANOMALY, AHBiomes.TWISTED_ASTRAL_ANOMALY), SurfaceRules.state(AHBlocks.ANOMALOUS_GRASS_BLOCK.get().defaultBlockState())));*/

    /*public static final SurfaceRules.RuleSource GRASS_BLOCK_SURFACE = SurfaceRules.sequence(
            SurfaceRules.ifTrue(SurfaceRules.isBiome(AHBiomes.FLUSHED_ASTRAL_ANOMALY, AHBiomes.TWISTED_ASTRAL_ANOMALY), SurfaceRules.sequence(
                    SurfaceRules.ifTrue(ABOVE_SEA_LEVEL, SurfaceRules.sequence(
                            SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(AHBlocks.ANOMALOUS_GRASS_BLOCK.get().defaultBlockState())),
                            SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(AHBlocks.ANOMALOUS_DIRT.get().defaultBlockState()))
                    )),
                    SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(10, false, CaveSurface.CEILING), SurfaceRules.state(AHBlocks.ANOMALOUS_STONE.get().defaultBlockState())),
                    SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(10, false, CaveSurface.FLOOR), SurfaceRules.state(AHBlocks.ANOMALOUS_STONE.get().defaultBlockState())
            ))));*/
}
