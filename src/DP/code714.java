package DP;

/**
 * @Author yiyonghao
 * @Date 2023/2/25 15:56
 */
public class code714 {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length + 1][2];
        // 第0天不可能持有股票
        dp[0][1] = Integer.MIN_VALUE;

        for(int i=0; i<prices.length; i++) {
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[i + 1][1] = Math.max(dp[i][1], dp[i][0] - prices[i] - fee);
        }

        return dp[prices.length][0];
    }
}
