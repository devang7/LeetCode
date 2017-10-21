import java.util.*;
public class GenParanthesis {
  public static void main(String args[]) {
    int n = 3;
    System.out.println(new Solution().generateParenthesis(n));
  }
}
class Solution {
    public List<String> generateParenthesis(int n) {
      List<String> result = new ArrayList<>();
      int open = 0;
      int close = 0;
      genParanthesis(result, "", open, close, n);
      return result;
    }
    private void genParanthesis(List<String> result, String curr, int open, int close, int max) {
      if(curr.length() == 2 * max) {
        result.add(curr);
        return;
      }
      if(open < max) genParanthesis(result, curr + "(", open + 1, close, max);
      if(close < open) genParanthesis(result, curr + ")", open, close + 1, max);
    }
}
