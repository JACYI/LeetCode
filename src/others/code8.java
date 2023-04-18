package others;

public class code8 {
    public static void main(String[] args){
        System.out.println(myAtoi("6346391283472332"));
    }
    public static int myAtoi(String s) {
        int p = 0;
        while(p<s.length() && s.charAt(p) == ' '){
            p++;
        }
        if(p == s.length())
            return 0;
        boolean flag = true;
        if(s.charAt(p) == '+' || s.charAt(p) == '-'){
            flag = s.charAt(p) == '+';
            p++;
        }
        int temp = 0;
        long res = 0;
        int q = p;
        while(q < s.length()){
            temp = s.charAt(q)-'0';
            if(temp <0 || temp > 9)
                break;
            res = res * 10 + temp;
            if(res > Integer.MAX_VALUE)
                break;
            q++;
        }
        if(!flag)
            res = -res;
        if(res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else
            return (int)res;
    }
}
