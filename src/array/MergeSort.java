package array;

public class MergeSort {
    public static void mergeSort(int[] nums, int left, int right){
        if(left>=right) return;
        int mid = (left+right)/2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        merge(nums, left, mid, right);
    }
    private static void merge(int[] nums, int left, int mid, int right){
        int i = left;
        int j = mid + 1;
        int[] temp = new int[right-left+1];
        int k = 0;
        while(i<=mid && j<=right && k<temp.length){
            if(nums[i] <= nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }
        while(i<=mid){
            temp[k++] = nums[i++];
        }
        while(j<=right){
            temp[k++] = nums[j++];
        }
        for(k=0;k<temp.length;k++){
            nums[left+k] = temp[k];
        }
    }
    public static void main(String[] args){
//        int[] a = {45,854,42,4, 0,12, 8, 3};
        int[] a = {};
        mergeSort(a,0,a.length-1);
        for(int s:a){
            System.out.println(s);
        }
    }
}
