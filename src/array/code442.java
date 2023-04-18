package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class code442 {
    public static List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> res = new HashSet<>();
        int point = 0;
        while(point < nums.length){
            while(point < nums.length &&nums[point] == point + 1)
                point++;
            if(point == nums.length) break;
            if(nums[nums[point]-1] == nums[point]) {
                res.add(nums[point]);
                point++;
            }
            else {
                int temp = nums[nums[point] - 1];
                nums[nums[point] - 1] = nums[point];
                nums[point] = temp;
            }
        }
        return new ArrayList<>(res);
    }
    public static void main(String[] args) {
        List a = findDuplicates(new int[]{4,3,2,7,8,2,3,1});
    }
}
