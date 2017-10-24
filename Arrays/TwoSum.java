import java.util.*;
public class TwoSum {
  public static void main(String args[]) {
    int nums[] = new int[]{1,2,3};
    int target = 5;
    System.out.println(new Solution().twoSum(target, nums));
  }
}
class Solution {
  public boolean twoSum(int target, int nums[]) {
    Set<Integer> set = new HashSet<>();
    for(int i = 0; i < nums.length; i++) {
      if(set.contains(nums[i])) return true;
      set.add(target - nums[i]);
    }
    return false;
  }
}
