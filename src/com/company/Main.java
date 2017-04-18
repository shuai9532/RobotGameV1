package com.company;

import com.company.RobotState.Direction;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    //giving instructions:
    System.out.println("Welcome to the Robot Game");
    System.out.println("Given a starting position [x,y] (0<x,y<9), "
        + "initial direction faced (W, S, N, E) on 8 x 8 square board "
        + "and sequence of actions for a robot, print the outcome; "
        + "direction faced and position on the board.\n"
        + "Allowed Actions: \n"
        + "M: Move 1 square forward\n"
        + "L: Turn left\n"
        + "R: Turn right");
    System.out.println("\n");
    System.out.println("The following is the input format:");
    System.out.println("Location: [2,3]\n"
        + "Direction faced: N\n"
        + "Actions: M,M,M,L,M,R,R,R");

    RobotGameInputParser parser = new RobotGameInputParser();
    int[] location = parser.readInitialLocation();
    while(location == null){
      System.err.println("the input location is not valid.");
      System.err.println("the location is composed of x and y; start with [ and end with ] \n"
          + "sample input :[2,3]");
      System.err.println("Please re-input:");
      location = parser.readInitialLocation();
    }

    Direction direction = parser.readInitialDirection();
    while(direction == null){
      System.err.println("the input direction is not valid.");
      System.err.println("direction faced: W, S, N, E");
      System.err.println("Please re-input:");
      direction = parser.readInitialDirection();
    }

    List<Action> actions = parser.readActions();
    while(actions == null){
      System.err.println("the input actions contain invalid step or teh formatt is wrong.");
      System.err.println("the actions are limited to:\n"
          + "M: Move 1 square forward\n"
          + "L: Turn left\n"
          + "R: Turn right\n");
      System.err.println("The formatt is : M,M,M,L,M,R,R,R");
      System.err.println("Please re-input: ");
      actions = parser.readActions();
    }

    ActionProcess processor = new ActionProcess(
        new RobotState(location[0],location[1],direction),
        new Border(), actions);

    processor.processAction();
  }
}
