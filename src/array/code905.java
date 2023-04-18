package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code905 {
    public static int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left<right){
            while(left<right && nums[left] % 2 == 0)
                left++;
            while(left<right && nums[right] % 2 != 0)
                right--;
            if(left == right) break;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
    public static void main(String[] args) {
        sortArrayByParity(new int[]{3,1,2,4});
    }
}
