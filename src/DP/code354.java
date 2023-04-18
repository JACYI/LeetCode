package DP;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author yiyonghao
 * @Date 2023/1/29 10:24
 */
public class code354 {
    public int maxEnvelops(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[0] == i2[0] ? Integer.compare(i1[1], i2[1]) : Integer.compare(i1[0], i2[0]);
            }
        });

        int len = envelopes.length;
        int[] dp = new int[envelopes.length];
        int res = 1;

        for(int i=0; i<len; i++) {
            // 找到一个比当前元素较大的最小下一个元素
            // 二分查找优化
            int j = -1;
            if((j = bs(envelopes, envelopes[i])) >= len)
                continue;
            dp[j] = Math.max(dp[j], dp[i] + 1);
            res = Math.max(res, dp[j]);
//            for(int j=i+1; j<len; j++){
//
//                if(envelopes[j][0] > envelopes[i][0] && envelopes[j][1] > envelopes[i][1])
//                    dp[j] = Math.max(dp[j], dp[i] + 1);
//                res = Math.max(res, dp[j]);
//            }
        }

        return res;
    }

    public int bs(int[][] nums, int[] target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid][0] > target[0] && nums[mid][1] > target[1])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}
