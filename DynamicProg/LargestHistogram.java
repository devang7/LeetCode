import java.util.*;

public class LargestHistogram {

  public static void main(String args[]) {
    int heights[] = new int[]{2,1,2};
    System.out.println(new Solution().largestRectangleArea(heights));
  }
}
class Solution {
  public int largestRectangleArea(int[] heights) {
      Stack<Integer> st = new Stack<>();
      int maxArea = 0;
      int i = 0;
      while(i < heights.length) {
          if(!st.isEmpty() && heights[i] < heights[st.peek()]) {
            int x = st.pop();
            int area = heights[x] * (i - (st.isEmpty() ? 0 : st.peek() + 1));
            maxArea = Math.max(maxArea, area);
          } else {
            st.push(i);
            i++;
          }
      }
      while(!st.isEmpty()) {
        int x = st.pop();
        int area = heights[x] * (heights.length - (st.isEmpty() ? 0 : st.peek() + 1));
        maxArea = Math.max(maxArea, area);
      }
      return maxArea;
  }
}



/*
=> The idea is to consider each Bar as the smallest one and calculating area to its left and right.
=> The overall max area would be the answer.
=> Stack Top will always keep track of the last bar higher than the one under consideration, Current index will be the bar higher than the current.
=> Not forget to empty the stack once out of the loop.
=> Every element just goes in the stack ones and comes out once. O(n) time
*/
