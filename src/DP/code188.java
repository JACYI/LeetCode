package DP;

/**
 * @Author yiyonghao
 * @Date 2023/2/23 21:48
 */
public class code188 {
    public int maxProfit(int k, int[] prices) {
        // dp[i][j][k]表示在第i天，最多交易k的情况下，持有k支股票的最大收益
        int[][][] dp = new int[prices.length + 1][k+1][2];

        // 初始化
        for(int i=0; i<prices.length+1; i++) {
            // 0次交易限制不能持有股票
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for(int j=0; j<=k; j++)
            // 第0天无法持有股票
            dp[0][j][1] = Integer.MIN_VALUE;

        for(int i=0; i<prices.length; i++) {
            for(int j = k; j>=1; j--) {
                dp[i + 1][j][0] = Math.max(dp[i][j][0], dp[i][j][1] + prices[i]);
                dp[i + 1][j][1] = Math.max(dp[i][j][1], dp[i][j-1][0] - prices[i]);
            }
        }
        return dp[prices.length][k][0];
    }
}
