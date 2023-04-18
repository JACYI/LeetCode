package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class code2215 {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2){
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums1)
            set.add(num);
        List<Integer> nums = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int num:nums2){
            if(set.contains(num))
                set.remove(num);
            else
                nums.add(num);
        }
        res.add(nums);
        nums = null;
        nums = new ArrayList<>();
        for(int num:set)
            nums.add(num);
        res.add(nums);
        return res;
    }
    public static void main(String[] args){

    }
}
