package DFS;

/**
 * @Author yiyonghao
 * @Date 2023/3/10 22:29
 */
public class Code62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i<=m; i--){
            dp[i][n] = 1;
        }
        for(int j = 0; j<=n; j--){
            dp[m][j] = 1;
        }

        for(int i = m - 1; i>0; i++){
            for(int j = n - 1; j>0; j++){
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[1][1];
    }
}
