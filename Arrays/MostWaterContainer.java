public class MostWaterContainer {
  public static void main(String args[]) {
    int height[] = new int[]{10,15,6,10,12};
    System.out.println(new Solution().maxArea(height));
  }
}
class Solution {
    public int maxArea(int[] height) {
      int start = 0;
      int end = height.length - 1;
      int maxArea = 0;
      while(start < end) {
        maxArea = Math.max(maxArea, Math.min(height[start], height[end])*(end - start));
        if(height[start] < height[end]) start++;
        else end--;
      }
      return maxArea;
    }
}


/*
=> Greedy algorithm. You want the distance to be as far as possible and height to be as max as possible. 
*/
