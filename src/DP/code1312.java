package DP;

/**
 * @Author yiyonghao
 * @Date 2023/2/21 22:44
 */
public class code1312 {
    public int minInsertions(String s) {
        // dp[i][j] 表示 i ~ j 变成回文串的最少修改次数
        int[][] dp = new int[s.length()][s.length()];

        for(int i=s.length()-1; i>=0; i--){
            for(int j=i+1; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1];
                else
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][s.length()-1];
    }
}
