package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yiyonghao
 * @Date 2023/3/23 22:13
 */
public class Code128 {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++)
            map.put(nums[i], i);

        boolean[] visited = new boolean[nums.length];

        int res = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(visited[entry.getValue()])
                continue;

            int temp = 1;
            int curNum = entry.getKey();
            visited[entry.getValue()] = true;
            while(map.containsKey(curNum - 1)) {
                visited[map.get(curNum - 1)] = true;
                temp++;
                curNum--;
            }
            curNum = entry.getKey();
            while(map.containsKey(curNum + 1)) {
                visited[map.get(curNum + 1)] = true;
                temp++;
                curNum++;
            }
            res = Math.max(res, temp);
        }

        return res;
    }
}
