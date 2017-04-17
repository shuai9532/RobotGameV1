package com.company;

import java.util.Scanner;

/**
 * Created by shuai9532 on 4/16/17.
 */
public class SetUp {
  static String location;
  static String direction;
  static String actions;

  public SetUp(){
    Scanner in = new Scanner(System.in);
    System.out.println("Location:");
    location = in.next();
    System.out.println("Direction faced:");
    direction = in.next();
    System.out.println("Actions:");
    actions = in.next();
  }

}
