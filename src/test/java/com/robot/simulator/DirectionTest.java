package com.robot.simulator;

import static org.junit.Assert.*;

import org.junit.Test;

public class DirectionTest {

    @Test
    public void test_direction_ShouldCoverAllDirectionsWithIndexes() {
        Direction sut = Direction.valueOf(0);

        assertEquals(0, sut.getDirectionIndex());
        assertEquals(Direction.NORTH, sut);

        sut = Direction.valueOf(3);

        assertEquals(Direction.WEST, sut);

    }

}