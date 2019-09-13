package leetcode.interviews;

/* Problem Name is &&& Pascals Triangle &&& PLEASE DO NOT REMOVE THIS LINE. */

/*
==  Instructions ==
**  The below pattern of numbers are called Pascals Triangle.
**
**  Pascals Triangle exhibits the following behaviour:
**
**  The first and last numbers of each row in the triangle are 1
**  Each number in the triangle is the sum of the two numbers above it.
**
**  Example:
**               1
**              1 1
**             1 2 1
**            1 3 3 1
**           1 4 6 4 1
**         1 5 10 10 5 1
**        1 6 15 20 15 6 1
**
**  Please Complete the 'pascal' function below so that given a
**  col and a row it will return the value in that positon.
**
**  Example, pascal(1,2) should return 2
**
*/

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class PascalsTriangle {
  static List<List<Integer>> triangle = null;
  static HashMap<Point, Integer> map = new HashMap<>();
   /*Asserts on value returned from pascal */
  @Test public void doTestsPass(){
    System.out.println("test run");
  Assert.assertTrue(PascalsTriangle.pascal(0,0) ==  1);// true
    //Assert.assertTrue(PascalsTriangle.pascal(0,6) ==  1);
  Assert.assertTrue(PascalsTriangle.pascal(1,2) ==  2);
  Assert.assertTrue(PascalsTriangle.pascal(5,6) ==  6);
    //Assert.assertTrue(PascalsTriangle.pascal(6,3) ==  20);
    Assert.assertTrue(PascalsTriangle.pascal(Integer.MAX_VALUE,Integer.MAX_VALUE) ==  20);
    Assert.assertTrue(PascalsTriangle.pascal(1,-1) ==  -1);
    Assert.assertTrue(PascalsTriangle.pascal(-1,-1) ==  -1);
    Assert.assertTrue(PascalsTriangle.pascal(Integer.MIN_VALUE,Integer.MAX_VALUE) ==  -1);
  }

  public static int pascal2( int Col, int Row ){
    List<Integer> row = triangle.get(Row);
    int value = row.get(Col);
  return value;
  }
 
  public static int pascal( int Col, int Row ){
   if (Col < 0 || Row < 0) return 0;
    if (map.get(new Point(Row,Col)) != null) {
      return map.get(new Point(Row,Col));
    }
    if (Col == 0 || (Row == Col)) {
      map.put(new Point(Row,Col), 1);
      return 1;
    }
    int value = pascal(Col - 1, Row -1) + pascal(Col, Row -1);
    map.put(new Point(Row,Col), value);
    return value;
   
  }

  public static void main(String[] args) {
    triangle = generate(7);
    JUnitCore.main("PascalsTriangle");
   
  }
 
  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<List<Integer>>();
    if (numRows == 0)
      return triangle;
    triangle.add(new ArrayList<Integer>());
    triangle.get(0).add(1);
   
    for (int i = 1; i < numRows; i++) {
      List<Integer> row = new ArrayList<Integer>();
      List<Integer> prev = triangle.get(i - 1);
      row.add(1);
      for (int j=1; j < i; j++) {
        row.add(prev.get(j-1) + prev.get(j));
      }
      row.add(1);
      triangle.add(row);
    }
    return triangle;
  }
}

class Point {
  Integer row;
  Integer column;
  public Point(Integer r, Integer c) {
    this.row = r;
    this.column = c;
  }
 
  public int hashCode() {
    int result = 31;
    result = 17 * result + row;
    result = 17 * result + column;
    return result;
  }
 
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Point)) {
      return false;
    }
    Point p = (Point)o;
    return (p.row == this.row) && (p.column == this.column);
  }
}
