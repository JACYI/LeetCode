package WeekTest;

import java.util.HashMap;

/**
 * @Author yiyonghao
 * @Date 2023/1/16 20:51
 */
public class Test328 {
    public static long countGood(int[] nums, int k) {
        HashMap<Integer, Integer> window = new HashMap<>();
        int res = 0;
        int left = 0, right = 0;
        int sum = 0;// 表示窗口内的满足条件的i和j对数
        while(right < nums.length) {
            int temp = nums[right];
            right++;

            int oldTimes = window.getOrDefault(temp, 0);
            window.put(temp, oldTimes + 1);
            sum += oldTimes;
//            System.out.println(sum);
            while(sum >= k){

                System.out.println(left + "  " + right);
                res++;
                int times = window.get(nums[left]) - 1;
                window.put(nums[left], times);
                sum -= times;
                left++;
            }

        }
        return res;
    }
    public static void main(String[] args) {
        countGood(new int[]{3,1,4,3,2,2,4},2);
    }
}
