public class MaxSubArray {
  public static void main(String args[]) {
    int nums[] = new int[]{-2,1,-3,4,-1,2,1,-5,4};
    System.out.println(new Solution().maxSubArray(nums));
  }
}
class Solution {
    public int maxSubArray(int[] nums) {
      int maxTillNow = nums[0];
      int maxTotal = nums[0];
      for(int i = 1; i < nums.length; i++) {
        maxTillNow = Math.max(nums[i], nums[i] + maxTillNow);
        maxTotal = Math.max(maxTotal, maxTillNow);
      }
      return maxTotal;
    }
}
