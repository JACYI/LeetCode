package array;

import java.util.Arrays;

public class code698 {
    public boolean backtrack(int[] nums, int index, int[] bucket, int k, int target) {
        // 递归结束条件
        if(index == nums.length){
//            for(int i=0; i<k; i++) {
//                if (bucket[i] != target)
//                    return false;
//            }
            return true;
        }

        for(int i=0; i<k; i++){
            // 剪枝
            // 重复集合
            if(i>0 && bucket[i] == bucket[i-1])
                continue;
            // 超过目标值
            if(bucket[i] + nums[index] > target){
                continue;
            }
            // 第index个数放到第i个集合
            bucket[i] += nums[index];
            if(backtrack(nums, index+1, bucket, k, target)) return true;
            // 不符合题意，拿出
            bucket[i] -= nums[index];
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num:nums)
            sum += num;
        if(sum % k != 0) return false;
        Arrays.sort(nums);
        for(int i=0; i<nums.length/2; i++){
            int temp = nums[i];
            nums[i] = nums[nums.length-i-1];
            nums[nums.length-i-1] = temp;
        }
        sum /= k;
        if(nums[0] > sum) return false;
        int[] bucket = new int[k];
        return backtrack(nums, 0, bucket, k, sum);
    }
}
