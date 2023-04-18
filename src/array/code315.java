package array;

import java.util.ArrayList;
import java.util.List;

public class code315 {
    private static class Pair {
        private final int val;
        private final int id;

        public Pair(int val, int id) {
            this.val = val;
            this.id = id;
        }
    }
    private Pair[] temp;
    private int[] count;

    private void merge(Pair[] nums, int lo, int mid, int hi) {
        if(lo >= hi)
            return;
        for(int i=lo; i<=hi; i++)
            temp[i] = nums[i];

        int left = lo, right = mid + 1;
        for(int i=lo; i<=hi; i++){
            if(left == mid + 1)
                nums[i] = temp[right++];
            else if(right == hi + 1) {
                count[temp[left].id] += right - mid - 1;
                nums[i] = temp[left++];
            }
            else if(temp[left].val <= temp[right].val) {
                count[temp[left].id] += right - mid - 1;
                nums[i] = temp[left++];
            }
            else
                nums[i] = temp[right++];
        }
    }

    public void mergeSort(Pair[] nums, int lo, int hi) {
        if(lo >= hi)
            return;
        int mid = lo + (hi - lo)/2;

        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);


        merge(nums, lo, mid, hi);
    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        temp = new Pair[n];
        count = new int[n];
        Pair[] pairs = new Pair[n];
        for(int i=0; i<n; i++)
            pairs[i] = new Pair(nums[i], i);
        mergeSort(pairs, 0, n-1);
        List<Integer> res = new ArrayList<>();
        for(int num: count)
            res.add(num);
        return res;
    }
}
