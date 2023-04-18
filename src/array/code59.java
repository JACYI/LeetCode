package array;

import java.util.ArrayList;
import java.util.List;

public class code59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int number = 1;
        int lefter = 0, righter = n, lower = 0, higher = n;
        int sum = n * n;
        int i = 0, j = 0;
        while(number <= sum){
            // 右
            while(number <= sum && j < righter){
                res[i][j++] = number++;
            }
            i++;
            j--;
            lower++;
            // 下
            while(number <= sum && i < higher)
                res[i++][j] = number++;
            j--;
            i--;
            righter--;
            // 左
            while(number <= sum && j >= lefter)
                res[i][j--] = number++;
            j++;
            i--;
            higher--;
            // 上
            while(number <= sum && i >= lower)
                res[i--][j] = number++;
            i++;
            j++;
            lefter++;
        }
        return res;
    }
}
