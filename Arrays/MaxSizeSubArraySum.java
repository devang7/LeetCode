public class MaxSizeSubArraySum {
  public static void main(String args[]) {
    int nums[] = {2,3,1,2,4,3};
    int s = 7;
    System.out.println(new Solution().minSubArrayLen(s, nums));
  }
}
class Solution {
  public int minSubArrayLen(int s, int nums[]) {
    if(s < 0) return 0;
    int minSize = Integer.MAX_VALUE;
    int left = 0;
    int right = 0;
    int windowSum = nums[0];
    while(left < nums.length) {
      if(windowSum < s && right + 1 < nums.length) {
        right++;
        windowSum += nums[right];
      }
      else {
        windowSum -= nums[left];
        left++;
      }
      if(windowSum == s && minSize > right - left + 1) {
        minSize = right - left + 1;
      }
    }
    int x = minSize == Integer.MAX_VALUE ? 0 : minSize;
    return x;
  }
}
/*
Given an array of n positive integers and a positive integer s, find the minimal length
of a subarray of which the sum  s. If there isn’t one, return 0 instead.
For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal
length of 2 under the problem constraint.

=> Sliding window application. When window sum is < target right++ else left--;
*/
