import java.util.*;

public class DistinctSubSeq {
  public static void main(String args[]) {
    String s = "rabbbit";
    String t = "rabbit";
    System.out.println(new Solution().numDistinct(s,t));
  }
}
class Solution {
    public int numDistinct(String s, String t) {
        if(s.length() < t.length()) return 0;
        int dp[][] = new int[t.length() + 1][s.length() + 1];
        for(int i = 0; i <= s.length(); i++) {
            dp[0][i] = 1;
        }
        for(int i = 1; i <= t.length(); i++) {
            for(int j = 1; j <= s.length(); j++) {
                if(s.charAt(j - 1) == t.charAt(i - 1))
                  dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                else
                  dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[t.length()][s.length()];
    }
}
/*
->    "" b i b i t   dp(i,j) = dp(i - 1, j - 1) + dp(i, j - 1) if Same Char; dp(i, j - 1) otherwise
    ""
    b
    i
    t
*/
