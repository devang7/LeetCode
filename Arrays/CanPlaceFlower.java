import java.util.*;
public class CanPlaceFlower {
  public static void main(String args[]) {
    int flowerbed[] = new int[]{1,0,0,0,0,0,1};
    int n = 2;
    System.out.println(new Solution().canPlaceFlowers(flowerbed, n));
  }
}
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
      int inValid = 0;
      for(int i = 0; i < flowerbed.length; i++) {
        if(flowerbed[i] == 0 && (i - 1 >= 0 && flowerbed[i - 1] == 1 || i + 1 < flowerbed.length && flowerbed[i + 1] == 1)) {
          flowerbed[i] = 2;
        }
      }
      int valid = 0;
      int j = 0;
      while(j < flowerbed.length) {
        int count = 0;
        while(j < flowerbed.length && flowerbed[j] == 0) {
          j++;
          count++;
        }
        if(count != 0) {
          valid += (count + 1) / 2;
        } else {
          j++;
        }
      }
      return valid >= n;
    }
}
