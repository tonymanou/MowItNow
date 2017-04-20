package com.tonymanou.mowitnow.model;

import com.tonymanou.mowitnow.util.OrientationUtils;

/**
 * Describes a mower, mowing the lawn in the garden.
 */
public class Mower {

    private final int id;
    private int positionX, positionY;
    private Orientation orientation;

    /**
     * Constructs a {@link Mower} with initial position and orientation in the garden.
     *
     * @param id          id of the mower
     * @param positionX   initial horizontal position in the garden
     * @param positionY   initial vertical position in the garden
     * @param orientation initial orientation
     */
    public Mower(int id, int positionX, int positionY, Orientation orientation) {
        this.id = id;
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    public int getId() {
        return id;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    /**
     * Make the mower turn to the left.
     */
    public void turnToLeft() {
        orientation = OrientationUtils.toLeftOf(orientation);
    }

    /**
     * Make the mower turn to the right.
     */
    public void turnToRight() {
        orientation = OrientationUtils.toRightOf(orientation);
    }

    /**
     * Make the mower move forward in the garden following its current orientation.
     * <p/>
     * The mower will move only and only if it can move forward in the garden both
     * vertically and horizontally following its current orientation.
     *
     * @param garden the garden in which the mower is moving
     * @return {@code true} if the mower was able to move, {@code false} otherwise
     * @throws IllegalArgumentException if garden is null
     * @throws IllegalStateException    if the mower is currently outside the bounds of the given garden
     */
    public boolean moveForward(Garden garden) {
        if (garden == null) {
            throw new IllegalArgumentException("garden must not be null");
        }
        int gardenX = garden.getSizeX() - 1;
        int gardenY = garden.getSizeY() - 1;

        // Ensure the mower is not outside the bounds of the garden
        if (positionX < 0 || positionY < 0 || positionX > gardenX || positionY > gardenY) {
            throw new IllegalStateException("The mower is currently outside the bounds of the garden: "
                    + this + ", " + garden);
        }

        int newPositionX = positionX + orientation.getMovementX();
        int newPositionY = positionY + orientation.getMovementY();
        boolean canMoveHorizontally = newPositionX >= 0 && newPositionX <= gardenX;
        boolean canMoveVertically = newPositionY >= 0 && newPositionY <= gardenY;

        if (canMoveHorizontally && canMoveVertically) {
            positionX = newPositionX;
            positionY = newPositionY;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Mower{" +
                "id=" + id +
                "positionX=" + positionX +
                ", positionY=" + positionY +
                ", orientation=" + orientation +
                '}';
    }
}
