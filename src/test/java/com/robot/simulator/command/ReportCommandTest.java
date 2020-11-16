package com.robot.simulator.command;

import static org.junit.Assert.*;

import com.robot.simulator.Direction;
import com.robot.simulator.Robot;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReportCommandTest {
    Robot robot;
    private final PrintStream systemOut = System.out;

    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        robot = new Robot();
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void restoreSystemInputOutput() {
        System.setOut(systemOut);
    }

    @Test
    public void test_execute_ShouldNotRun_WhenRobotNotPlaced() {

        ReportCommand sut = new ReportCommand();
        sut.execute(robot);
        assertTrue(testOut.toString().isBlank());
    }

    @Test
    public void test_execute_ShouldReport_WhenRobotPlaced() {
        robot.setPositionX(1);
        robot.setPositionY(3);
        robot.setCurrentDirection(Direction.WEST);
        ReportCommand sut = new ReportCommand();
        sut.execute(robot);
        assertEquals("Robot positionX: 1, positionY: 3, direction: WEST\n", testOut.toString());
    }
}