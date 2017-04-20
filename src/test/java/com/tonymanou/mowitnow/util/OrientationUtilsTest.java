package com.tonymanou.mowitnow.util;

import com.tonymanou.mowitnow.model.Orientation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrientationUtilsTest {

    @Test
    public void orientationToLeftOfNorthIsWest() {
        assertEquals(Orientation.W, OrientationUtils.toLeftOf(Orientation.N));
    }

    @Test
    public void orientationToLeftOfSouthIsEast() {
        assertEquals(Orientation.E, OrientationUtils.toLeftOf(Orientation.S));
    }

    @Test
    public void orientationToLeftOfEastIsNorth() {
        assertEquals(Orientation.N, OrientationUtils.toLeftOf(Orientation.E));
    }

    @Test
    public void orientationToLeftOfWestIsSouth() {
        assertEquals(Orientation.S, OrientationUtils.toLeftOf(Orientation.W));
    }

    @Test(expected = NullPointerException.class)
    public void orientationToLeftOfNullThrowsNPE() {
        OrientationUtils.toLeftOf(null);
    }

    @Test
    public void orientationToRightOfNorthIsEast() {
        assertEquals(Orientation.E, OrientationUtils.toRightOf(Orientation.N));
    }

    @Test
    public void orientationToRightOfSouthIsWest() {
        assertEquals(Orientation.W, OrientationUtils.toRightOf(Orientation.S));
    }

    @Test
    public void orientationToRightOfEastIsSouth() {
        assertEquals(Orientation.S, OrientationUtils.toRightOf(Orientation.E));
    }

    @Test
    public void orientationToRightOfWestIsNorth() {
        assertEquals(Orientation.N, OrientationUtils.toRightOf(Orientation.W));
    }

    @Test(expected = NullPointerException.class)
    public void orientationToRightOfNullThrowsNPE() {
        OrientationUtils.toRightOf(null);
    }
}
