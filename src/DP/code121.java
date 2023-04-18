package DP;

/**
 * @Author yiyonghao
 * @Date 2023/2/23 22:07
 */
public class code121 {
    public int maxProfit(int[] prices) {
        // dp[i][j][k] 表示在第i天，最大交易次数限制为k的前提下，拥有k支股票的时候，最大的利润
        int[][] dp = new int[prices.length + 1][2];
        // 初始化
        dp[0][1] = Integer.MIN_VALUE;

        for(int i=0; i<prices.length; i++){
            // 第i+1天
            // 今天卖股票或者（无股票）不操作
            dp[i+1][0] = Math.max(dp[i][1] + prices[i], dp[i][0]);

            // 今天买股票或者（有股票）不操作
            dp[i+1][1] = Math.max(-prices[i], dp[i][1]);
        }
        return dp[prices.length][0];
    }

    public static void main(String[] args) {
        code121 c = new code121();
        c.maxProfit(new int[]{7,1,5,3,6,4});
    }
}
