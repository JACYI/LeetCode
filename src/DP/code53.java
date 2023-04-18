package DP;

/**
 * @Author yiyonghao
 * @Date 2023/1/30 21:58
 */
public class code53 {
    public int maxSubArray(int[] nums) {
        // 滑动窗口
//        int left = 0, right = 0;
//        int sum = 0, max = nums[0];
//        while(right < nums.length) {
//            sum += nums[right];
//            right++;
//            // 更新结果时机！重要
//            max = Math.max(max, sum);
//            while(left < right && sum < 0){
//                sum -= nums[left++];
//            }
//        }
//        return max;
        // 动态规划方法
        int dp_pre = nums[0];
        int max = nums[0];
        for(int i=1; i<nums.length; i++){
            if(dp_pre < 0)
                dp_pre = nums[i];
            else
                dp_pre += nums[i];
            max = Math.max(max, dp_pre);
        }
        return max;
    }
}
