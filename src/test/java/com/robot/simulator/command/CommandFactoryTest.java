package com.robot.simulator.command;

import static org.junit.Assert.*;

import com.robot.Application;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CommandFactoryTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


    @Test
    public void test_getCommand_ShouldReturnRelatedCommand_WhenValidCommandGiven() throws Exception {

        Command sut = CommandFactory.getCommand("PLACE 3,2,SOUTH" + System.lineSeparator());
        assertEquals(PlaceCommand.class, sut.getClass());

        sut = CommandFactory.getCommand("LEFT" + System.lineSeparator());
        assertEquals(LeftCommand.class, sut.getClass());

        sut = CommandFactory.getCommand("right" + System.lineSeparator());
        assertEquals(RightCommand.class, sut.getClass());

        sut = CommandFactory.getCommand("MOVE" + System.lineSeparator());
        assertEquals(MoveCommand.class, sut.getClass());

    }


    @Test
    public void test_getCommand_ShouldThrowException_WhenInvalidCommandGiven() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Invalid command");
        CommandFactory.getCommand("random" + System.lineSeparator());

    }

    @Test
    public void test_getCommand_ShouldReturnNull_WhenInvalidCommandGiven() throws Exception {
        Command command = CommandFactory.getCommand(null);
        assertNull(command);
    }

}