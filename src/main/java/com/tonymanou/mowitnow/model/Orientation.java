package com.tonymanou.mowitnow.model;

/**
 * Describes a cardinal direction.
 */
public enum Orientation {

    /**
     * North
     */
    N(0, 1),

    /**
     * East
     */
    E(1, 0),

    /**
     * West
     */
    W(-1, 0),

    /**
     * South
     */
    S(0, -1);

    private final int movementX, movementY;

    Orientation(int directionX, int directionY) {
        this.movementX = directionX;
        this.movementY = directionY;
    }

    public int getMovementX() {
        return movementX;
    }

    public int getMovementY() {
        return movementY;
    }
}
