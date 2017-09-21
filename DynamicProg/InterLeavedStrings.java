import java.util.*;

public class InterLeavedStrings {
  public static void main(String args[]) {
    String s1 = "aabcc";
    String s2 = "dbbca";
    String s3 = "aadbbbaccc";
    System.out.println(new Solution().isInterleave(s1,s2,s3));
  }
}
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
      int m = s1.length();
      int n = s2.length();
      int total = s3.length();
      if(m + n != total) return false;
      char cs1[] = s1.toCharArray();
      char cs2[] = s2.toCharArray();
      char cs3[] = s3.toCharArray();
      boolean dp[][] = new boolean[m + 1][n + 1];
      dp[0][0] = true;
      for(int i = 1; i <= m; i++) {
        if(cs1[i - 1] == cs3[i - 1]) dp[i][0] = dp[i - 1][0];
      }
      for(int j = 1; j <= n; j++) {
        if(cs2[j - 1] == cs3[j - 1]) dp[0][j] = dp[0][j - 1];
      }
      for(int i = 1; i <= m; i++) {
        for(int j = 1; j <= n; j++) {
          if(cs1[i - 1] == cs3[i + j - 1] && cs2[j - 1] != cs3[i + j - 1]) {
            dp[i][j] = dp[i - 1][j];
          } else if(cs1[i - 1] != cs3[i + j - 1] && cs2[j - 1] == cs3[i + j - 1]) {
            dp[i][j] = dp[i][j - 1];
          } else if(cs1[i - 1] == cs3[i + j - 1] && cs2[j - 1] == cs3[i + j - 1]) {
            dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
          }
        }
      }
      return dp[m][n];
    }
}
