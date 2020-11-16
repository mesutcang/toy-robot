package com.robot.simulator.command;

import com.robot.simulator.Direction;
import com.robot.simulator.Robot;

public class RightCommand implements Command {

    @Override
    public void execute(Robot robot) {
        if (robot.isPlaced()) {
            Direction newDirection = Direction.valueOf((robot.getCurrentDirection().getDirectionIndex() + 1) % 4);
            robot.setCurrentDirection(newDirection);
        }
    }
}
