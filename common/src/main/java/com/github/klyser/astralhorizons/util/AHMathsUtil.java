package com.github.klyser.astralhorizons.util;

import java.util.Random;

public class AHMathsUtil {

    public static final Random random = new Random();

    /**
     * Returns a random integer between two values.
     * @param min The minimum value.
     * @param max The maximum value.
     * @return A random integer between the two values.
     */
    public static int randomIntegerBetweenTwoValues(int min, int max) {
        return min + random.nextInt(max - min);
    }

    /**
     * Changes the sign of the value, with a 1/2 chance.
     *
     * @param value The value to change the sign of.
     * @return The value with a 50% chance of being positive or negative.
     */
    public static int randomAbsoluteIntSwap(int value) {
        return random.nextDouble() < 0.5 ? -value : value;
    }

    /**
     * Changes the sign of the value, with a 1/2 chance.
     *
     * @param value The value to change the sign of.
     * @return The value with a 50% chance of being positive or negative.
     */
    public static double randomAbsoluteDoubleSwap(double value) {
        return random.nextDouble() < 0.5 ? -value : value;
    }

    /**
     * Changes the sign of the value, with a 1/2 chance.
     *
     * @param value The value to change the sign of.
     * @return The value with a 50% chance of being positive or negative.
     */
    public static float randomAbsoluteFloatSwap(float value) {
        return random.nextFloat() < 0.5 ? -value : value;
    }

}
