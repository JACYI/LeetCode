package array;

import java.util.ArrayList;
import java.util.List;

public class code54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i = 0, j = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int lefter = 0, righter = col, lower = 0, higher = row;
        int sum = col * row;
        List<Integer> res = new ArrayList<>();
        while(res.size() < sum){
            // 右
            while(res.size() < sum && j < righter){
                res.add(matrix[i][j++]);
            }
            i++;
            j--;
            lower++;
            // 下
            while(res.size() < sum && i < higher)
                res.add(matrix[i++][j]);
            j--;
            i--;
            righter--;
            // 左
            while(res.size() < sum && j >= lefter)
                res.add(matrix[i][j--]);
            j++;
            i--;
            higher--;
            // 上
            while(res.size() < sum && i >= lower)
                res.add(matrix[i--][j]);
            i++;
            j++;
            lefter++;
        }
        return res;
    }
}
