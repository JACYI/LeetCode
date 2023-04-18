package DP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Author yiyonghao
 * @Date 2023/3/23 22:33
 */
public class Code139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        HashSet<String> set = new HashSet<>(wordDict);

        for(int i=0; i<s.length(); i++) {
            for(int j=0; j <= i; j++) {
                dp[i + 1] = set.contains(s.substring(j, i+1)) && dp[j];
                if(dp[i + 1])
                    break;
            }
        }
        return dp[s.length()];
    }
}
