package com.company;

import com.company.action.Action;
import com.company.data.RobotState;
import com.company.data.RobotState.Direction;
import com.company.data.SquareBoard;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    // Giving instructions:
    System.out.println("Welcome to the Robot Game");
    System.out.println(
        "Given a starting position [x,y] (0<x,y<9), initial direction \n"
        + "faced (W, S, N, E) on 8 x 8 square board and sequence of actions\n"
        + "for a robot, print the outcome: direction faced and position on the board.\n"
        + "Allowed Actions: \n"
        + "M: Move 1 square forward\n"
        + "L: Turn left\n"
        + "R: Turn right");
    System.out.println("");
    System.out.println("The following is the input format:");
    System.out.println("Location: [2,3]\n"
        + "Direction faced: N\n"
        + "Actions: M,M,M,L,M,R,R,R");

    SquareBoard board =  new SquareBoard(8);
    RobotGameInputParser parser = new RobotGameInputParser();

    // Receive location
    int[] location = getInitialLocation(board, parser);
    // Receive direction
    Direction direction = getInitialDirection(parser);
    // Form the initial state of the robot
    RobotState state = new RobotState(location[0], location[1], direction);
    // Receive a list of actions
    List<Action> actions = getActions(parser);

    // Process actions
    for (Action action : actions) {
      if (!action.execute(state,board)) {
        System.out.println("The robot reaches the boundary");
        break;
      }
    }
    System.out.println(String.format("The final location:[%s,%s]", state.getX(), state.getY()));
    System.out.println("The direction faced: " + state.getDirection());

  }

  private static List<Action> getActions(RobotGameInputParser parser) {

    System.out.println("Actions:");
    ActionFactory factory = new ActionFactory();
    List<Action> actions = parser.readActions(System.in, factory);
    while (actions == null) {
      System.err.println("the input actions contain invalid step or the inout form is wrong.");
      System.err.println("the actions are limited to:\n"
          + "M: Move 1 square forward\n"
          + "L: Turn left\n"
          + "R: Turn right");
      System.err.println("The format is : M,M,M,L,M,R,R,R");
      System.err.println("Please re-input: ");
      actions = parser.readActions(System.in, factory);
    }
    return actions;
  }

  private static Direction getInitialDirection(RobotGameInputParser parser) {

    System.out.println("Direction faced:");
    Direction direction = parser.readInitialDirection(System.in);
    while (direction == null) {
      System.err.println("the input direction is not valid.");
      System.err.println("direction faced: W, S, N, E");
      System.err.println("Please re-input:");
      direction = parser.readInitialDirection(System.in);
    }
    return direction;
  }

  private static int[] getInitialLocation(SquareBoard board, RobotGameInputParser parser) {

    System.out.println("Location:");
    int[] location = parser.readInitialLocation(System.in);
    while (location == null || !board.canMoveToPosition(location[0],location[1]))
    {
      System.err.println("the input location is not valid.");
      System.err.println("the location is composed of x and y; start with [ and end with ] \n"
          + "the range for x and y is 1 to 8\n"
          + "sample input :[2,3]");
      System.err.println("Please re-input:");
      location = parser.readInitialLocation(System.in);
    }
    return location;
  }

}
