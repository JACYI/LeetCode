package others;

import java.util.HashMap;

public class code172 {
    public static int trailingZeroes(int n) {
        if(n<5) return 0;
        int res = 0;
        for(int i = 5;i<=n;i+=5){
            int temp = i;
            while(temp%5 == 0){
                res++;
                temp/=5;
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(trailingZeroes(30));
    }
}
