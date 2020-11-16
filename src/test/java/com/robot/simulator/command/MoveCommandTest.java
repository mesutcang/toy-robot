package com.robot.simulator.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.robot.simulator.Direction;
import com.robot.simulator.Robot;
import org.junit.Before;
import org.junit.Test;

public class MoveCommandTest {

    Robot robot;

    @Before
    public void setUp() throws Exception {
        robot = new Robot();
    }

    @Test
    public void test_execute_ShouldNotRun_WhenRobotNotPlaced() {

        MoveCommand sut = new MoveCommand();
        sut.execute(robot);
        assertNull(robot.getCurrentDirection());
        assertNull(robot.getPositionX());
        assertNull(robot.getPositionY());
    }

    @Test
    public void test_execute_ShouldMove_WhenRobotPlaced() {
        robot.setPositionX(2);
        robot.setPositionY(3);
        robot.setCurrentDirection(Direction.NORTH);
        MoveCommand sut = new MoveCommand();
        sut.execute(robot);

        assertEquals(Direction.NORTH, robot.getCurrentDirection());
        assertEquals(2, robot.getPositionX().intValue());
        assertEquals(4, robot.getPositionY().intValue());

        robot.setCurrentDirection(Direction.EAST);
        sut.execute(robot);

        assertEquals(Direction.EAST, robot.getCurrentDirection());
        assertEquals(3, robot.getPositionX().intValue());
        assertEquals(4, robot.getPositionY().intValue());

        robot.setCurrentDirection(Direction.SOUTH);
        sut.execute(robot);

        assertEquals(Direction.SOUTH, robot.getCurrentDirection());
        assertEquals(3, robot.getPositionX().intValue());
        assertEquals(3, robot.getPositionY().intValue());

        robot.setCurrentDirection(Direction.WEST);
        sut.execute(robot);

        assertEquals(Direction.WEST, robot.getCurrentDirection());
        assertEquals(2, robot.getPositionX().intValue());
        assertEquals(3, robot.getPositionY().intValue());

    }


}