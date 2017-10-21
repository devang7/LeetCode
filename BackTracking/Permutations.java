import java.util.*;
public class Permutations {
  public static void main(String args[]) {
    int nums[] = new int[]{6,7,8};
    System.out.println(new Solution().permute(nums));
  }
}
class Solution {
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      List<Integer> list = new ArrayList<>();
      permute(result, list, nums);
      return result;
    }
    private void permute(List<List<Integer>> result, List<Integer> list, int nums[]) {
      if(list.size() == nums.length) {
        result.add(new ArrayList<>(list));
        return;
      }
      for(int i = 0; i < nums.length; i++) {
        if(!list.contains(nums[i])) {
          list.add(nums[i]);
          permute(result, list, nums);
          list.remove(list.size() - 1);
        }
      }
    }
}
