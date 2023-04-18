package array;

public class code439 {
    private int[] temp;
    private int res;
    private void merge(int[] nums, int lo, int mid, int hi) {
        if(lo >= hi)
            return;
        // System.out.println("low: "+ lo + " high: " + hi);
        for(int i=lo; i<=hi; i++){
            temp[i] = nums[i];
            // System.out.print(nums[i] + " ");
        }
        // // 计算反转对
        // for(int i = lo; i<=mid; i++){
        //     for(int j=mid+1; j<=hi;j++){
        //         if((long)temp[i] > (long)temp[j] * 2)
        //             res++;
        //     }
        // }
        int p = lo, q = mid + 1;
        while(p <= mid) {
            while(q <= hi && (long)nums[p] > 2 * (long)nums[q])
                q++;
            res += q - mid - 1;
            p++;
        }
        // System.out.println(" res: "+ res);
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
    private void mergeSort(int[] nums, int lo, int hi) {
        if(lo >= hi)
            return;
        int mid = lo + (hi - lo)/2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);

        merge(nums, lo, mid, hi);
    }
    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        res = 0;
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }
}
