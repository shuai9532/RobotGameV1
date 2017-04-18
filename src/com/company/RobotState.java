package com.company;


import java.util.Dictionary;

/**
 * Created by shuai9532 on 4/16/17.
 */

public class RobotState {

  public enum Direction{E, W, N, S}

  private int[] location = new int[2];
  private Direction direction;

  public RobotState(int X_axis, int Y_axis, Direction direction){
    location[0] = X_axis;
    location[1] = Y_axis;
    if( direction == Direction.E ||
        direction == Direction.W ||
        direction == Direction.S ||
        direction == Direction.N )
      this.direction = direction;
  }

  public int getX() {return location[0];}

  public void setX(int x) {location[0] = x;}

  public int getY() {return location[1];}

  public void setY(int y) {location[1] = y;}

  public Direction getDirection() {return direction;}

  public void setDirection(Direction direction) {this.direction = direction;}



}
