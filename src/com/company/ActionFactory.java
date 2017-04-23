package com.company;

/**
 * Created by shuai9532 on 4/22/17.
 */
public class ActionFactory {

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
