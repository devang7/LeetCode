import java.util.*;
public class ArrayExceptSelf {
  public static void main(String args[]) {
    int nums[] = new int[]{1,2,3,4};
    System.out.println(Arrays.toString(new Solution().productExceptSelf(nums)));
    System.out.println(Arrays.toString(new Solution().constantSpace(nums)));
  }
}
class Solution {
    public int[] productExceptSelf(int[] nums) {
      int right[] = new int[nums.length];
      int left[] = new int[nums.length];
      int result[] = new int[nums.length];
      left[0] = 1;
      for(int i = 1; i < nums.length; i++) {
        left[i] = nums[i - 1] * left[i - 1];
      }
      right[nums.length - 1] = 1;
      for(int i = nums.length - 2; i >= 0; i--) {
        right[i] = nums[i + 1] * right[i + 1];
      }
      for(int i = 0; i < nums.length; i++) {
        result[i] = left[i] * right[i];
      }
      return result;
    }
    public int[] constantSpace(int nums[]) {
      int result[] = new int[nums.length];
      result[0] = 1;
      for(int i = 1; i < nums.length; i++) {
        result[i] = nums[i - 1] * result[i - 1];
      }
      int right = 1;
      for(int i = nums.length - 2; i >= 0; i--) {
        result[i] = nums[i + 1] * result[i] * right;
        right *= nums[i + 1];
      }
      return result;
    }
}
