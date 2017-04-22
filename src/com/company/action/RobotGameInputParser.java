package com.company.action;

import com.company.data.RobotState.Direction;
import com.company.data.Action;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Created by shuai9532 on 4/16/17.
 */
public class RobotGameInputParser {


  public int[] readInitialLocation(InputStream stream){
    Scanner in = new Scanner(stream);
    in.useDelimiter("\n");
    System.out.println("Location:");

    if(in.hasNext()) {
      String loc = in.next();
      int[] result = convertLocation(loc);
      return result;
    }
    return null;
  }

  private int[] convertLocation(String location){

    if(location.equals("") || location == null || location.length() < 5) return null;
    if(!(location.charAt(0) == '[' && location.charAt(location.length()-1) == ']')) return null;

    int[] arr = new int[2];
    String subString = location.substring(1,location.length()-1);
    String[] temp = subString.split(",");

    if(temp.length != 2)
      return null;

    for(int i = 0;i < temp.length; i++) {
      try {
        arr[i] = Integer.parseInt(temp[i].trim());
      } catch (NumberFormatException ex) {
        ex.printStackTrace();
        return null;
      }
    }
    return arr;
  }

  public Direction readInitialDirection(InputStream stream) {
    Scanner in = new Scanner(stream);
    in.useDelimiter("\n");
    System.out.println("Direction faced:");

    if(in.hasNext()) {
      switch (in.next().trim()) {
        case "N":
          return Direction.N;
        case "S":
          return Direction.S;
        case "E":
          return Direction.E;
        case "W":
          return Direction.W;
        default:
          return null;
      }
    }
    return null;
  }

  public List<Action> readActions(InputStream stream){
    Scanner in = new Scanner(stream);
    List<Action> actions = new ArrayList<>();
    in.useDelimiter("\n");
    System.out.println("Actions:");

    if(!in.hasNext()){
      return actions;
    }
    String[] actions_string = in.next().split(",");
    for(String action : actions_string){
      String trimmedAction = action.trim();
      if(!(trimmedAction.equals("M") || trimmedAction.equals("L")|| trimmedAction.equals("R"))){
        return null;
      }
      actions.add(new Action(trimmedAction));
    }
    return actions;
  }

}
