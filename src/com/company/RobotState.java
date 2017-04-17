package com.company;

/**
 * Created by shuai9532 on 4/16/17.
 */
public class RobotState {

  String location = SetUp.location;
  String direction = SetUp.direction;

  public void setLocation(String location) {
    this.location = location;
  }

  public String getLocation() {
    return location;
  }

  public  void setDirection(String direction) {
    this.direction = direction;
  }

  public String getDirection() {
    return direction;
  }
}
