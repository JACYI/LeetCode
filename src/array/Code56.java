package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author yiyonghao
 * @Date 2023/3/9 23:05
 */
public class Code56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] nums1, int[] nums2){
                return nums1[0] - nums2[0];
            }
        });
        int idx = 0;
        for (int[] interval : intervals) {
            if (res.size() == 0) {
                res.add(interval);
                continue;
            }
            int[] temp = res.get(idx);
            if (temp[0] == interval[0] || interval[0] <= temp[1])
                res.get(idx)[1] = Math.max(temp[1], interval[1]);
            else {
                res.add(interval);
                idx++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
