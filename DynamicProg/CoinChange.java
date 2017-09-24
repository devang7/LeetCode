import java.util.*;

public class CoinChange {
  public static void main(String args[]) {
    int coins[] = new int[]{186,419,83,408};
    int amount = 6249;
    System.out.println(new Solution().coinChange(coins, amount));
  }
}
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length <= 0) return 0;
        Arrays.sort(coins);
        int dp[][] = new int[coins.length][amount + 1];
        for(int i = 0; i < coins.length; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        for(int i = 1; i <= amount; i++) {
            if(i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            }
        }
        for (int i = 0; i < coins.length; i++) {
          dp[i][0] = 0;
        }
        for(int i = 1; i < coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j - coins[i] >= 0 && dp[i][j - coins[i]] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - coins[i]]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[coins.length - 1][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length - 1][amount];
    }
}
