package DP;

/**
 * @Author yiyonghao
 * @Date 2023/2/19 20:52
 */
public class code1143 {
    int[][] memory;
    public int longestCommonSubsequence(String text1, String text2) {
        memory = new int[text1.length()][text2.length()];
        return dp(text1, 0, text2, 0);
    }
    // dp 函数表示text1第i到最后一位与text2第j位到最后一位的最长公共子序列
    private int dp(String text1, int i, String text2, int j) {
        if(i == text1.length() || j == text2.length())
            return 0;
        if(memory[i][j] != 0)
            return memory[i][j];

        if(text1.charAt(i) == text2.charAt(j)){
            memory[i][j] =  1 + dp(text1, i+1, text2, j+1);
        } else {
            memory[i][j] = Math.max(dp(text1, i+1, text2, j), dp(text1, i, text2, j+1));
        }
        return memory[i][j];
    }

    public static void main(String[] args) {

    }
}
