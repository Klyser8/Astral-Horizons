package com.github.klyser.astralhorizons.item;

/**
 * Represents an item that may become faded when in the wrong dimension.
 * A faded item is a weakened version of its normal self.
 * This usually means it is less effective and is overall weaker.
 * Faded items are distinguished from their normal counterparts, as they cannot be used in crafting recipes.
 */
public interface Fadeable {

    /**
     * @return true if the item is faded, false otherwise
     */
    boolean isFaded();

    /**
     * Sets the faded state of the item.
     * @param faded true if the item should be faded, false otherwise
     */
    void setFaded(boolean faded);

    //TODO attempt implementation of a fading item.

}
