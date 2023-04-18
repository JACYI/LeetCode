package DP;

/**
 * @Author yiyonghao
 * @Date 2023/2/23 22:46
 */
public class code122 {
    public int maxProfit(int[] prices) {
//        int[][] dp = new int[prices.length + 1][2];
//        for(int i=0; i<=prices.length; i++)
//            dp[i][1] = Integer.MIN_VALUE;
//        // 未优化
//        for(int i=0; i<prices.length; i++) {
//            dp[i+1][1] = Math.max(dp[i][0] - prices[i], dp[i][1]);
//            dp[i+1][0] = Math.max(dp[i][1] + prices[i], dp[i][0]);
//        }
        // 优化版本，由于当前关系只跟前一个关系有关，因此可以仅记录前一个的 dp[1] 和 dp[0]
        int pre_1 = Integer.MIN_VALUE, pre_0 = 0;
        for (int price : prices) {
            int cur_1 = Math.max(pre_0 - price, pre_1);
            int cur_0 = Math.max(pre_1 + price, pre_0);
            pre_0 = cur_0;
            pre_1 = cur_1;
        }
        return pre_0;

//        return dp[prices.length][0];
    }
}
