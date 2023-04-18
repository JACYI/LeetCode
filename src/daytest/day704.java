package daytest;

public class day704 {
    public static void main(String[] args){

    }
    public static int search(int[] nums, int target){
        int i = 0;
        int j = nums.length - 1;
        if(target < nums[i] || target > nums[j]) return -1;

        int mid = (i+j)/2;
        while (i<=j){
            if(nums[mid]==target) return mid;
            else if(target < nums[mid])
                j = mid;
            else
                i = mid;
            mid = (i+j)/2;
        }
        return -1;
    }
}
