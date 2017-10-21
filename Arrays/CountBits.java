import java.util.*;
public class CountBits {
  public static void main(String args[]) {
    int num = 8;
    System.out.println(Arrays.toString(new Solution().countBits(num)));
  }
}
class Solution {
    public int[] countBits(int num) {
      int arr[] = new int[num + 1];
      arr[0] = 0;
      if(num <= 0) return arr;
      arr[1] = 1;
      if(num <= 1) return arr;
      int index = 2;
      int c = 0;
      while(index <= num) {
        if(isPow2(index)) c = 0;
        arr[index++] = arr[c++] + 1;
      }
      return arr;
    }
    private boolean isPow2(int a) {
      double ans = Math.log(a) / Math.log(2);
      return ans - (int)ans == 0.0;
    }
}
