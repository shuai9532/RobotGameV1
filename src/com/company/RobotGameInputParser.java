package com.company;

import com.company.RobotState.Direction;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Created by shuai9532 on 4/16/17.
 */
public class RobotGameInputParser {

  public int[] readInitialLocation(){
    Scanner in = new Scanner(System.in);
    System.out.println("Location:");
    String loc = in.next();
    return convertLocation(loc);
  }

  private int[] convertLocation(String location){

    if(location.equals("") || location == null || location.length() < 5) return null;
    if(!(location.indexOf(0) == '[' && location.indexOf(location.length()-1) == ']')) return null;

    int[] arr = new int[2];
    String subString = location.substring(1,location.length()-1);
    String[] temp = subString.split(",");

    if(temp.length != 2) return null;

    for(int i = 0;i < temp.length; i++) {
      try {
        arr[i] = Integer.parseInt(temp[i]);
      } catch (NumberFormatException ex) {
        ex.printStackTrace();
        return null;
      }
    }
    return arr;
  }

  public Direction readInitialDirection() {
    Scanner in = new Scanner(System.in);
    System.out.println("Direction faced:");

    switch(in.next()){
      case "N": return Direction.N;
      case "S": return Direction.S;
      case "E": return Direction.E;
      case "W": return Direction.W;
      default: return null;
    }
  }

  public List<Action> readActions(){
    List<Action> actions = new ArrayList<>();
    System.out.println("Actions:");
    Scanner in = new Scanner(System.in);
    String[] actions_string = in.next().split(",");
    for(String action : actions_string){
      if(!(action.equals("M") || action.equals("L")|| action.equals("R"))){
        return null;
      }
      actions.add(new Action(action));
    }
    return actions;
  }

}
