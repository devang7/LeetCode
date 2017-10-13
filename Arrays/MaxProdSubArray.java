public class MaxProdSubArray {
  public static void main(String args[]) {
    int nums[] = new int[]{-1,-2,-9,-6};
    System.out.println(new Solution().maxProduct(nums));
  }
}
class Solution {
    public int maxProduct(int[] nums) {
      if(nums == null || nums.length <= 0) return 0;
      int maxUptilNow = nums[0];
      int minUptilNow = nums[0];
      int prevMax = nums[0];
      int prevMin = nums[0];
      int maxTotal = nums[0];
      for(int i = 1; i < nums.length; i++) {
        prevMax = maxUptilNow;
        prevMin = minUptilNow;
        maxUptilNow = Math.max(nums[i], Math.max(nums[i]*prevMax, nums[i]*prevMin));
        minUptilNow = Math.min(nums[i], Math.min(nums[i]*prevMin, nums[i]*prevMax));
        maxTotal = Math.max(maxTotal, maxUptilNow);
      }
      return maxTotal;
    }
}

/*
Max product can be formed by prevMin*negative number or prevMax*positive number.
Hence, we need to maintain both maxSeenSoFar and MinSeenSoFar.
Be careful while updating the values
*/
