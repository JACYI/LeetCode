package newClass;

class NumArray {
    private int[] numSums;
    public NumArray(int[] nums) {
        numSums = new int[nums.length+1];
        for(int i=0; i<nums.length; i++){
            numSums[i+1] = nums[i] + numSums[i];
        }
    }

    public int sumRange(int left, int right) {
        return numSums[right+1]-numSums[left];
    }
}

public class code303 {
    public static void main(String[] args) {

    }
}
