package com.robot.simulator;

import static org.junit.Assert.*;

import com.robot.Application;
import org.junit.Before;
import org.junit.Test;

public class RobotTest {
    Robot sut;

    @Before
    public void setUp() throws Exception {
        sut = new Robot();
    }

    @Test
    public void test_isPlaced_ShouldNotBePlaced_WhenCreated() {
        assertFalse(sut.isPlaced());
    }


    @Test
    public void test_isPlaced_ShouldNotBePlaced_WhenPositionXPositionYDirectionNotPlaced() {
        sut.setPositionY(2);
        sut.setPositionX(4);
        assertFalse(sut.isPlaced());
    }

    @Test
    public void test_isPlaced_ShouldPlaced_WhenPositionXPositionYDirectionPlaced() {
        sut.setCurrentDirection(Direction.SOUTH);
        sut.setPositionX(1);
        sut.setPositionY(2);
        assertTrue(sut.isPlaced());
    }

    @Test
    public void test_canRobotMove_ShouldValidate_WhenNextMoveInTable() {
        assertTrue(Robot.canRobotMove(2));
        assertTrue(Robot.canRobotMove(0));
        assertTrue(Robot.canRobotMove(4));
        assertFalse(Robot.canRobotMove(-2));
        assertFalse(Robot.canRobotMove(5));

    }

}