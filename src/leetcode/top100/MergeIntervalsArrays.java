package leetcode.top100;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class MergeIntervalsArrays {
  public static class Interval implements Comparable<Interval>{
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
      public int compareTo(Interval int1) {
        return this.start - int1.start;
      }
  }
  
  public static void main(String[] args) {
	  // [[1,3],[2,6],[8,10],[15,18]]
        int[][] intervals = new int[][] {{1,3},{2,6},{8,10},{15,18}};
        merge(intervals);
    }
  
  public static int[][] merge(int[][] int2) {
	  List<Integer[]> result = new ArrayList<>();
	  System.out.println(int2.length);
	  int length = int2.length;
	  if (length <=1) return int2; 
	  Integer[][] intervals = new Integer[length][2];
	  for (int i=0; i < length; i++) {
		  for (int j=0; j < int2[i].length; j++) {
			  intervals[i][j] = int2[i][j];
		  }
	  }
	  Arrays.sort(intervals, new Comparator<Integer[]>() {
		  @Override
		public int compare(Integer[] o1, Integer[] o2) {
			return o1[0] - o2[0];
		}
	  });
	  for (int i=0; i < length; i++) {
		  System.out.println(intervals[i][0] + "," + intervals[i][1]);
	  }
	  int start = intervals[0][0];
	  int end = intervals[0][1];
	  for (int i=0; i < length; i++) {
		   if (intervals[i][0] <= end) {
			   end = Math.max(end, intervals[i][1]);
		   } else {
			   result.add(new Integer[]{start, end});
			   start = intervals[i][0];
			   end = intervals[i][1];
		   }
	  }
	  result.add(new Integer[]{start, end});
      int size = result.size();
      int[][] returnValue = new int[size][2];
      for (int i=0; i < size; i++) {
    	  	returnValue[i][0] = result.get(i)[0];
    	  	returnValue[i][1] = result.get(i)[1];
      }
      return returnValue;
  }
    
    

}


