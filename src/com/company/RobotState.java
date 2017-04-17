package com.company;

/**
 * Created by shuai9532 on 4/16/17.
 */
public class RobotState {

  private static int[] location = SetUp.location;
  private static String direction = SetUp.direction;

  public void setLocation(int[] location) {
    this.location = location;
  }

  public int[] getLocation() {
    return location;
  }

  public  void setDirection(String direction) {
    this.direction = direction;
  }

  public String getDirection() {
    return direction;
  }
}
