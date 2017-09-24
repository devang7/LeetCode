import java.util.*;

public class CoinChange2 {
  public static void main(String args[]) {
    int coins[] = new int[]{1,2,5};
    int amount = 5;
    System.out.println(new Solution().coinChange2(coins, amount));
  }
}
class Solution {
    public int coinChange2(int[] coins, int amount) {
        if(amount == 0) return 1;     //IMP
        if(coins == null || amount < 0 || coins.length <= 0) return 0;
        Arrays.sort(coins);
        int dp[][] = new int[coins.length][amount + 1];
        for(int i = 1; i <= amount; i++) {
            if(i % coins[0] == 0) {
                dp[0][i] = 1;
            }
        }
        for(int i = 0; i < coins.length; i++) {
          dp[i][0] = 1;
        }
        for(int i = 1; i < coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j - coins[i] >= 0) {
                    dp[i][j] = dp[i][j] + dp[i][j - coins[i]];
                }
            }
        }
        return dp[coins.length - 1][amount];
    }
}

/*
=> Here, we need the number of ways to make the amount.
=> Important to remember null set is also equal = 1 solution.
*/
