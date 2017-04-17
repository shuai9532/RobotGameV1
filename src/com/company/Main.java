package com.company;

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

    SetUp start = new SetUp();
    ActionProcess processor = new ActionProcess(new Border(), new RobotState(), new Actions());
    processor.processAction();
  }
}
