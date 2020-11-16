package com.robot.simulator.command;

import static org.junit.Assert.*;

import com.robot.simulator.Direction;
import com.robot.simulator.Robot;
import org.junit.Before;
import org.junit.Test;

public class PlaceCommandTest {

    Robot robot;

    @Before
    public void setUp() throws Exception {
        robot = new Robot();
    }

    @Test
    public void test_execute_ShouldNotRun_WhenInvalidParameters() {
        PlaceCommand sut = new PlaceCommand("10,20,NORTH");
        sut.execute(robot);
        assertNull(robot.getCurrentDirection());
        assertNull(robot.getPositionX());
        assertNull(robot.getPositionY());
    }

    @Test
    public void test_execute_ShouldRun_WhenValidParameters() {
        PlaceCommand sut = new PlaceCommand("1,2,NORTH");
        sut.execute(robot);
        assertEquals(1, robot.getPositionX().intValue());
        assertEquals(2, robot.getPositionY().intValue());
        assertEquals(Direction.NORTH, robot.getCurrentDirection());
    }

}