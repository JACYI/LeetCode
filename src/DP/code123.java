package DP;

/**
 * @Author yiyonghao
 * @Date 2023/2/25 16:01
 */
public class code123 {
    public int maxProfit(int[] prices) {
        // dp[i][j][k]表示在第i天最多完成j笔交易的前提下，手中有k支股票，的最大利润
        int[][][] dp = new int[prices.length + 1][3][2];
        // 第0天不可能持有股票
        dp[0][1][1] = dp[0][2][1] = Integer.MIN_VALUE;
        for(int i=0; i<prices.length; i++) {
            // 任意一天不可交易无法持有股票
            dp[i + 1][0][1] = Integer.MIN_VALUE;
        }

        for(int i=0; i<prices.length; i++) {
            dp[i + 1][1][0] = Math.max(dp[i][1][1] + prices[i], dp[i][1][0]);
            dp[i + 1][1][1] = Math.max(dp[i][0][0] - prices[i], dp[i][1][1]);
            dp[i + 1][2][0] = Math.max(dp[i][2][1] + prices[i], dp[i][2][0]);
            dp[i + 1][2][1] = Math.max(dp[i][1][0] - prices[i], dp[i][2][1]);
        }
        return dp[prices.length][2][0];
    }
}
