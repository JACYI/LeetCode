package others;

import java.util.HashSet;
import java.util.PriorityQueue;

public class interview_17_09 {
    public static int getKthMagicNumber(int k) {
        int[] dp = new int[k+1];
        dp[0] = 1;
        int index1, index2, index3;
        index1 = index2 = index3 = 0;
        for(int i=1; i<=k; i++){
            dp[i] = Math.min(Math.min(dp[index1]*3, dp[index2]*5), dp[index3]*7);
            if(dp[index1]*3 == dp[i]) index1++;
            if(dp[index2]*5 == dp[i]) index2++;
            if(dp[index3]*7 == dp[i]) index3++;
        }
        return dp[k-1];
    }
    public static void main(String[] args){
        getKthMagicNumber(8);
    }
}
