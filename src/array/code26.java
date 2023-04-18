package array;

public class code26 {
    public int removeDuplicates(int[] nums) {
        int single = 0, more = 0;
        while(more < nums.length){
            nums[single++] = nums[more++];
            while(more < nums.length && nums[more] == nums[more-1])
                more++;
        }
        return single;
    }
}
