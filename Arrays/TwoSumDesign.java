import java.util.*;
public class TwoSumDesign {
  public static void main(String args[]) {
    TwoSum t = new TwoSum();
    t.add(1);
    t.add(2);
    t.add(5);
    System.out.println(t.find(4));
    System.out.println(t.find(3));
    t.add(5);
    System.out.println(t.find(10));
  }
}
class TwoSum {

    /** Initialize your data structure here. */
    Map<Integer, Boolean> map;
    public TwoSum() {
      map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
      if(map.containsKey(number)) {
        map.put(number, true);
      } else {
        map.put(number, false);
      }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
      Set<Integer> keys = map.keySet();
      for(Integer i : keys) {
        int f = value - i;
        if(map.containsKey(f) && f != i) return true;
        if(map.containsKey(f) && f == i) {
          if(map.get(f)) return true;
        }
      }
      return false;
    }
}

/*
=> Just maintain a duplicate flag to return answers like 7 + 7 = 14
*/
