package WeekTest.Week338;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yiyonghao
 * @Date 2023/3/26 12:18
 */
public class Test3 {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int len = nums.length;
        int[] sortedNums = new int[len];
        System.arraycopy(nums, 0, sortedNums, 0, len);

        Arrays.sort(sortedNums);
        long[] preSum = new long[len + 1];

        for(int i=1; i<len + 1; i++) {
            preSum[i] = preSum[i - 1] + sortedNums[i - 1];
        }
        List<Long> res = new ArrayList<>();
        for(int i=0; i<queries.length; i++) {
            int idx = bs(sortedNums, queries[i]);
            if(idx == 0 && sortedNums[idx] > queries[i]){
                res.add(preSum[len] - ((long) queries[i]) * len);
            } else if(idx == len - 1 && sortedNums[idx] < queries[i]) {
                res.add(((long)queries[i]) * len - preSum[len]);
            } else {
                long temp = 0;
                temp += preSum[len] - preSum[idx] - ((long)queries[i]) * (len - idx);
                temp += ((long)queries[i]) * idx - preSum[idx] - preSum[0];
                res.add(temp);
            }
        }


        return res;
    }
    private int bs(int[] nums, int target) {
        int left = 0, right = nums.length;

        while(left < right) {
            int mid = left + (right - left)/2;

            if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        Test3 t = new Test3();
        t.minOperations(new int[]{1,1,2,2}, new int[]{1,2});
    }
}
