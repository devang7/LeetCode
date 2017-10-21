import java.util.*;
public class InsertInterval {
  public static void main(String args[]) {
    Interval a = new Interval(1,5);
    Interval b = new Interval(2,3);
    Interval c = new Interval(9,10);
    Interval d = new Interval(10,14);
    List<Interval> intervals = new ArrayList<>(Arrays.asList(new Interval[]{a,b,c,d}));
    Interval newI = new Interval(19,20);
    System.out.println(new Solution().insert(intervals, newI));
  }
}
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
      List<Interval> mergeList = new ArrayList<>();
      if(intervals == null) return mergeList;
      List<Interval> newList = new ArrayList<>();
      int j = 0;
      if(intervals.size() <= 0) newList.add(newInterval);
      while(j < intervals.size()) {
        if(newInterval.start <= intervals.get(j).start){
            newList.add(newInterval);
            break;
        }
        newList.add(intervals.get(j++));
      }
      while(j < intervals.size()) newList.add(intervals.get(j++));
      if(newList.size() == intervals.size()) newList.add(newInterval);
      int start = newList.get(0).start;
      int end = newList.get(0).end;
      j = 1;
      while(j < newList.size()) {
        if(newList.get(j).start <= end && newList.get(j).end >= end) {
          end = newList.get(j).end;
        } else if(newList.get(j).start > end){
          mergeList.add(new Interval(start, end));
          start = newList.get(j).start;
          end = newList.get(j).end;
        }
        j++;
      }
      mergeList.add(new Interval(start, end));
      return mergeList;
    }
}
class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

      @Override
      public String toString() {
        return "[" + start + "," + end + "]";
      }
}

/*
=> First insert the interval then merge the intervals. Be careful of corner cases!
- Corner Cases:
1. The interval list can be empty, but new Interval wont be empty.
2. New interval can be after all the original intervals.
*/
