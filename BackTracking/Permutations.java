import java.util.*;
public class Permutations {
  public static void main(String args[]) {
    int nums[] = new int[]{1,2,3};
    System.out.println(new Solution().permute(nums));
    int dup[] = new int[]{1,2,3};
    System.out.println(new Solution().permuteWithDup(dup));
  }
}
class Solution {
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      List<Integer> list = new ArrayList<>();
      permute(result, list, nums);
      return result;
    }
    public List<List<Integer>> permuteWithDup(int nums[]) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      List<Integer> list = new ArrayList<>();
      Arrays.sort(nums);
      permuteWithDup(result, list, nums, new boolean[nums.length]);
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
    private void permuteWithDup(List<List<Integer>> result, List<Integer> list, int nums[], boolean visited[]) {
      if(list.size() == nums.length) {
        result.add(new ArrayList<>(list));
        return;
      }
      for(int i = 0; i < nums.length; i++) {
        if(visited[i]) continue;
        if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
        visited[i] = true;
        list.add(nums[i]);
        permuteWithDup(result, list, nums, visited);
        visited[i] = false;
        list.remove(list.size() - 1);
       }
    }
}
