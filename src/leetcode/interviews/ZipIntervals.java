package leetcode.interviews;


import java.util.*;

class ZipIntervals {
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

        intervals.add(new Interval(94133,94133));
        intervals.add(new Interval(94200,94299));
        intervals.add(new Interval(94226,94399));
        
        Collections.sort(intervals);
        System.out.println("Input");
        for (Interval interval: intervals) {
          System.out.println("[" + interval.start + "," + interval.end + "]");
        }
        System.out.println(" Output ");
        List<Interval> mergedIntervals =  mergeIntervals(intervals);
        for (Interval interval: mergedIntervals) {
          System.out.println("[" + interval.start + "," + interval.end + "]");
        }
    }
  
    
    
    public static List<Interval> mergeIntervals(List<Interval> intervals) {
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


