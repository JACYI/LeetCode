package DP;

/**
 * @Author yiyonghao
 * @Date 2023/2/24 22:17
 */
public class code309 {
    public int maxProfix(int[] prices) {
        // k为无限制
        int[][] dp = new int[prices.length + 1][2];
        // 第0天，没有开始交易，不可能有1支股票
        dp[0][1] = Integer.MIN_VALUE;
        // 第1天不可能卖出

        for(int i=0; i<prices.length; i++) {
            if (i == 0) {
                dp[i + 1][0] = 0;
                dp[i + 1][1] = -prices[i];
            } else {
                // 卖出需要前两天买入
                dp[i + 1][0] = Math.max(dp[i][1] + prices[i], dp[i][0]);
                dp[i + 1][1] = Math.max(dp[i - 1][0] - prices[i], dp[i][1]);
            }
        }
        return dp[prices.length][0];
    }
}
