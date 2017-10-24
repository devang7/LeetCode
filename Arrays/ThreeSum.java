import java.util.*;
public class ThreeSum {
  public static void main(String args[]) {
    int nums[] = new int[]{-4,-1,-1,0,1,2};
    System.out.println(new Solution().threeSum(nums));
  }
}
class Solution {
  public List<List<Integer>> threeSum(int nums[]) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    for(int i = 0; i < nums.length; i++) {
      if(i - 1 >= 0 && nums[i] == nums[i - 1]) continue;      //duplicate handling
      int c = -nums[i];
      int start = i + 1;
      int end = nums.length - 1;
      while(start < end) {
        if(nums[start] + nums[end] == c) {
          List<Integer> list = new ArrayList<>();
          list.add(nums[i]);
          list.add(nums[start]);
          list.add(nums[end]);
          result.add(list);
        }
        while(start + 1 < nums.length && nums[start] == nums[start + 1]) start++;   //duplicate handling
        while(end - 1 >= 0 && nums[end] == nums[end - 1]) end--;  //duplicate handling
        if(nums[start] + nums[end] >  c) end--;
        else start++;
      }
    }
    return result;
  }
}

/*
Handling the duplicate triplets is tricky. See line 13, 25, 26 carefully.
O(n^2)
This can be extended to k-sum. O(n^3) for 4 sum
*/
