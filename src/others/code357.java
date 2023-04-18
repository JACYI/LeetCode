package others;

public class code357 {
    public static int countNumbersWithUniqueDigits(int n){
        if(n==0) return 0;
        int[] dp = new int[n+1];
        dp[1] = 10;
        int base=9;
        for(int i=2; i<=n; i++){
            base *= (11-i);
            dp[i]= dp[i-1] + base;
        }
        return dp[n];
    }
    public static void main(String[] args){

    }
}
