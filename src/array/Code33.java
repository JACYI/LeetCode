package array;

/**
 * @Author yiyonghao
 * @Date 2023/3/2 16:00
 */
public class Code33 {
    public static int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i <= j){
            int mid = i + (j - i)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[i] > nums[mid]) {
                // mid -> j 有序
                if(target > nums[mid] && target <= nums[j])
                    i = mid + 1;
                else
                    j = mid - 1;
            } else {
                // i -> mid 有序
                if(target >= nums[i] && target < nums[mid])
                    j = mid - 1;
                else
                    i = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        search(new int[]{4,5,6,7,0,1,2}, 0);
    }
}
