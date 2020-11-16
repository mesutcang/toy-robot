package com.robot.simulator;

import lombok.Data;

@Data
public class Robot {

    public static final int MAX_TABLE_LENGHT = 5;
    private Integer positionX;
    private Integer positionY;
    private Direction currentDirection;

    public boolean isPlaced() {
        return this.positionX != null && this.positionY != null && this.currentDirection != null;
    }

    public static boolean canRobotMove(int nextPosition) {
        if (nextPosition >= 0 && nextPosition < Robot.MAX_TABLE_LENGHT) {
            return true;
        }
        return false;
    }
}
