package com.robot.simulator.command;

import com.robot.simulator.Robot;

public class ReportCommand implements Command {

    @Override
    public void execute(Robot robot) {
        if (robot.isPlaced()) {
            System.out.println("Robot positionX: " + robot.getPositionX() + ", positionY: " + robot.getPositionY()
                + ", direction: " + robot.getCurrentDirection());
        }
    }
}
