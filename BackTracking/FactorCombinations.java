import java.util.*;
public class FactorCombinations {
  public static void main(String args[]) {
    int n = 37;
    System.out.println(new Solution().getFactors(n));
  }
}
class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        buildSolution(result, list, n, 2);
        result.remove(result.size() - 1);
        return result;
    }
    public void buildSolution(List<List<Integer>> result, List<Integer> list, int n, int start) {
      if(n <= 1) {
        result.add(new ArrayList<>(list));
        return;
      }
      for(int i = start; i <= n; i++) {
        if(n % i == 0) {
          list.add(i);
          buildSolution(result, list, n/i, i);
          list.remove(list.size() - 1);
        }
      }
    }
}
/*
The tricky part here is to avoid duplicates likes [2,2,3] and [3,2,2]
Its very important to start adding factors from 'start' variable.
*/
