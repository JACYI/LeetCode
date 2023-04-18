package others;

import java.util.*;

public class code15 {
    public static void main(String[] args){
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(1);
        System.out.println(set1.equals(set2));
    }
    public static List<List<Integer>> threeSum(int[] nums){
        if(nums.length < 3) return null;
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length; i++){
//            map.put()
        }
        return null;
    }

}
