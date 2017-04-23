package com.company.action;

import com.company.data.SquareBoard;
import com.company.data.RobotState;
import com.company.data.RobotState.Direction;
/**
 * Created by shuai9532 on 4/22/17.
 */
public class TurnRight implements Action {

  /**
   * Make robot turn right
   * @param currentState Current location and direction of the robot
   * @param board The board that robot is moving
   * @return True if the robot takes a turn successfully
   */
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
