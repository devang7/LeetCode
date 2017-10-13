import java.util.*;
public class PaintHouse {
  public static void main(String args[]) {
    int costs[][] = new int[][]{{2,3,4},{1,2,4},{1,1,2}};
    System.out.println(new Solution().minCost(costs));
  }
}
class Solution {
    public int minCost(int[][] costs) {
      if(costs == null || costs.length <= 0) return 0;
      int n = costs.length;
      int dp[][] = new int[n][3];
      for(int i = 0; i < 3; i++) {
        dp[0][i] = costs[0][i];
      }
      for(int i = 1; i < n; i++) {
        dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
        dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
        dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
      }
      return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }
}
