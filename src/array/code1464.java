package array;

import java.util.Arrays;

public class code1464 {
    public void quickSort(int[] nums, int left, int right){
        if(left >= right) return;
        int pivot = nums[left];
        int i = left, j = right;
        while(i < j){
            while(i < j && nums[j] >= pivot)
                j--;
            nums[i] = nums[j];
            while(i < j && nums[i] <= pivot)
                i++;
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        quickSort(nums, left, i-1);
        quickSort(nums, i+1, right);
    }
    public int maxProduct(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        int len = nums.length;
        return (nums[len-1]-1)*(nums[len-2]-1);
    }
    public static void main(String[] args){
        code1464 a = new code1464();
        int res = a.maxProduct(new int[]{1,2,1,3,1,1});
        System.out.println(res);
    }
}
