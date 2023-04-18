package DP;

public class code213 {
    public int rob2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        // 对0->n-2打劫
        for(int i=0; i<n-1; i++){
            dp[i+2] = Math.max(dp[i+1], dp[i] + nums[i%n]);
        }
        int first = dp[n];
        for(int i=1; i<n; i++){
            dp[i+2] = Math.max(dp[i+1], dp[i] + nums[i%n]);
        }
        int second = dp[n+1];
        return Math.max(first, second);
    }
}
