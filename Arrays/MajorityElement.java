public class MajorityElement {
  public static void main(String args[]) {
    int nums[] = new int[]{1,1,2,2,1,1,1};
    System.out.println(new Solution().majorityElement(nums));
  }
}
class Solution {
    public int majorityElement(int[] nums) {
      int m = 0;
      int c = 0;
      for(int i = 0; i < nums.length; i++) {
        if(c == 0) {
          m = nums[i];
          c = 1;
        } else if(m == nums[i]) c++;
        else c--;
      }
      return m;
    }
}


/*
Basic application of Boyer - Moore's Majoriy Element algorithm. This algorithm assumes that majority element
is always present. In order to detect, just do one more pass and count the number of times m has occured.
If not majority, then no majority element present.
O(n) and O(1) space
*/
