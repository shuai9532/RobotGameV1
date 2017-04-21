package com.company;

import com.company.RobotState.Direction;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuai9532 on 4/16/17.
 */
public class ActionProcess {

  private char[] actionArray;
  private RobotState currentState;
  private Border border;

  public ActionProcess(RobotState currentState, Border border, List<Action> action){

    this.currentState = currentState;
    this.border = border;

  }

  public void processAction(){
    for(int i = 0; i < this.actionArray.length; i++) {
      actionProcessor(this.actionArray[i]);
    }
    System.out.println(
        String.format("the final location: [%s,%s]", currentState.getX(),currentState.getY()));
    System.out.println("the direction faced: "+ currentState.getDirection());
  }

  private void actionProcessor( char movement) {

    switch (movement) {
      case 'M':
        //if not in boundary:
        if(!moveSuccess()){
          System.out.println("the robot at the boundary");
          System.out.println(
              String.format("the current location:[%s,%s]", currentState.getX(),currentState.getY()));
          System.out.println("the direction faced: "+ currentState.getDirection());
        }

      case 'L':
        switch (currentState.getDirection()) {
          case N: currentState.setDirection(Direction.W); break; // change current dir to W
          case E: currentState.setDirection(Direction.E); break; // change current dir to E
          case S: currentState.setDirection(Direction.N); break; // change current dir to N
          case W: currentState.setDirection(Direction.S); break; // change current dir to S
        }

      case 'R':
        switch (currentState.getDirection()) {
          case N: currentState.setDirection(Direction.E); break;// change current dir to E
          case S: currentState.setDirection(Direction.W); break;// change current dir to W
          case E: currentState.setDirection(Direction.S); break;// change current dir to S
          case W: currentState.setDirection(Direction.N); break;// change current dir to N
        }
    }

  }

  private boolean moveSuccess() {
    //get current location
    //need to do teh update of the location is success
    switch (currentState.getDirection()) {
      case S:
        // check if if it is in bound after +1, and then
        if(currentState.getY() >= 2){
          currentState.setY(currentState.getY() - 1);
        }
        return false;
      case N:
        // check if if it is in bound after +1
        if(currentState.getY() <= Border.BORDER[0].length - 1){
          currentState.setY(currentState.getY() + 1);
        }
        return false;
      case E:
        // check if if it is in bound after +1
        if(currentState.getX() <= Border.BORDER[0].length - 1){
          currentState.setX(currentState.getX() + 1);
        }
        return false;
      case W:
        // check if if it is in bound after +1
        if(currentState.getX() >= 2){
          currentState.setX(currentState.getX() - 1);
        }
        return false;
    }
    return false;
  }


}
