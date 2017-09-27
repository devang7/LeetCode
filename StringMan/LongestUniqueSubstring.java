import java.util.*;
public class LongestUniqueSubstring {
  public static void main(String args[]) {
    String s = "abcdbas";
    System.out.println(new Solution().lengthOfLongestSubstring(s));
  }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count[] = new int[256];
        Arrays.fill(count, -1);
        int i = 0;
        int j = 0;
        int maxLen = 0;
        char a[] = s.toCharArray();
        while(j < a.length) {
            if(count[a[j]] == -1) {
                count[a[j]] = j;
                j++;
                maxLen = Math.max(maxLen, j - i);
            } else {
                int index = count[a[j]];
                while(i <= index) {
                    count[a[i]] = -1;
                    i++;
                }
            }
        }
        return maxLen;
    }
}
/*
=> Sliding Window Concept for tracking Unique Characters in the window;
=> Record the last visited index, when we see a duplicate character, take the window till the unique char.
=> Don't forget to unmark those characters.
=> O(n)
*/
