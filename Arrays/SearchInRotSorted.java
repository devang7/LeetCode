public class SearchInRotSorted {
  public static void main(String args[]) {
    int nums[] = new int[]{4,5,6,7,0,1,2};
    int target = 2;
    System.out.println(new Solution().search(nums, target));
  }
}
class Solution {
    public int search(int[] nums, int target) {
      return bsearch(nums, target, 0, nums.length - 1);
    }
    public int bsearch(int nums[], int target, int start, int end) {
      if(start > end) return -1;
      int mid = (start + end) / 2;
      if(nums[mid] == target) return mid;
      if(nums[start] < nums[mid]) {
        if(target > nums[start] && target < nums[mid]) {
          return bsearch(nums, target, start, mid - 1);
        } else {
          return bsearch(nums, target, mid + 1, end);
        }
      } else {
        if(target > nums[mid] && target < nums[end]) {
          return bsearch(nums, target, mid + 1, end);
        } else {
          return bsearch(nums, target, start, mid - 1);
        }
      }
    }
}
