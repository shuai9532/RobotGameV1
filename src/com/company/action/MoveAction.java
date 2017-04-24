package com.company.action;

import com.company.data.Board;
import com.company.data.RobotState;
/**
 * Created by shuai9532 on 4/22/17.
 */
public class MoveAction implements Action {

  // singleton design pattern
  private static final MoveAction SINGLETON = new MoveAction();

  private MoveAction(){}

  public static MoveAction getInstance() {
    return SINGLETON;
  }

  /**
   * Move the robot one step further
   * @param currentState Current location and direction of the robot
   * @param board The board that robot is moving
   * @return True if the robot makes a move
   */
  @Override
  public boolean execute(RobotState currentState, Board board) {

    int x = currentState.getX();
    int y = currentState.getY();
    boolean success = false;

    switch(currentState.getDirection()){
      case N:
        if(board.canMoveToPosition(x,y + 1)){
          currentState.setY(y + 1);
          success = true;
        }
        break;
      case S:
        if(board.canMoveToPosition(x,y - 1)){
          currentState.setY(y - 1);
          success = true;
        }
        break;
      case E:
        if(board.canMoveToPosition(x + 1, y)){
          currentState.setX(x + 1);
          success = true;
        }
        break;
      case W:
        if(board.canMoveToPosition(x - 1, y)){
          currentState.setX(x - 1);
          success = true;
        }
        break;
    }
    return success;
  }

}
