package com.company.data;

/**
 * Created by shuai9532 on 4/16/17.
 */
public class SquareBoard implements Board {

  public static int[][] board;

  public SquareBoard(int size){
    board =  new int[size][size];
  }

  /**
   * Check if the robot can move to the target location (x,y)
   * @param x X in target location
   * @param y Y in target location
   * @return True if the robot can move to the target location
   */
  @Override
  public boolean canMoveToPosition(int x, int y) {
    return (x <= board[0].length && x >= 1 && y <= board.length && y >= 1);
  }
}
