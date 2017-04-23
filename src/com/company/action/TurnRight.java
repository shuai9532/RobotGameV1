package com.company;

import com.company.RobotState.Direction;

/**
 * Created by shuai9532 on 4/22/17.
 */
public class TurnRight implements Action {

  @Override
  public boolean execute(RobotState currentState, SquareBoard board) {

    switch (currentState.getDirection()) {
      case N:
        // Change current dir to E
        currentState.setDirection(Direction.E);
        break;
      case S:
        // Change current dir to W
        currentState.setDirection(Direction.W);
        break;
      case E:
        // Change current dir to S
        currentState.setDirection(Direction.S);
        break;
      case W:
        // Change current dir to N
        currentState.setDirection(Direction.N);
        break;
    }
    return true;
  }
}
