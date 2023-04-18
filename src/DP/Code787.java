package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * @Author yiyonghao
 * @Date 2023/2/27 22:20
 */
public class Code787 {
    // dst -> [src, dst, price]
    HashMap<Integer, ArrayList<int[]>> map;
    int dst;
    int[][] memo;   // memo[i][j] 表示从src 到 i 在 j 次中转次数限制下的最小价格

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        memo = new int[n][k+2];
        for(int i=0; i<n;i++){
            for (int j=0; j<=k+1; j++) {
                if(i == src)
                    memo[i][j] = 0;
                else
                    memo[i][j] = -1;
            }
        }

        this.dst = dst;
        map = new HashMap<>();
        for(int[] flight : flights){
            if(!map.containsKey(flight[1]))
                map.put(flight[1], new ArrayList<>());
            map.get(flight[1]).add(flight);
        }
        return minPrice(dst, k+1);
    }
    // mid 表示从src到mid节点 在times次中转次数限制下 最小价格
    private int minPrice(int mid, int times) {
        if(times < 0)
            return Integer.MAX_VALUE;
        if(memo[mid][times] != -1)
            return memo[mid][times];

        int res = Integer.MAX_VALUE;
        for(int[] flight : map.getOrDefault(mid, new ArrayList<>())) {
            res = Math.min(res, minPrice(flight[0], times - 1) + flight[2]);
        }
        memo[mid][times] = res;

        return memo[mid][times];
    }

    public static void main(String[] args) {
        Code787 c = new Code787();
        c.findCheapestPrice(3, new int[][]{{0,1,100}, {1,2,100},{0,2,500}}, 0, 2, 1);
    }
}
