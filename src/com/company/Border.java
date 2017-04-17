package com.company;

/**
 * Created by shuai9532 on 4/16/17.
 */
public class Border {
  static int[][] BORDER = new int[8][8];
  Border(){
    for(int i = 0; i < BORDER.length; i++){
      for(int j = i; j < BORDER[i].length; j++){
        BORDER[i][j]= j + 1;
      }
    }
  }
}
