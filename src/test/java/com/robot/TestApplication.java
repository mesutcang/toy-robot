package com.robot;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestApplication {


    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void test_main_ShouldRunCommands_WhenValidCommandsGiven() {
        StringBuilder sb = new StringBuilder();
        sb.append("PLACE 0,0,NORTH" + System.lineSeparator());
        sb.append("MOVE" + System.lineSeparator());
        sb.append("REPORT" + System.lineSeparator());
        sb.append("PLACE 0,0,NORTH" + System.lineSeparator());
        sb.append("LEFT" + System.lineSeparator());
        sb.append("REPORT" + System.lineSeparator());
        sb.append("PLACE 1,2,EAST" + System.lineSeparator());
        sb.append("MOVE" + System.lineSeparator());
        sb.append("MOVE" + System.lineSeparator());
        sb.append("LEFT" + System.lineSeparator());
        sb.append("MOVE" + System.lineSeparator());
        sb.append("REPORT" + System.lineSeparator());
        sb.append(System.lineSeparator());
        String expected = "Please run commands:\n"
            + "Robot positionX: 0, positionY: 1, direction: NORTH\n"
            + "Robot positionX: 0, positionY: 0, direction: WEST\n"
            + "Robot positionX: 3, positionY: 3, direction: NORTH\n";
        provideInput(sb.toString());
        Application.main(new String[0]);
        assertEquals(expected, testOut.toString());
    }

    @Test
    public void test_main_ShouldRunCommands_WhenOnlyValidCommandsGiven() {
        StringBuilder sb = new StringBuilder();
        sb.append("PLACE 2,3,SOUTH" + System.lineSeparator());
        sb.append("RANDOM" + System.lineSeparator());
        sb.append("REPORT" + System.lineSeparator());
        sb.append(System.lineSeparator());
        String expected = "Please run commands:\n"
            + "Robot positionX: 2, positionY: 3, direction: SOUTH\n";
        provideInput(sb.toString());
        Application.main(new String[0]);
        assertEquals(expected, testOut.toString());
    }


    @Test
    public void test_main_ShouldNotMoveOutOfTable_WhenValidCommandsGiven() {
        StringBuilder sb = new StringBuilder();
        sb.append("PLACE 3,2,SOUTH" + System.lineSeparator());
        sb.append("MOVE" + System.lineSeparator());
        sb.append("MOVE" + System.lineSeparator());
        sb.append("MOVE" + System.lineSeparator());
        sb.append("MOVE" + System.lineSeparator());
        sb.append("REPORT" + System.lineSeparator());
        sb.append(System.lineSeparator());
        String expected = "Please run commands:\n"
            + "Robot positionX: 3, positionY: 0, direction: SOUTH\n";
        provideInput(sb.toString());
        Application.main(new String[0]);
        assertEquals(expected, testOut.toString());
    }

}
