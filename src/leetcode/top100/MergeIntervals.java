package leetcode.top100;

import java.io.*;
import java.util.*;

import leetcode.top100.MergeIntervalsArrays.Interval;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class MergeIntervals {
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
        
        List<Interval> intervals = new ArrayList<>();

        intervals.add(new Interval(1,1));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(9,18));
        intervals.add(new Interval(5,9));
        intervals.add(new Interval(3,7));
        Collections.sort(intervals);
        for (Interval interval: intervals) {
          System.out.println("(" + interval.start + "," + interval.end + ")");
        }
        System.out.println(" ** ");
        List<Interval> mergedIntervals =  mergeIntervals(intervals);
        for (Interval interval: mergedIntervals) {
          System.out.println("(" + interval.start + "," + interval.end + ")");
        }
    }
  
    private static List<Interval> mergeIntervals(List<Interval> intervals)     {
      List<Interval> result = new ArrayList<>();
      Interval temp = null;
      for (int i=0; i <= intervals.size() - 2; i++) {
        Interval i1 = intervals.get(i);
        Interval i2 = intervals.get(i+1);
        if (i2.start > i1.end) {
        		if (temp != null) {
        			result.add(new Interval(temp.start, temp.end));
        			temp = new Interval(i2.start, i2.end);
        		}
        		else 
        			result.add(new Interval(i1.start, i1.end));
        } else {
        		if (temp == null) {
        			temp = new Interval();
        			temp.start = i1.start;
        			temp.end = i1.end;
        		}
        		temp.end = Math.max(i1.end, i2.end);
        }
      }
      if (temp != null) {
    	  	result.add(new Interval(temp.start, temp.end));
      }
      //result.add(intervals.get(intervals.size()-1));
      return result;
    } 
    
    public List<Interval> mergeFromLC(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;
        
        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        
        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        
        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }

}


