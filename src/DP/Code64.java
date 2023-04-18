package DP;

/**
 * @Author yiyonghao
 * @Date 2023/2/26 19:59
 */
public class Code64 {
    int[][] memo;
    int[][] grid;
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // memo[i][j] 表示由i, j 为起点走到右下角的最小路径和，初始化为-1
        memo = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                memo[i][j] = -1;
            }
        }
        memo[m - 1][n - 1] = grid[m - 1][n - 1];
        this.grid = grid;
        return dp(0, 0);
    }

    private int dp(int i, int j) {
        int m = grid.length, n = grid[0].length;
        if(i < 0 || i >= m)
            return Integer.MAX_VALUE;
        if(j < 0 || j >= n)
            return Integer.MAX_VALUE;


        if(memo[i][j] != -1)
            return memo[i][j];

        memo[i][j] = grid[i][j] + Math.min(
                // 往下走
                dp(i + 1, j),
                // 往右走
                dp(i, j + 1));
        return memo[i][j];
    }

    public static void main(String[] args) {
        Code64 c = new Code64();
        c.minPathSum(new int[][] {
                {1,3,1}, {1,5,1}, {4,2,1}
        });
    }
}
