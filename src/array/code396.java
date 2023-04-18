package array;


public class code396 {
    public static int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int cur = 0;
        int sum = 0;
        for(int i=0; i<n; i++) {
            cur += i * nums[i];
            sum += nums[i];
        }
        int res = cur;
        for(int i=1; i<=n; i++){
            cur += sum - n * nums[n-i];
            res = Math.max(res, cur);
        }
        return res;
    }
    public static void main(String[] args) {
        maxRotateFunction(new int[]{4,3,2,6});
    }
}
