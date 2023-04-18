package array;

public class QuickSort {
    public static void quickSort(int[] nums, int left, int right) {
        if(left>=right) return;
        int i=left, j=right;
        int pivot = nums[left];
        while(i<j){
            while(i<j && nums[j] >= pivot)
                j--;
            nums[i] = nums[j];
            while(i<j && nums[i]<=pivot)
                i++;
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        quickSort(nums, left, i-1);
        quickSort(nums, i+1, right);
    }
    public static void main(String[] args) {
        int[] a = new int[]{4,2,-1,0,2,5};
        quickSort(a, 0, a.length-1);
        for(int i:a)
            System.out.println(i);
    }
}
