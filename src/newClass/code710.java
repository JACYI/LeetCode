package newClass;

import java.util.HashMap;
import java.util.Random;

public class code710 {
    class Solution {
        int[] blacklist;
        HashMap<Integer, Integer> map;
        int bound;   // 大于等于bound是黑名单
        Random random;

        public Solution(int n, int[] blacklist) {
            random = new Random();
            map = new HashMap<>();
            bound = n - blacklist.length;
            for(int black:blacklist)
                map.put(black, 1);  // 表示black在黑名单中
            // 将黑名单放到最后
            int last = n-1;
            for(int i=0; i<blacklist.length; i++) {
                if(blacklist[i] >= bound)
                    // 已经在黑名单中
                    continue;
                while(map.containsKey(last)) {
                    last--;
                }
                // 将黑名单的数字与bound后的白名单交换 { 序号: 数字 }
                map.put(blacklist[i], last);
                last--;
            }
        }
        public int pick() {
            int rand = random.nextInt(bound);
            if(map.containsKey(rand) && map.get(rand) != -1)
                return map.get(rand);
            return rand;
        }
    }
}

