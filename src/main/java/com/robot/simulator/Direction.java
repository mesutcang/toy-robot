package com.robot.simulator;

import java.util.HashMap;
import java.util.Map;

public enum Direction {

    NORTH(0), EAST(1), SOUTH(2), WEST(3);

    private int directionIndex;

    Direction(int directionIndex) {
        this.directionIndex = directionIndex;
    }

    public int getDirectionIndex() {
        return this.directionIndex;
    }

    private static Map map = new HashMap<>();
    static {
        for (Direction direction : Direction.values()) {
            map.put(direction.directionIndex, direction);
        }
    }

    public static Direction valueOf(int directionIndex) {
        return (Direction) map.get(directionIndex);
    }
}
