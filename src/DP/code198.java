package DP;

public class code198 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+2];


        for(int i=0; i<n; i++){
            dp[i+2] = Math.max(dp[i+1], dp[i] + nums[i]);
        }
        return dp[n+1];

    }
}
