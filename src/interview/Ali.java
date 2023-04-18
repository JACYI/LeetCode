package interview;

import java.util.HashMap;

/**
 * @Author yiyonghao
 * @Date 2023/3/18 22:29
 */
public class Ali {
    public int count(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0));
        return 0;
    }
}
