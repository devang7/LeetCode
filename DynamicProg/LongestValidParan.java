import java.util.*;
public class LongestValidParan {

  public static void main(String args[]) {
    String s = "((((((((()())())";
    System.out.println(new Solution().longestValidParentheses(s));
  }
}
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        char a[] = s.toCharArray();
        int maxLength = 0;
        st.push(-1);
        for(int i = 0; i < a.length; i++) {
          if(a[i] == ')') {
            st.pop();
            if(st.isEmpty()) {
              st.push(i);
              continue;
            }
            maxLength = Math.max(maxLength, i - st.peek());
          }
          else st.push(i);
        }
        return maxLength;
    }
}

/*
=> Stack Top will always give the last INVALID Index
=> VVImp to maintain the stack top as the last Invalid Index seen.
*/
