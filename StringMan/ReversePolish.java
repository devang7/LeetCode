import java.util.*;
public class ReversePolish {
  public static void main(String args[]) {
    String tokens[] = new String[]{"4", "13", "5", "/", "-"};
    System.out.println(new Solution().evalRPN(tokens));
  }
}
class Solution {
    public int evalRPN(String[] tokens) {
      Stack<String> st = new Stack<>();
      Set<String> exp = new HashSet<>(Arrays.asList(new String[]{"+","-","*","/"}));
      for(int i = 0; i < tokens.length; i++) {
        if(!exp.contains(tokens[i])) {
          st.push(tokens[i]);
        } else {
          String s1 = st.pop();
          String s2 = st.pop();
          st.push(eval(s1, s2, tokens[i]) + "");
        }
      }
      return Integer.parseInt(st.pop());
    }
    private int eval(String s1, String s2, String exp) {
      int a = Integer.parseInt(s1);
      int b = Integer.parseInt(s2);
      switch(exp) {
        case "+":
          return a + b;
        case "-":
          return b - a;
        case "*":
          return a * b;
        case "/":
          return b / a;
        default:
          return 0;
      }
    }
}
