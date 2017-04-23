package com.company;

import com.company.RobotState.Direction;

/**
 * Created by shuai9532 on 4/22/17.
 */
public class TurnLeft implements Action{

  @Override
  public boolean execute(RobotState currentState, SquareBoard board) {

    switch (currentState.getDirection()) {
      case N:
        // change current dir to W
        currentState.setDirection(Direction.W);
        break;
      case E:
        // change current dir to E
        currentState.setDirection(Direction.E);
        break;
      case S:
        // change current dir to N
        currentState.setDirection(Direction.N);
        break;
      case W:
        // change current dir to S
        currentState.setDirection(Direction.S);
        break;
    }
    return true;
  }
}
