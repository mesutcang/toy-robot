package com.robot;

import com.robot.simulator.Robot;
import com.robot.simulator.command.Command;
import com.robot.simulator.command.CommandFactory;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Robot robot = new Robot();
        Scanner scanner = new Scanner(System.in);
        String line = null;
        System.out.println("Please run commands:");
        while ( !(line = scanner.nextLine()).isBlank() ){
            try {
                Command command = CommandFactory.getCommand(line);
                if (command != null){
                    command.execute(robot);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
