package com.company.action;

import com.company.data.SquareBoard;
import com.company.data.RobotState;
/**
 * Created by shuai9532 on 4/22/17.
 */

public interface Action {

  /**
   * Process the action
   * @param currentState Current location and direction of the robot
   * @param board The board that robot is moving
   * @return True if the robot successfully makes a movement or takes a turn
   */
  public boolean execute(RobotState currentState, SquareBoard board);

}
