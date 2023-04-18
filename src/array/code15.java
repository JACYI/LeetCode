package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class code15 {
    public void twoSum(int[] nums, List<List<Integer>> res, int left, int right, int target, int value) {
        while(left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                List<Integer> arr = new ArrayList<>();
                arr.add(nums[left]);
                arr.add(nums[right]);
                arr.add(value);
                res.add(arr);
                // 消除重复元素组合
                while(right > left && nums[left] == nums[left+1])
                    left++;
                left++;
                while(right > left && nums[right] == nums[right-1])
                    right--;
                right--;
            } else if (sum > target) {
                // 尾指针向前移动减小和
                right--;
            } else{
                // 头指针向后移动增加和
                left++;
            }
        }
    }
    public  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
//        QuickSort.quickSort(nums, 0, nums.length-1);

        for(int i=0; i<nums.length-1; i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            twoSum(nums, res, i+1, nums.length-1, -nums[i], nums[i]);
        }
        return res;
    }
    public static void test(int i){
        i += 1;
    }
    public static void main(String[] args) {
        int a = 1;
        test(a);
        System.out.println(a);
    }
}
