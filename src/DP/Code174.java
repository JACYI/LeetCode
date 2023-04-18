package DP;

/**
 * @Author yiyonghao
 * @Date 2023/2/26 20:40
 */
public class Code174 {
    int[][] grid;
    int[][] memo;
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        memo = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                memo[i][j] = -1;
            }
        }
        // 初始化
        memo[m - 1][n - 1] = dungeon[m - 1][n - 1] > 0 ? 1 : -dungeon[m - 1][n - 1] + 1;

        grid = dungeon;
        return dp(0, 0);
    }

    // dp(i, j)表示从i，j出发到公主的所需最小HP
    private int dp(int i, int j) {
        int m = grid.length, n = grid[0].length;
        if(i >= m || j >= n)
            return Integer.MAX_VALUE;

        if(memo[i][j] != -1)
            return memo[i][j];

        int minHP = Math.min(dp(i, j + 1),dp(i + 1, j));
        if(minHP - grid[i][j] <= 0)
            memo[i][j] = 1;
        else
            memo[i][j] = minHP - grid[i][j];

        return memo[i][j];
    }

    public static void main(String[] args) {
        Code174 c = new Code174();
        c.calculateMinimumHP(new int[][] {
                {-2, -3, 3},{-5, -10, 1},{10, 30, -5}
        });
    }
}
