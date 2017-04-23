package com.company.data;

/**
 * Created by shuai9532 on 4/22/17.
 */
public interface Board {

  /**
   * Check if the robot can move to the target location (x,y)
   * @param x X in target location
   * @param y Y in target location
   * @return True if the robot can move to the target location
   */
  boolean canMoveToPosition(int x, int y);

}
