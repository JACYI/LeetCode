package array;

public class code27 {
    public int removeElement(int[] nums, int val) {
        int single = 0, more = 0;
        while(more < nums.length){
            while(more < nums.length && nums[more] == val)
                more++;
            if(more == nums.length)
                break;
            nums[single++] = nums[more++];
        }
        return single;
    }

}
