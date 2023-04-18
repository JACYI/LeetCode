package array;

import java.util.HashMap;

public class code1 {
    public static void main(String[] args){

    }
    public static int[] twoSum (int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            int key = nums[i];
            if(!map.containsKey(key))
                map.put(target - key, i);
            else
                return new int[]{map.get(key), i};
        }
        return null;
    }
}
