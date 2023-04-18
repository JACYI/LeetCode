package array;

class NumArray {
    private int[] treemax;
    private int[] nums;
    public int lowbit(int i){
        return i & (-i);
    }
    public NumArray(int[] nums) {
        treemax = new int[nums.length+1];
        this.nums = nums;
        for(int right=1;right<=nums.length;right++){
            for(int left=right-lowbit(right);left<right;left++){
                treemax[right] += nums[left];
            }
        }
    }

    public void update(int index, int val) {
        int add = val - nums[index] ;
        nums[index] = val;
        for(index+=1; index<treemax.length; index+=lowbit(index)){
            treemax[index] += add;
        }
    }
    public int preFix(int number){
        int sum = 0;
        while(number>0){
            sum += treemax[number];
            number -= lowbit(number);
        }
        return sum;
    }
    public int sumRange(int left, int right) {
        int sum1 = 0, sum2 = 0;
        return preFix(right+1) - preFix(left);
    }
}

public class code307 {
    public static void main(String[] args){
        NumArray numArray = new NumArray(new int[]{1,3,5});
        numArray.update(1,2);
    }
}
