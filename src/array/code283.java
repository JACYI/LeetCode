package array;

public class code283 {
    public void moveZeroes(int[] nums) {
        int faster = 0, slower = 0;
        while(faster < nums.length){
            if(nums[faster] != 0){
                nums[slower] = nums[faster];
                slower++;
            }
            faster++;
        }
        for(; slower < nums.length; slower++){
            nums[slower] = 0;
        }
    }
}
