package com.company.data;

/**
 * Created by shuai9532 on 4/16/17.
 */
public class SquareBoard implements Board {

  private int sideLength;

  public SquareBoard(int sideLength){
    this.sideLength = sideLength;
  }

  /**
   * Check if the robot can move to the target location (x,y)
   * @param x X in target location
   * @param y Y in target location
   * @return True if the robot can move to the target location
   */
  @Override
  public boolean canMoveToPosition(int x, int y) {
    return (x <= this.sideLength && x >= 1 && y <= this.sideLength && y >= 1);
  }
}
