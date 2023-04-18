package array;

import java.util.Arrays;

public class code1672 {
    public static int maximumWealth(int[][] accounts) {
        int res = 0;
        for (int[] account : accounts) res = Math.max(res, Arrays.stream(account).sum());
        return res;
    }
    public static void main(String[] args) {

    }
}
