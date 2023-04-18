package DP;

/**
 * @Author yiyonghao
 * @Date 2023/2/26 16:48
 */
public class Code494 {
    public int findTargetSumWays(int[] nums, int target) {
        // sum(+) - sum(-) = target
        // sum(+) + sum(-) = sum(nums)
        // sum(+) = (sum(nums) + target) / 2
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if((sum + target)%2 != 0 || sum + target < 0)
            return 0;
        return splitSubset(nums, (sum + target)/2);
    }

    // 找出nums中的若干数字和为target的方案数
    private int splitSubset(int[] nums, int target) {
        int[] dp = new int[target + 1];
        // 初始化
        dp[0] = 1;

        for(int i=1; i<=nums.length; i++){
            for(int j=target; j>=0; j--){
                if(j >= nums[i - 1])
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
                else
                    dp[j] = dp[j];
            }
        }
        return dp[target];
    }
}
