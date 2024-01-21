package com.github.klyser.astralhorizons.world.feature;

import com.github.klyser.astralhorizons.registry.AHTags;
import com.github.klyser.astralhorizons.util.AHMathsUtil;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.phys.Vec3;

import static com.github.klyser.astralhorizons.util.AHMathsUtil.randomAbsoluteIntSwap;

public class AstralRitualStructuresFeature{
    private BlockPos terraMonolithOrigin = null;
    private BlockPos infernoMonolithOrigin = null;
    private BlockPos ultimaMonolithOrigin = null;
    public static final int MIN_DISTANCE_BETWEEN_STRUCTURES = 200;
    public static final int MAX_DISTANCE_BETWEEN_STRUCTURES = 400;

    public boolean place(BlockPos gatewayOrigin, RandomSource random, Level level) {
        int gatewayOriginX = gatewayOrigin.getX();
        int gatewayOriginY = gatewayOrigin.getY();
        int gatewayOriginZ = gatewayOrigin.getZ();

        // Pick the three locations for the monoliths
        // Random direction on the X and Z axis
        int distance = AHMathsUtil.randomIntegerBetweenTwoValues(MIN_DISTANCE_BETWEEN_STRUCTURES, MAX_DISTANCE_BETWEEN_STRUCTURES);
        int triangleLength = distance;
        int triangleHeight = (int) Math.round((Math.sqrt(3) / 2) * triangleLength);

        double theta = random.nextDouble() * 2 * Math.PI;

        terraMonolithOrigin = new BlockPos(
                gatewayOriginX + distance,
                gatewayOriginY,
                gatewayOriginZ
        );
        infernoMonolithOrigin = new BlockPos(
                gatewayOriginX + triangleHeight / 2,
                gatewayOriginY,
                gatewayOriginZ + -distance / 2
        );
        ultimaMonolithOrigin = new BlockPos(
                gatewayOriginX + -triangleHeight / 2,
                gatewayOriginY,
                gatewayOriginZ + -distance / 2
        );

        // Rotate the monoliths around the gateway randomly
        terraMonolithOrigin = rotateBlockPosAroundPivot(terraMonolithOrigin, gatewayOrigin, theta);
        infernoMonolithOrigin = rotateBlockPosAroundPivot(infernoMonolithOrigin, gatewayOrigin, theta);
        ultimaMonolithOrigin = rotateBlockPosAroundPivot(ultimaMonolithOrigin, gatewayOrigin, theta);

        // Check that each origin is in an anomalous biome
        if (!level.getBiome(terraMonolithOrigin).is(AHTags.IS_ANOMALOUS) ||
                !level.getBiome(infernoMonolithOrigin).is(AHTags.IS_ANOMALOUS) ||
                !level.getBiome(ultimaMonolithOrigin).is(AHTags.IS_ANOMALOUS)) {
            return false;
        }
        return false;
    }

    private BlockPos rotateBlockPosAroundPivot(BlockPos pos, BlockPos pivot, double theta) {
        int x = pos.getX() - pivot.getX();
        int z = pos.getZ() - pivot.getZ();

        double cosTheta = Math.cos(theta);
        double sinTheta = Math.sin(theta);

        int rotatedX = (int) Math.round(cosTheta * x - sinTheta * z);
        int rotatedZ = (int) Math.round(sinTheta * x + cosTheta * z);

        return new BlockPos(pivot.getX() + rotatedX, pos.getY(), pivot.getZ() + rotatedZ);
    }

/*    @Override
    public boolean place(FeaturePlaceContext<AstralRitualStructuresConfiguration> context) {
         BlockPos gatewayOrigin = context.origin();
        // Pick the three locations for the monoliths
        // Random direction on the X and Z axis
        RandomSource random = context.random();
        Vec3 randomDirection = new Vec3(
                AHMathsUtil.randomAbsoluteDoubleSwap(random.nextDouble() / 2 + 0.5),
                0,
                AHMathsUtil.randomAbsoluteDoubleSwap(random.nextDouble()) / 2 + 0.5);
        BlockPos terraOrigin = gatewayOrigin.offset(
                vec3ToBlockPos(randomDirection.multiply(
                        MAX_DISTANCE_BETWEEN_STRUCTURES,
                        1,
                        MAX_DISTANCE_BETWEEN_STRUCTURES)));
        // Get the highest blocks which can see the sky.
        // Check that all four of these locations are in an astral anomaly, if not, return false.
        return false;
    }*/

    private static BlockPos vec3ToBlockPos(Vec3 vec3) {
        return new BlockPos((int) Math.round(vec3.x), (int) Math.round(vec3.y), (int) Math.round(vec3.z));
    }
}
