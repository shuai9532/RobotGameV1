package com.company.action;

import com.company.data.Board;
import com.company.data.RobotState;
import com.company.data.RobotState.Direction;
/**
 * Created by shuai9532 on 4/22/17.
 */
public class TurnRightAction implements Action {

  // singleton design pattern
  private static final TurnRightAction SINGLETON = new TurnRightAction();

  private TurnRightAction(){}

  public static TurnRightAction getInstance() {
    return SINGLETON;
  }
  /**
   * Make robot turn right
   * @param currentState Current location and direction of the robot
   * @param board The board that robot is moving
   * @return True if the robot takes a turn successfully
   */
  @Override
  public boolean execute(RobotState currentState, Board board) {

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
