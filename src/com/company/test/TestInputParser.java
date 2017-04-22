package com.company.test;

/**
 * Created by shuai9532 on 4/18/17.
 */
import com.company.data.Action;
import com.company.action.RobotGameInputParser;
import com.company.data.RobotState.Direction;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestInputParser {

  RobotGameInputParser parser = new RobotGameInputParser();

  @Test
  public void testInputLocation(){
    String location = "[1,4 ";
    InputStream in = new ByteArrayInputStream(location.getBytes());
    int[] loc = parser.readInitialLocation(in);
    assertEquals(null,loc);

    location = "[1 ,2";
    in = new ByteArrayInputStream(location.getBytes());
    loc = parser.readInitialLocation(in);
    assertEquals(null,loc);

    location = "[1,a,2]";
    in = new ByteArrayInputStream(location.getBytes());
    loc = parser.readInitialLocation(in);
    assertEquals(null,loc);

    location = "";
    in = new ByteArrayInputStream(location.getBytes());
    loc = parser.readInitialLocation(in);
    System.err.println(loc);
    assertEquals(null,loc);

    location = "1,2";
    in = new ByteArrayInputStream(location.getBytes());
    loc = parser.readInitialLocation(in);
    assertEquals(null,loc);

    location = "1,2]";
    in = new ByteArrayInputStream(location.getBytes());
    loc = parser.readInitialLocation(in);
    assertEquals(null,loc);

    location = "1";
    in = new ByteArrayInputStream(location.getBytes());
    loc = parser.readInitialLocation(in);
    assertEquals(null,loc);

    location = "1,2";
    in = new ByteArrayInputStream(location.getBytes());
    loc = parser.readInitialLocation(in);
    assertEquals(null,loc);

    location = ",2";
    in = new ByteArrayInputStream(location.getBytes());
    loc = parser.readInitialLocation(in);
    assertEquals(null,loc);

    location = "1,a2";
    in = new ByteArrayInputStream(location.getBytes());
    loc = parser.readInitialLocation(in);
    assertEquals(null,loc);

    location = "(1,2)";
    in = new ByteArrayInputStream(location.getBytes());
    loc = parser.readInitialLocation(in);
    assertEquals(null,loc);

    location = "[1,2]";
    in = new ByteArrayInputStream(location.getBytes());
    loc = parser.readInitialLocation(in);
    assertEquals(1,loc[0]);
    assertEquals(2,loc[1]);

    location = "[1 ,2]";
    in = new ByteArrayInputStream(location.getBytes());
    loc = parser.readInitialLocation(in);
    assertEquals(1,loc[0]);
    assertEquals(2,loc[1]);

    location = "[1 ,   2]";
    in = new ByteArrayInputStream(location.getBytes());
    loc = parser.readInitialLocation(in);
    assertEquals(1,loc[0]);
    assertEquals(2,loc[1]);

    location = "[   1 ,2  ]";
    in = new ByteArrayInputStream(location.getBytes());
    loc = parser.readInitialLocation(in);
    assertEquals(1,loc[0]);
    assertEquals(2,loc[1]);


  }


  @Test
  public void testInputDirection(){
    String directions = "N,S,W,E,E  ,  E";
    for(String direction: directions.split(",")) {
      InputStream in =  new ByteArrayInputStream(direction.getBytes());
      Direction dir = parser.readInitialDirection(in);
      assertEquals(direction.trim(), dir.toString());
    }

    directions = "s,n,w,e,,',a,b,=,aa,ss";
    for(String direction: directions.split(",")) {
      InputStream in =  new ByteArrayInputStream(direction.getBytes());
      Direction dir = parser.readInitialDirection(in);
      assertEquals(null, dir);
    }

  }

  @Test
  public void testInputActions(){
    String actions = "1,4,M,M,L";
    InputStream in = new ByteArrayInputStream(actions.getBytes());
    List<Action> actionlList = parser.readActions(in);
    assertEquals(null, actionlList);

    actions = "l,S,M,M,L";
    in = new ByteArrayInputStream(actions.getBytes());
    actionlList = parser.readActions(in);
    assertEquals(null, actionlList);

    actions = " ,M,M,L";
    in = new ByteArrayInputStream(actions.getBytes());
    actionlList = parser.readActions(in);
    assertEquals(null, actionlList);

    actions = "";
    in = new ByteArrayInputStream(actions.getBytes());
    actionlList = parser.readActions(in);
    assertEquals(new ArrayList<Action>(), actionlList);

    actions = " M,M,M,L";
    in = new ByteArrayInputStream(actions.getBytes());
    actionlList = parser.readActions(in);
    String[] arr = actions.split(",");
    for(int i = 0; i < arr.length; i++) {
      assertEquals(new Action(arr[i].trim()).getAction(), actionlList.get(i).getAction());
    }

    actions = "M,M,L";
    in = new ByteArrayInputStream(actions.getBytes());
    actionlList = parser.readActions(in);
    arr = actions.split(",");
    for(int i = 0; i < arr.length; i++) {
      assertEquals(new Action(arr[i].trim()).getAction(), actionlList.get(i).getAction());
    }

  }

}
