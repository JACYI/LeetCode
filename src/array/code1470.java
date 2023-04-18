package array;

public class code1470 {
    // 原地修改
    public int[] shuffle2(int[] nums, int n) {
        for(int i = 0; i<n; i++){
            nums[2*i] |= (nums[i]&0x3FF)<<10;
            nums[2*i+1] |= (nums[n+i]&0x3FF)<<10;
        }
        for(int i =0; i<nums.length;i++)
            nums[i] >>= 10;
        return nums;
    }
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        for(int i = 0; i<n; i++){
            res[2*i] |= nums[i];
            res[2*i+1] = nums[n+i];
        }
        return res;
    }
    public static void main(String[] args) {
        int b = 1023;
        code1470 a = new code1470();
        a.shuffle2(new int[]{1,2,3,4,5,6,7,8}, 4);
    }
}
