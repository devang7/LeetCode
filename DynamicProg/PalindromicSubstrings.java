import java.util.*;
public class PalindromicSubstrings {
  public static void main(String args[]) {
    String s = "abbba";
    System.out.println(new Solution().countSubstrings(s));
  }
}
class Solution {
    public int countSubstrings(String s) {
      int n = s.length();
      char a[] = s.toCharArray();
      boolean isPalindrom[][] = new boolean[n][n];
      long dp[][] = new long[n][n];
      for(int i = 0; i < n; i++) {
        isPalindrom[i][i] = true;
        dp[i][i] = 1;
      }
      for(int i = 0, j = 1; j < n; i++, j++) {
        dp[i][j] = 2;
        if(a[i] == a[j]) {
          isPalindrom[i][j] = true;
          dp[i][j] += 1;
        }
      }
      for(int k = 2; k < n; k++) {
        for(int i = 0, j = k; j < n; i++, j++) {
          if(a[i] == a[j] && isPalindrom[i + 1][j - 1]) {
            dp[i][j] = 1;
            isPalindrom[i][j] = true;
          }
          dp[i][j] += dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
        }
      }
      return (int)dp[0][n - 1];
    }
}

/*
My solution is similar to Longest Palindromic substring.
-Instead of storing max of dp[i][j-1], dp[i+1][j] we store the count in each substrings.
-But remember to subtract the overlapping substring counts.
-O(n^2)
*/
