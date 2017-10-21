import java.util.*;
public class SumOfSquareNumbers {
  public static void main(String args[]) {
    int c = 2;
    System.out.println(new Solution().judgeSquareSum(c));
  }
}
class Solution {
    public boolean judgeSquareSum(int c) {
      if(c == 0) return true;
      Set<Integer> set = new HashSet<>();
      int i = 0;
      while(i <= Math.sqrt(c)) {
        set.add(i*i);
        if(set.contains(c - i*i)) return true;
        i++;
      }
      return false;
    }
}

/*
Corner cases:
- Consider c = 0 case
- Consider 1*1 + 1*1 = 2; Hence, add in the set first and then check.
- Like two sum, this can be done faster with 2 pointers (Since input is already sorted).
  Start with left = 0 and right = Math.sqrt(c).
*/
