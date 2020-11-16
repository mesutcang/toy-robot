package com.robot.simulator.command;

import static org.junit.Assert.*;

import com.robot.simulator.Direction;
import com.robot.simulator.Robot;
import org.junit.Before;
import org.junit.Test;

public class RightCommandTest {
    Robot robot;
    @Before
    public void setUp() throws Exception {
        robot = new Robot();
    }

    @Test
    public void test_execute_ShouldNotRun_WhenRobotNotPlaced() {

        RightCommand sut = new RightCommand();
        sut.execute(robot);
        assertNull(robot.getCurrentDirection());
    }


    @Test
    public void test_execute_ShouldRun_WhenRobotPlaced() {
        robot.setPositionX(1);
        robot.setPositionY(2);
        robot.setCurrentDirection(Direction.SOUTH);
        RightCommand sut = new RightCommand();
        sut.execute(robot);
        assertEquals(Direction.WEST, robot.getCurrentDirection());

        sut.execute(robot);
        assertEquals(Direction.NORTH, robot.getCurrentDirection());

        sut.execute(robot);
        assertEquals(Direction.EAST, robot.getCurrentDirection());

        sut.execute(robot);
        assertEquals(Direction.SOUTH, robot.getCurrentDirection());

        sut.execute(robot);
        assertEquals(Direction.WEST, robot.getCurrentDirection());
    }

}