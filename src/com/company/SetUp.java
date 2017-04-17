package com.company;

import java.util.Scanner;

/**
 * Created by shuai9532 on 4/16/17.
 */
public class SetUp {
  static int[] location= new int[2];
  static String direction;
  static String actions;

  public SetUp(){
    Scanner in = new Scanner(System.in);
    System.out.println("Location:");
    processLocation(in.next());
    System.out.println("Direction faced:");
    direction = in.next();
    System.out.println("Actions:");
    actions = in.next();
  }
  private void processLocation(String location){

    String subString = location.substring(1,location.length()-1);
    String[] temp = subString.split(",");
    this.location[0]=Integer.parseInt(temp[0]);
    this.location[1]=Integer.parseInt(temp[1]);

  }

}
