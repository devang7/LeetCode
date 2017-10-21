public class ValidSquare {
  public static void main(String args[]) {
    int num = 808201;
    System.out.println(new Solution().isPerfectSquare(num));
  }
}
class Solution {
    public boolean isPerfectSquare(int num) {
      if(num == 0 || num == 1) return true;
      return isValid(num, 1L, (long)num - 1);
    }
    private boolean isValid(int num, long start, long end) {
      if(start > end) return false;
      long mid = start + (end - start) / 2;
      if(mid*mid == num) return true;
      if(mid*mid < num) return isValid(num, mid + 1, end);
      else return isValid(num, start, mid - 1);
    }
}


/*
- Be very very careful of the overflow here. Since we are multiplyig mid*mid. It might overflow.
- Using mid = start + (end - start)/2 instead of mid = (start + end) / 2 makes sure mid does not overflo
- But for mid*mid, its best to keep everything in long.
*/
