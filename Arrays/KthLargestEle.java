import java.util.*;
public class KthLargestEle {
  public static void main(String args[]) {
    int nums[] = new int[]{3,2,1,5,6,4};
    int k = 4;
    System.out.println(new Solution().KthLargest(nums, k, 0, nums.length - 1));
  }
}
class Solution {
  public int KthLargest(int nums[], int k, int start, int end) {
    int p = quickSort(nums, start, end);
    int l = p - start;                                            //IMP
    if(l + 1 == k) return nums[p];
    else if(l + 1 > k) return KthLargest(nums, k, start, p - 1);
    else return KthLargest(nums, k - (l + 1), p + 1, end);
  }
  private int quickSort(int nums[], int start, int end) {
    int pivot = start;
    int left = start + 1;
    int right = end;
    while(true) {
      while(left <= right && nums[left] > nums[pivot]) left++;
      while(right >= left && nums[right] < nums[pivot]) right--;
      if(left < right) {
        swap(nums, left, right);
      } else {
        swap(nums, pivot, right);
        return right;
      }
    }
  }
  private void swap(int nums[], int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }
}

/*
IMP step on line 12. To see how larget pivot is relative to the start index. Then base your decision on that.
*/
