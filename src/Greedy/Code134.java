package Greedy;

import java.util.Arrays;

/**
 * @Author yiyonghao
 * @Date 2023/3/13 21:30
 */
public class Code134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum())
            return -1;
        int[] res = new int[gas.length];

        for(int i=0; i<gas.length; i++) {
            res[i] = gas[i] - cost[i];
        }
        int begin = 0;
        int curGas = 0;
        for(int i = 0; i<gas.length; i++) {
            curGas += res[i];
            if(curGas < 0) {
                begin = (i + 1) % gas.length;
                curGas = 0;
            }
        }
        return begin;
    }
}
