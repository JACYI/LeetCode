package array;

public class code462 {
    public int minMoves2(int[] nums){
        int left=0, right=nums.length-1;
        int mid = 0;
        while(left<=right){
            int n = right;
            mid = left;
            int pivot = nums[mid];
            while(mid<n){
                while(mid < n && nums[n] >= pivot)
                    n--;
                nums[mid] = nums[n];
                while(mid < n && nums[mid] <= pivot)
                    mid++;
                nums[n] = nums[mid];
            }
            nums[mid] = pivot;
            if(mid == nums.length/2)
                break;
            else if(mid < nums.length/2)
                left = mid + 1;
            else
                right = mid;
        }
        int moves = 0;
        for(int num:nums)
            moves += Math.abs(nums[mid] - num);
        return moves;
    }
    public static void main(String[] args) {

    }
}
