import java.util.*;
public class SearchRange {
  public static void main(String args[]) {
    int nums[] = new int[]{5,7,7,8,8,10};
    int target = 8;
    System.out.println(Arrays.toString(new Solution().searchRange(nums, target)));
  }
}
class Solution {
    public int[] searchRange(int[] nums, int target) {
      int num[] = new int[]{firstbSearch(nums, target, 0, nums.length - 1), lastbSearch(nums, target, 0, nums.length - 1)};
      return num;
    }
    private int firstbSearch(int nums[], int target, int start, int end) {
      if(start > end) return -1;
      int mid = (start + end) / 2;
      if(nums[mid] == target && (mid - 1 < 0 || nums[mid - 1] != target)) return mid;
      else if(target <= nums[mid]) return firstbSearch(nums, target, start, mid - 1);
      return firstbSearch(nums, target, mid + 1, end);
    }
    private int lastbSearch(int nums[], int target, int start, int end) {
      if(start > end) return -1;
      int mid = (start + end) / 2;
      if(nums[mid] == target && (mid + 1 >= nums.length || nums[mid + 1] != target)) return mid;
      else if(target >= nums[mid]) return lastbSearch(nums, target, mid + 1, end);
      return lastbSearch(nums, target, start, mid - 1);
    }
}
