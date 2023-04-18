package array;

public class code215 {
    // 调整从start到end的根顺序
    private static void adjustHeap(int[] nums, int start, int end) {
        int temp = nums[start];

        for(int k = 2*start + 1; k < end; k= k*2+1){
            if(k + 1 < end && nums[k] < nums[k+1]){
                k++;
            }
            if(nums[k] > temp){
                nums[start] = nums[k];
                start = k;
            } else {
                break;
            }
        }
        nums[start] = temp;
    }
    private static int HeapSort(int[] nums, int k) {
        int n = nums.length;
        for(int i= nums.length/2; i>=0; i--){
            adjustHeap(nums, i, n);
        }
        for(int j = n - 1; j>=n - k; --j){
            int temp = nums[j];
            nums[j] = nums[0];
            nums[0] = temp;
            adjustHeap(nums, 0, j);
        }

        return nums[0];
    }


    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int i = 0;
        while(left<=right) {
            i = left;
            int j = right;
            int pivot = nums[i];
            while (i < j) {
                while (j > i && nums[j] <= pivot)
                    j--;
                nums[i] = nums[j];
                while (i < j && nums[i] >= pivot)
                    i++;
                nums[j] = nums[i];
            }
            nums[i] = pivot;
            if (i == k-1)
                break;
            else if (i<k-1)
                left = i+1;
            else
                right = i;
        }
        return nums[i];
//        int res = 0;
//        for(int j=0; j<nums.length; j++){
//            res += Math.abs(nums[i] - nums[j]);
//        }
//        return res;
    }
    public static void main(String[] args) {
        code215 c = new code215();
//        System.out.println(c.findKthLargest(new int[]{2,1}, 2));
        HeapSort(new int[]{3,1,6,7,2,5,4}, 7);

    }
}
