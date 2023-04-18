package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yiyonghao
 * @Date 2023/3/11 16:18
 */
public class Code78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for(int num : nums) {
            List<List<Integer>> cur = new ArrayList<>();
            for(List<Integer> list : res) {
                List<Integer> temp = new ArrayList<>(list);
                temp.add(num);
                cur.add(temp);
            }
            res.addAll(cur);
        }
        return res;
    }
}
