package com.company;

import java.util.Arrays;

/**
 * Created by shuai9532 on 4/16/17.
 */
public class ActionProcess {

  RobotState currentState;
  char[] actionList;

  public ActionProcess(Border border, RobotState currentState, Actions action){
    this.currentState = currentState;
    String actions = action.getActions();
    this.actionList = actions.toCharArray();

  }
  public void processAction(){
    for(int i = 0; i < this.actionList.length; i++) {
      actionProcessor(this.currentState,this.actionList[i]);
    }
  }
  private void actionProcessor(RobotState currentState, char movement) {

    switch (movement) {
      case 'M':
        //if not in boundary:
        if(!moveSuccess(currentState)){
          System.out.println("the robot at the boundary");
          System.out.println("the current location: " + Arrays.toString(currentState.getLocation()));
          System.out.println("the direction faced: "+ currentState.getDirection());
        }

      case 'L':
        switch (currentState.getDirection()) {
          case "N": currentState.setDirection("W"); // change current dir to W
          case "S": currentState.setDirection("E"); // change current dir to E
          case "E": currentState.setDirection("N"); // change current dir to N
          case "W": currentState.setDirection("S"); // change current dir to S
        }

      case 'R':
        switch (currentState.getDirection()) {
          case "N": currentState.setDirection("E"); // change current dir to E
          case "S": currentState.setDirection("W"); // change current dir to W
          case "E": currentState.setDirection("S"); // change current dir to S
          case "W": currentState.setDirection("N"); // change current dir to N
        }
    }

  }

  private boolean moveSuccess(RobotState currentState) {
    //get current location
    int[] currentLocation = currentState.getLocation();
    //need to do teh update of the location is success

    switch (currentState.getDirection()) {
      case "S":
        // check if if it is in bound after +1, and then
        if(currentLocation[1] >= 2){
          currentLocation[1] = currentLocation[1] - 1;
          currentState.setLocation(currentLocation);
        }
        return false;
      case "N":
        // check if if it is in bound after +1
        if(currentLocation[1] >= 7){
          currentLocation[1] = currentLocation[1] + 1;
          currentState.setLocation(currentLocation);
        }
        return false;
      case "E":
        // check if if it is in bound after +1
        if(currentLocation[0] >= 7){
          currentLocation[1] = currentLocation[0] + 1;
          currentState.setLocation(currentLocation);
        }
        return false;
      case "W":
        // check if if it is in bound after +1
        if(currentLocation[0] >= 2){
          currentLocation[1] = currentLocation[0] - 1;
          currentState.setLocation(currentLocation);
        }
        return false;
    }
    return false;
  }


}
