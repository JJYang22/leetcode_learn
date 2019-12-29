package DynamicProgramming;

/**
 * @Author Voidmian
 * @Date 2019/12/26 12:59
 */
public class CoinChange322 {
    public static void main(String[] args) {
        CoinChange322 coinChange322 = new CoinChange322();
        int[] coins = {2};
        System.out.println(coinChange322.coinChange(coins,11));
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i;
            boolean isRight = true;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    if(dp[i - coins[j]] != -1) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                        isRight = false;
                    }
                }
            }
            if (isRight) {
                dp[i] = -1;
            }
        }
        return dp[amount];
    }
}
