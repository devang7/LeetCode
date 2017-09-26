import java.util.*;

public class TrippingWater {
  public static void main(String args[]) {
    int height[] = new int[]{5,5,1,7,1,1,5,2,7,6};
    System.out.println(new Solution().trap(height));
  }
}
class Solution {
    public int trap(int[] height) {
      Stack<Integer> st = new Stack<>();
      if(height == null || height.length <= 0) return 0;
      int area = 0;
      for(int i = 0; i < height.length; i++) {
        if(!st.isEmpty() && height[i] > height[st.peek()]) {
          while(!st.isEmpty() && height[st.peek()] <= height[i]) {
            int x = height[st.pop()];
            if(st.isEmpty()) break;
            int minI = Math.min(height[i], height[st.peek()]);
            area += (minI - x)*(i - st.peek() - 1);
          }
        }
        st.push(i);
      }
      return area;
    }
}
