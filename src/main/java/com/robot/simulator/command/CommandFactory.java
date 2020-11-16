package com.robot.simulator.command;

public class CommandFactory {

    public static Command getCommand(String line) throws Exception {
        if (line != null) {
            try {
                String[] commandLine = line.split(" ");
                CommandType commandType = CommandType.valueOf(commandLine[0].trim().toUpperCase());

                switch (commandType) {
                    case PLACE:
                        return new PlaceCommand(commandLine[1]);
                    case MOVE:
                        return new MoveCommand();
                    case LEFT:
                        return new LeftCommand();
                    case RIGHT:
                        return new RightCommand();
                    case REPORT:
                        return new ReportCommand();
                }
            } catch (Exception e) {
                throw new Exception("Invalid command");
            }
        }
        return null;
    }
}