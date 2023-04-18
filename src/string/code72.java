package string;

import java.util.Arrays;

/**
 * @Author yiyonghao
 * @Date 2023/1/29 9:52
 */
public class code72 {
    int[][] memo;   // 备忘录
    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for(int i=0; i<word1.length(); i++) {
            for(int j=0; j<word2.length(); j++)
                memo[i][j] = -1;
        }
        return dp(word1, word2, word1.length()-1, word2.length()-1);
    }

    // 求解s1前i+1位与s2前j+1位的编辑距离
    public int dp(String s1, String s2, int i, int j) {
        if(i < 0 || j < 0)
            return i < 0 ? j+1 : i+1;

        if(memo[i][j] != -1)
            return memo[i][j];

        if(s1.charAt(i) == s2.charAt(j))
            memo[i][j] = dp(s1, s2, i-1, j-1);
        else {
            memo[i][j] = Math.min(
                    dp(s1, s2, i, j-1) + 1, // 插入
                    Math.min(dp(s1, s2, i-1, j) + 1,    // 删除
                    dp(s1, s2, i-1, j-1) + 1));        // 替换
        }
        return memo[i][j];
    }
}
