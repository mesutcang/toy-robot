package com.robot.simulator.command;

import static com.robot.simulator.Robot.canRobotMove;

import com.robot.simulator.Robot;

public class MoveCommand implements Command {

    @Override
    public void execute(Robot robot) {
        if (robot.isPlaced()) {
            switch (robot.getCurrentDirection()) {
                case NORTH:
                    if (canRobotMove(robot.getPositionY() + 1)) {
                        robot.setPositionY(robot.getPositionY() + 1);
                    }
                    break;
                case SOUTH:
                    if (canRobotMove(robot.getPositionY() - 1)) {
                        robot.setPositionY(robot.getPositionY() - 1);
                    }
                    break;
                case EAST:
                    if (canRobotMove(robot.getPositionX() + 1)) {
                        robot.setPositionX(robot.getPositionX() + 1);
                    }
                    break;
                case WEST:
                    if (canRobotMove(robot.getPositionX() - 1)) {
                        robot.setPositionX(robot.getPositionX() - 1);
                    }
                    break;
            }
        }
    }


}
