package com.company;

/**
 * Created by shuai9532 on 4/16/17.
 */
public class SquareBoard implements Board {

  public static int[][] BOARD;

  public SquareBoard(int size){
    BOARD =  new int[size][size];
  }

  @Override
  public boolean canMoveToPosition(int x, int y) {
    return (x <= BOARD[0].length && x >= 1 && y <= BOARD.length && y >= 1);
  }
}
