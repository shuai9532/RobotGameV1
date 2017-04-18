package com.company.test;

/**
 * Created by shuai9532 on 4/17/17.
 */

import com.company.RobotState;
import com.company.RobotState.Direction;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJunit {
  RobotState state = new RobotState(1,2, Direction.N);

  @Test
  public void testStatusData(){

    // Test direction
    assertEquals(state.getDirection(), Direction.N);
    state.setDirection(Direction.S);
    assertEquals(state.getDirection(), Direction.S);

    // Test location
    assertEquals(1,state.getX());
    assertEquals(2,state.getY());
    state.setX(5);
    state.setY(1);
    assertEquals(state.getY(),1);
    assertEquals(state.getX(),5);
    state.setX(7);
    state.setY(9);
    assertEquals(state.getY(),9);
    assertEquals(state.getX(),7);
  }

}
