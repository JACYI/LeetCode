package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class code870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Integer[] idxs1 = new Integer[nums1.length];
        Integer[] idxs2 = new Integer[nums2.length];
        for(int i=0; i<nums1.length; i++){
            idxs1[i] = i;
            idxs2[i] = i;
        }
        Arrays.sort(idxs1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums1[o1] - nums1[o2];
            }
        });
        Arrays.sort(idxs2, Comparator.comparingInt(o -> nums2[o]));
        int p1 = 0;
        int p2 = 0;
        for(int i=0; i<idxs1.length; i++){
            if(nums1[idxs1[p1]] > nums2[idxs2[p2]]) {
                p1++;
                p2++;
                continue;
            }

        }
        return null;
    }
}
