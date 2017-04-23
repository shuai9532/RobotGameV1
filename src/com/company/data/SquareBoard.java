package com.company.data;

/**
 * Created by shuai9532 on 4/16/17.
 */
public class SquareBoard implements Board {

  public static int[][] BOARD;

  public SquareBoard(int size){
    BOARD =  new int[size][size];
  }

  /**
   * Check if the robot can move to the target location (x,y)
   * @param x X in target location
   * @param y Y in target location
   * @return True if the robot can move to the target location
   */
  @Override
  public boolean canMoveToPosition(int x, int y) {
    return (x <= BOARD[0].length && x >= 1 && y <= BOARD.length && y >= 1);
  }
}
