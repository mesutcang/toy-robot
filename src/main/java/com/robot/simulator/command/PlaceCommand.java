package com.robot.simulator.command;

import static com.robot.simulator.Robot.canRobotMove;

import com.robot.simulator.Direction;
import com.robot.simulator.Robot;

public class PlaceCommand implements Command {

    private final Direction direction;
    private final Integer positionY;
    private final Integer positionX;

    public PlaceCommand(String parameters) {
        String[] params = parameters.split(",");
        this.positionX = Integer.valueOf(params[0]);
        this.positionY = Integer.valueOf(params[1]);
        this.direction = Direction.valueOf(params[2].trim().toUpperCase());

    }

    @Override
    public void execute(Robot robot) {
        if (canRobotMove(this.positionX) && canRobotMove(this.positionY)) {
            robot.setPositionX(this.positionX);
            robot.setPositionY(this.positionY);
            robot.setCurrentDirection(this.direction);
        }
    }
}
