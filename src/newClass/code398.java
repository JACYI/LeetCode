package newClass;


import java.util.*;

class SolutionC {
    private HashMap<Integer, ArrayList<Integer>> storage;
    private Random random;
    public SolutionC(int[] nums) {
        storage = new HashMap<>();
        random = new Random();
        for(int i=0; i<nums.length; i++){
            if(!storage.containsKey(nums[i])){
                ArrayList<Integer> newList = new ArrayList<>(Arrays.asList(i));
                storage.put(nums[i], newList);
            }
            else {
                storage.get(nums[i]).add(i);
            }
        }
    }
    public int pick(int target) {
        List<Integer> cur = storage.get(target);
        return cur.get(random.nextInt(cur.size()));
    }
}

class Solution {
    private Random random;
    private int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    public int pick(int target){
        int res = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target) {
                count++;
                if(random.nextInt(count) == 0)
                    res = i;
            }
        }
        return res;
    }
}

public class code398 {
    public static void main(String[] args) {
        Solution s = new Solution(new int[]{1,2,3,3,3});
        s.pick(3);
    }
}
