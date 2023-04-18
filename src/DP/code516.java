package DP;

/**
 * @Author yiyonghao
 * @Date 2023/2/20 22:21
 */
public class code516 {
    public int longestPalindromeSubSeq(String s) {
        // dp[i][j]定义为i~j之间的最长回文子序列长度，
        int[][] dp = new int[s.length()][s.length()];
        // 对角线元素初始化为1
        for(int i=0; i<s.length(); i++) {
            dp[i][i] = 1;
        }
        // j >= i
        for(int i=s.length()-1; i>=0; i--){
            for(int j=i+1; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][s.length()-1];
    }
}
