package com.tonymanou.mowitnow.model;

/**
 * Describes the garden, in which mowers are mowing the lawn.
 */
public class Garden {

    private int sizeX, sizeY;

    /**
     * Constructs a garden with a given size.
     *
     * @param sizeX width of the garden
     * @param sizeY height of the garden
     */
    public Garden(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    @Override
    public String toString() {
        return "Garden{" +
                "sizeX=" + sizeX +
                ", sizeY=" + sizeY +
                '}';
    }
}
