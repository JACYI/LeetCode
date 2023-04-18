package array;

public class code327 {
    // 给你一个整数数组 nums 以及两个整数 lower 和 upper 。求数组中，值位于范围 [lower, upper] （包含 lower 和 upper）之内的 区间和的个数 。
    // 转为 前缀和数组 i < j 且 nums[j] - nums[i] 在 lower 和 upper 之间
    private long[] temp;
    private int res;
    int upper, lower;
    private void merge(long[] nums, int lo, int mid, int hi) {
        if(lo >= hi)
            return;
        for(int i=lo; i<=hi; i++)
            temp[i] = nums[i];

        for(int p=lo; p<=mid; p++){
            for(int q=mid+1; q <= hi; q++){
                if(nums[q] - nums[p] >= lower && nums[q] - nums[p] <= upper)
                    res++;
            }
        }

        int left = lo, right = mid + 1;
        for(int i=lo; i<=hi; i++){
            if(left == mid + 1)
                nums[i] = temp[right++];
            else if(right == hi + 1)
                nums[i] = temp[left++];

            else if(temp[left] < temp[right])
                nums[i] = temp[left++];

            else
                nums[i] = temp[right++];
        }
    }
    private void mergeSort(long[] nums, int lo, int hi) {
        if(lo >= hi)
            return;
        int mid = lo + (hi - lo)/2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);

        merge(nums, lo, mid, hi);
    }
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] preSum = new long[nums.length + 1];
        for(int i=0; i<nums.length; i++){
            preSum[i+1]  = preSum[i] + nums[i];
        }
        this.lower = lower;
        this.upper = upper;
        temp = new long[preSum.length];
        res = 0;
        mergeSort(preSum, 0, preSum.length - 1);
        return res;
    }
}
