package array;

import java.util.HashSet;

public class code961 {
    public int repeatedNtimes(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            if(set.contains(num)) return num;
            set.add(num);
        }
        return -1;
    }
    public static void main(String[] args){

    }
}
