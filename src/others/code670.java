package others;

public class code670 {
    public int nums2num(int[] nums) {
        int mul = 1;
        int res = 0;
        for(int num:nums){
            res += num * mul;
            mul *= 10;
        }
        return res;
    }
    public int[] swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        return nums;
    }
    public int maximumSwap(int num) {
        if(num <= 11 || num == 100000000) return num;
        int[] nums = new int[8];
        int temp = num;
        int i = 0;
        while(temp != 0) {
            nums[i++] = temp % 10;
            temp /= 10;
        }
        for(i--; i>0; i--) {
            for(int j=i-1; j>=0; j--){
                swap(nums, i, j);
                num = Math.max(num, nums2num(nums));
                swap(nums, j, i);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(10e8);
    }
}
