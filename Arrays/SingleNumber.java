public class SingleNumber {
  public static void main(String args[]) {
    int nums[] = new int[]{2,2,4,4,3,1,1};
    System.out.println(new Solution().singleNumber(nums));
  }
}
class Solution {
    public int singleNumber(int[] nums) {
      if(nums == null || nums.length <= 0) return 0;
      int x = nums[0];
      for(int i = 1; i < nums.length; i++) {
        x ^= nums[i];
      }
      return x;
    }
}
