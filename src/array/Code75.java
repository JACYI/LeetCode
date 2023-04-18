package array;

/**
 * @Author yiyonghao
 * @Date 2023/3/10 22:54
 */
public class Code75 {
    public void sortColors(int[] nums) {
        int point0 = 0;
        int point1 = 0;

        int cur = 0;
        while(cur < nums.length) {
            if(nums[cur] == 2) {
                cur++;
            } else if(nums[cur] == 1){
                int temp = nums[point1];
                nums[point1] = nums[cur];
                nums[cur] = temp;
                point1++;
            } else {
                int temp = nums[point0];
                nums[point0] = nums[cur];
                nums[cur] = temp;
                if(point0 < point1){
                    // 有1
                    temp = nums[point1];
                    nums[point1] = nums[cur];
                    nums[cur] = temp;
                }
                point0++;
                point1++;
            }
        }
    }
}
