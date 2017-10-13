import java.util.*;
public class MaxPointsLine {
  public static void main(String args[]) {
    Point a1 = new Point(1,1);
    Point a2 = new Point(1,1);
    Point a3 = new Point(2,3);
  //  Point a4 = new Point(41,63);
  //  Point a5 = new Point(2,3);
    Point p[] = new Point[]{a1,a2,a3};
    System.out.println(new Solution().maxPoints(p));
  }
}
class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length <= 0) return 0;
        Map<String, Integer> dupMap = new HashMap<>();
        int n = points.length;
        for(int i = 0; i < n; i++) {
          String s = points[i].x + "," + points[i].y;
          if(dupMap.containsKey(s)) {
            dupMap.put(s, dupMap.get(s) + 1);
          } else {
            dupMap.put(s, 1);
          }
        }
        Map<Double, Set<String>> map = new HashMap<>();
        int maxLeng = 1;
        for(int i = 0; i < n; i++) {
          for(int j = i + 1; j < n; j++) {
              double slope = 0;
              if(points[i].y - points[j].y == 0) {
                slope = 0;
              } else if(points[i].x - points[j].x != 0) {
                slope = (points[i].y - points[j].y) / (double)(points[i].x - points[j].x);
              } else {
                slope = Double.MAX_VALUE;
              }
              if(map.containsKey(slope)) {
                Set<String> set = map.get(slope);
                set.add(points[j].x + "," + points[j].y);
              } else {
                Set<String> set = new HashSet<>();
                set.add(points[i].x + "," + points[i].y);
                set.add(points[j].x + "," + points[j].y);
                map.put(slope, set);
              }
          }
          ///System.out.println(map);
        }
        for(Double d : map.keySet()) {
          Set<String> set = map.get(d);
          int len = 0;
          for(String p : set) {
            len += dupMap.get(p);
          }
          maxLeng = Math.max(maxLeng, len);
        }
        return maxLeng;
    }
}
class Point {
     int x;
     int y;
     Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
}

/*
Problems:
- Divide by zero Excpetion when slope = Infy
- Negative zero problem when slope is zero, but denominator may or maynot be zero.
  Set considers -0.0 and 0.0 to be different quantities
- Beware of overlapping duplicate points. Need to record duplicate points first. 
*/
