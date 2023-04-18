package array;

public class code713 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int right=0;
        long mul = 1;
        for(right=0; right<nums.length; right++) {
            int left = 0;
            mul *= nums[right];
            while (mul >= k && left <= right)
                mul /= nums[left++];
            res += right - left + 1;
        }
        return res;
    }
    public static void main(String[] args) {
        int res = numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100);
    }
}
