package DP;

/**
 * @Author yiyonghao
 * @Date 2023/2/26 16:18
 */
public class Code518 {
    public int change(int amount, int[] coins) {
        // dp[i][j] 表示前i个硬币装总量为j的物品，恰好能装满的方案数
        int[][] dp = new int[coins.length + 1][amount + 1];

        // dp[i][0] 初始化均为1
        for(int i=0; i<=coins.length; i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i<=coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if(j >= coins[i - 1])
                    // 重点，加入第i枚硬币时，是dp[i]而不是dp[i-1]
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[coins.length][amount];

    }
    // 压缩空间
    public int change2(int amount, int[] coins) {
        // dp[i][j] 表示前i个硬币装总量为j的物品，恰好能装满的方案数
        int[] dp = new int[amount + 1];

        // dp[i][0] 初始化均为1
        dp[0] = 1;

        for(int i=1; i<=coins.length; i++) {
            int[] temp = new int[amount + 1];
            // 初始化
            temp[0] = 1;
            for (int j = 1; j <= amount; j++) {
                if(j >= coins[i - 1])
                    // 重点，加入第i枚硬币时，是dp[i]而不是dp[i-1]
                    temp[j] = dp[j] + temp[j - coins[i - 1]];
                else
                    temp[j] = dp[j];
            }
            dp = temp;
        }
        return dp[amount];
    }
}
