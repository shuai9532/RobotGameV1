package com.company;

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
        //get current direction
        String dir  = currentState.direction;
        //get the location if move one more step
        //if boundary:   input is
        // print "out of the map"
        // output the current location
        // restart the prompt
        //move one location forward
        //update the location
        //return

      case 'L':
        //get the current direction
        switch (currentState.direction) {
          case "N": // change current dir to W
          case "S": // change current dir to E
          case "E": // change current dir to N
          case "W": // change current dir to S
        }

      case 'R':
        //get the current direction
        switch (currentState.direction) {
          case "N": // change current dir to E
          case "S": // change current dir to W
          case "E": // change current dir to S
          case "W": // change current dir to N
        }
    }

  }



  private boolean nextInBorder(RobotState currentState) {

    //get current location

    switch (currentState.direction) {
      case "S": // check if if it is in bound after +1
      case "N": // check if if it is in bound after +1
      case "E": // check if if it is in bound after +1
      case "W": // check if if it is in bound after +1
    }
    return false;
  }


}
