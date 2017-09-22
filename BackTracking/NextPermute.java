import java.util.*;

public class NextPermute {
  public static void main(String args[]) {
    int nums[] = new int[]{2,3,1};
    new Solution().nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
  }
}
class Solution {
    public void nextPermutation(int[] nums) {
      int n = nums.length;
      int i = n - 1;
      int j = n - 2;
      while(j >= 0 && nums[j] >= nums[i]) {
        i--;
        j--;
      }
      if(j < 0) {
        reverse(nums, 0, n - 1);
        return;
      }
      swap(nums, j, nextGreater(nums, i + 1, n - 1, nums[j]));
      reverse(nums, i, n - 1);
    }
    private void reverse(int nums[], int start, int end) {
      while(start < end) {
        swap(nums, start, end);
        start++;
        end--;
      }
    }
    private void swap(int nums[], int start, int end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
    }

    private int nextGreater(int nums[], int start, int end, int key) {
      while(start <= end && nums[start] > key) {
        start++;
      }
      return start - 1;
    }
}

/*
=> Find drop points a[j] > a[i]
=> Find the first drop. If no drop, just reverse it.
=> If there is a drop, find the next Greater Integer from (i, n - 1) just greater than a[j]
=> Take advantage of the fact that (i, n - 1) will always be descending so reverse would be sorted. 
*/
