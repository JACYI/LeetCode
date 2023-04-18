package string;

public class code467 {
    public int findSubstringInWraproundString(String p){
        int[] dp = new int[26];
        dp[p.charAt(0)-'a'] = 1;
        int max_k = 1;
        for(int i = 1; i<p.length(); i++){
            max_k = p.charAt(i) - p.charAt(i-1) == 1 ? max_k+1 : 1;
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i)-'a'],max_k);
        }
        int ret = 0;
        for(int num:dp)
            ret += num;
        return ret;
    }
    public static void main(String[] args){

    }
}
