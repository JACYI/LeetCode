package array;

import java.util.Arrays;

public class code1608 {
    public int spectialArray(int[] nums) {
        Arrays.sort(nums);
        // 考虑特殊情况，最小数大于数组长度
        if(nums[0] >= nums.length) return nums.length;
        //
        for(int x=1; x<nums.length; x++)
            // 尾部有x个大于等于x的数
            if(nums[nums.length-x-1] < x && nums[nums.length-x] >= x)
                return x;
        return -1;
    }
}
