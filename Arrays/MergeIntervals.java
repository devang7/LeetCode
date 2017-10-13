import java.util.*;
public class MergeIntervals {
  public static void main(String args[]) {
    Interval a = new Interval(2,3);
    Interval b = new Interval(4,5);
    Interval c = new Interval(1,10);
    Interval d = new Interval(0,11);
    List<Interval> intervals = new ArrayList<>(Arrays.asList(new Interval[]{a,b,c,d}));
    System.out.println(new Solution().merge(intervals));
  }
}
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
      Collections.sort(intervals, new Comparator<Interval>(){
        @Override
        public int compare(Interval a, Interval b) {
          return new Integer(a.start).compareTo(new Integer(b.start));
        }
      });
      List<Interval> list = new ArrayList<>();
      if(intervals == null || intervals.size() <= 0) return list;
      int start = 0;
      int end = 0;
      Interval prev = null;
      for(Interval i : intervals) {
        if(prev == null || i.start > end) {
          if(prev != null) list.add(new Interval(start,end));
          start = i.start;
          end = i.end;
        } else {
          end = Math.max(end, i.end);
        }
        prev = i;
      }
      list.add(new Interval(start, end));
      return list;
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
