import java.util.*;
public class MinWindowSubString {
  public static void main(String args[]) {
    String s = "b";
    String t = "b";
    System.out.println(new Solution().minWindow(s,t));
  }
}
class Solution {
    public String minWindow(String s, String t) {
      int tmap[] = new int[256];
      int smap[] = new int[256];
      int minLength = Integer.MAX_VALUE;
      for(int i = 0; i < t.length(); i++) {
        tmap[t.charAt(i)]++;
      }
      char sa[] = s.toCharArray();
      int i = 0;
      int j = 0;
      int min_i = 0;
      int min_j = 0;
      while(j < s.length()) {
        smap[sa[j]]++;
        if(isValid(tmap, smap)) break;
        j++;
      }
      if(j >= s.length()) return "";
      if(isValid(tmap, smap)) {
        i = optimizeWindow(tmap, smap, i, sa);
        if(minLength > j - i + 1) {
          min_i = i;
          min_j = j;
          minLength = j - i + 1;
        }
      }
      while(j + 1 < s.length()) {
        smap[sa[++j]]++;
        smap[sa[i++]]--;
        if(isValid(tmap, smap)) {
          i = optimizeWindow(tmap, smap, i, sa);
          if(minLength > j - i + 1) {
            min_i = i;
            min_j = j;
            minLength = j - i + 1;
          }
        }
      }
      if(isValid(tmap, smap)) {
        i = optimizeWindow(tmap, smap, i, sa);
        if(minLength > j - i + 1) {
          min_i = i;
          min_j = j;
          minLength = j - i + 1;
        }
      }
      return s.substring(min_i, min_j + 1);
    }

    private boolean isValid(int tmap[], int smap[]) {
      for(int i = 0; i < tmap.length; i++) {
        if(tmap[i] != 0 && tmap[i] > smap[i]) return false;
      }
      return true;
    }

    private int optimizeWindow(int tmap[], int smap[], int i, char sa[]) {
      while(isValid(tmap, smap)) {
        smap[sa[i++]]--;
      }
      i--;
      smap[sa[i]]++;
      return i;
    }
}
/*
- First I find the base window which will cover the substring t. Then I optimize it. So we get the first window
- Then I find a window of the same length and try optimizing it in the hope of finding a smaller window.
- If I find a smaller window, I update the pointers accordingly. 
*/
