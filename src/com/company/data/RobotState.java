package com.company.data;

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
    this.direction = direction;
  }

  /**
   * Get the X in current location
   * @return X
   */
  public int getX() {return location[0];}

  /**
   * Update the new X value after the robot makes a movement
   * @param x X in new location
   */
  public void setX(int x) {location[0] = x;}

  /**
   * Get the Y in current location
   * @return  Y
   */
  public int getY() {return location[1];}

  /**
   * Update the new Y value after the robot makes a movement
   * @param y Y in new location
   */
  public void setY(int y) {location[1] = y;}

  /**
   * Get direction
   * @return Direction
   */
  public Direction getDirection() {return direction;}

  /**
   * Set new direction after the robot makes a turn
   * @param direction New direction after the turn
   */
  public void setDirection(Direction direction) {this.direction = direction;}

}
