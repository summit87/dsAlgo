package dp;

import java.util.ArrayList;
import java.util.List;

/** condition : We can select same coin more than one time */
public class CoinChangeProblem {
  public static void main(String[] args) {
    int[] coins = { 1, 2, 5, 7, 3, 6, 9 };
    int sum = 10;
    // System.out.println(coinChange(coins, sum, coins.length));
    // coinChangeUsingDP(coins,sum);
    coinChangeInON(sum, coins);
  }

  /**
   * recursion
   *
   * @param coins
   * @param sum
   * @param length
   * @return
   */
  private static int coinChange(int[] coins, int sum, int length) {
    if (length == 0 || sum < 0)
      return 0;
    if (sum == 0)
      return 1;

    return coinChange(coins, sum - coins[length - 1], length) + coinChange(coins, sum, length - 1);
  }

  private static void coinChangeUsingDP(int[] coins, int sum) {
    int[][] dp = new int[sum + 1][coins.length + 1];
    List<Integer> list = new ArrayList<>();
    System.out.println(coinChangeDP(coins, sum, dp, coins.length));
  }

  private static int coinChangeDP(int[] coin, int sum, int[][] dp, int length) {
    if (length <= 0 || sum < 0) {
      return 0;
    }
    if (dp[sum][length] != 0) {
      return dp[sum][length];
    }
    if (sum == 0) {
      dp[sum][length] = 1;
      return dp[sum][length];
    }
    dp[sum][length] = coinChangeDP(coin, sum - coin[length - 1], dp, length)
        + coinChangeDP(coin, sum, dp, length - 1);
    return dp[sum][length];
  }

  private static void coinChangeInON(int sum, int[] coin) {
    int[] dp = new int[sum + 1];
    dp[0] = 1;
    for (int i = 0; i < coin.length; i++) {
      for (int j = coin[i]; j <= sum; j++) {
        /**
         * dp[j-coin[i]] : this will tell us we are picking the coin and , how may time
         * we are picking , this will tell us by inner loop
         */
        dp[j] = dp[j] + dp[j - coin[i]];
      }
    }
    System.out.println(dp[sum]);
  }
}
