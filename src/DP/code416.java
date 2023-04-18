package DP;

/**
 * @Author yiyonghao
 * @Date 2023/2/25 21:04
 */
public class code416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;    // 记录总和
        for(int num:nums)
            sum += num;
        if(sum % 2 == 1)
            return false;

        // dp[i][j] 表示前i个数是否能够得到和为j的子集
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        // 初始化条件，和为0肯定能够实现，即空集
        for(int i=0; i<=nums.length; i++)
            dp[i][0] = true;

        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<sum; j++) {
                if(j + 1 - nums[i] < 0){
                    // 无法装入，不取第i个数
                    dp[i + 1][j + 1] = dp[i][j + 1];
                } else {
                    // 不取第i个数 与 取第i个数
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i][j + 1 - nums[i]];
                }

            }
        }

        return dp[nums.length][sum/2];
    }
    // 优化空间
    public boolean canPartition2(int[] nums) {
        int sum = 0;    // 记录总和
        for(int num:nums)
            sum += num;
        if(sum % 2 == 1)
            return false;

        // dp记录前一行的状态（i）
        boolean[] dp = new boolean[sum+1];
        // 初始化条件，和为0肯定能够实现，即空集
        dp[0] = true;

        for (int num : nums) {
            // temp 记录本行状态
            boolean[] temp = new boolean[sum + 1];
            for (int j = 0; j < sum; j++) {
                if (j + 1 - num < 0) {
                    // 无法装入，不取第i个数
                    temp[j + 1] = dp[j + 1];
                } else {
                    // 不取第i个数 与 取第i个数
                    temp[j + 1] = dp[j + 1] || dp[j + 1 - num];
                }
            }
            dp = temp;
        }

        return dp[sum/2];
    }

    public static void main(String[] args) {
        code416 c = new code416();
        c.canPartition(new int[]{1,5,10,6});
    }
}
