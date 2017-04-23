package com.company;

import com.company.action.Action;
import com.company.action.MoveAction;
import com.company.action.TurnLeft;
import com.company.action.TurnRight;

/**
 * Created by shuai9532 on 4/22/17.
 */
public class ActionFactory {

  /**
   * Create action object from the string input of the user
   * @param action Action in a string form
   * @return Action object
   */
  public Action createAction(String action) {

    switch (action) {
      case "M":
        return new MoveAction();
      case "L":
        return new TurnLeft();
      case "R":
        return new TurnRight();
      default:
        return null;
    }
  }

}
