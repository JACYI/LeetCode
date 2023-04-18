package string;

public class code5 {
    public static void main(String[] args){

    }
    public String palindrome(String s, int i, int j){
        while(i >= 0 && j <= s.length()-1){
            if(s.charAt(i) != s.charAt(j))
                return s.substring(i+1, j);
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }
    public String longestPalindrome2(String s) {
        if(s.length() < 2) return s;
        String res = "";
        // 双指针解法
        for(int i=0; i<s.length()-2; i++){
            String res1 = palindrome(s, i, i+1);
            if(res1.length() > res.length())
                res = res1;
            String res2 = palindrome(s, i, i);
            if(res2.length() > res.length())
                res = res2;
        }
        return res;
    }

    public String longestPalindrome(String s){
        int len = s.length();
        if(len == 0) return "";
        char[] c = s.toCharArray();
        boolean[][] dp = new boolean[len][len];

        int start = 0,end = 0;

        for(int a = 1; a<len; a++){
            for(int i = 0; i<len-a; i++) {
                int j = a + i;
                if (c[j] == c[i])
                    if (j - i < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
                else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && j - i > end - start){
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end+1);
    }
}
