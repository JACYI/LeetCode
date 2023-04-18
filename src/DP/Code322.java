package DP;

/**
 * @Author yiyonghao
 * @Date 2023/2/28 22:22
 */
public class Code322 {
    int[] memo;
    public int coinChange(int amount, int[] coins) {
        memo = new int[amount + 1];
        for(int i=1; i<=amount; i++)
            memo[i] = -1;
        return dp(amount, coins);
    }
    // dp(i) 表示凑出i元的最小硬币数
    private int dp(int amount, int[] coins) {
        if(memo[amount] != -1)
            return memo[amount];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if(amount < coin)
                continue;
            int subMin = dp(amount - coin, coins);
            if (subMin == -1)
                // 无解
                continue;
            min = Math.min(min, subMin + 1);
        }
        memo[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[amount];
    }

    public static void main(String[] args) {
        Code322 c = new Code322();
        c.coinChange(27, new int[]{2,5,10,1});
    }
}
