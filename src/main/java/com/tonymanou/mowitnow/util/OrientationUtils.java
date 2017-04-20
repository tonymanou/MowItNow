package com.tonymanou.mowitnow.util;

import com.tonymanou.mowitnow.model.Orientation;

import java.util.Objects;

public final class OrientationUtils {

    private OrientationUtils() {
        throw new UnsupportedOperationException("Utility class must not be instantiated");
    }

    /**
     * Returns the {@link Orientation} situated on the left of the given orientation.
     *
     * @param currentOrientation the current orientation
     * @return the {@link Orientation} on the left of the current orientation
     * @throws NullPointerException if {@code currentOrientation} is null
     */
    public static Orientation toLeftOf(Orientation currentOrientation) {
        Objects.requireNonNull(currentOrientation, "Orientation must not be null");
        switch (currentOrientation) {
            case N:
                return Orientation.W;
            case E:
                return Orientation.N;
            case W:
                return Orientation.S;
            case S:
                return Orientation.E;
            default:
                throw new IllegalStateException("Unhandled orientation: " + currentOrientation);
        }
    }

    /**
     * Returns the {@link Orientation} situated on the right of the given orientation.
     *
     * @param currentOrientation the current orientation
     * @return the {@link Orientation} on the right of the current orientation
     * @throws NullPointerException if {@code currentOrientation} is null
     */
    public static Orientation toRightOf(Orientation currentOrientation) {
        Objects.requireNonNull(currentOrientation, "Orientation must not be null");
        switch (currentOrientation) {
            case N:
                return Orientation.E;
            case E:
                return Orientation.S;
            case W:
                return Orientation.N;
            case S:
                return Orientation.W;
            default:
                throw new IllegalStateException("Unhandled orientation: " + currentOrientation);
        }
    }
}
