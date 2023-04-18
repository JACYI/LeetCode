package DP;

import java.util.Arrays;

/**
 * @Author yiyonghao
 * @Date 2023/3/12 15:51
 */
public class Code96 {
    int[] memo;
    private int G(int n) {
        if(memo[n] != -1)
            return memo[n];

        int res = 0;
        for(int i=1; i<=n; i++) {
            res += G(i - 1) * G(n - i);
        }
        memo[n] = res;

        return memo[n];
    }
    public int numTrees(int n) {
        // G(n) 表示n个连续不重复自然数构成不同BST的树的数量
        // G(n) = i=(1..n) G(i - 1) * G(n - i)
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        memo[1] = 1;
        return G(n);
    }
}
