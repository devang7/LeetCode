import java.util.*;
public class PartitionArrayKSubset {
  public static void main(String args[]) {
    int nums[] = new int[]{605,454,322,218,8,19,651,2220,175,710,2666,350,252,2264,327,1843};
    int k = 4;
    System.out.println(new Solution().canPartitionKSubsets(nums, k));
  }
}
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
      int sum = 0;
      for(Integer i : nums) sum += i;
      if(k <= 0 || sum % k != 0) return false;
      boolean visited[] = new boolean[nums.length];
      return dfs(nums, visited, 0, sum / k, 0, k);
    }
    private boolean dfs(int nums[], boolean visited[], int currSum, int target, int start, int k) {
      if(k <= 1) return true;
      if(currSum == target) {
        return dfs(nums, visited, 0, target, 0, k - 1);
      }
      if(currSum > target) return false;
      for(int i = start; i < nums.length; i++) {
        if(!visited[i]) {
          visited[i] = true;
          if(!dfs(nums, visited, currSum + nums[i], target, i, k)) {
            visited[i] = false;
          } else {
            return true;
          }
        }
      }
      return false;
    }
}
