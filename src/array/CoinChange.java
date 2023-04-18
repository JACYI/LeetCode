package array;

public class CoinChange {
    public static void main(String[] args){
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }
    private static int[] dp;
    public static int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        return change(coins, amount);
    }
    public static int change(int[] coins, int amount){
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(dp[amount] != 0) return dp[amount];

        int res = Integer.MAX_VALUE;
        for(int coin:coins){
            if(amount - coin < 0) continue;
            res = Math.min(res, change(coins, amount-coin) + 1);
        }
        dp[amount] = res;
        return res;
    }
}