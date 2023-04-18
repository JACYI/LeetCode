package string;

public class code420 {
    public static int strongPasswordChecker(String password){
        int lower = 0, captital = 0, number = 0;
        char[] passchars = password.toCharArray();
        for(char c:passchars){
            if(c - 'a' < 26 && c - 'a' >= 0)
                lower = 1;
            else if(c - 'A' < 26 && c - 'A' >= 0)
                captital = 1;
            else if(c - '0' < 10 && c - '0' >= 0)
                number = 1;
        }
        int defects = lower + captital + number;
        int len = passchars.length;
        if(len < 6)
            return Math.max(6-len, defects);
        else if(len<=20){
            char pre = ',';
            int seq = 0;
            int res = 0;
            for(char c:passchars){
                if(pre == c)
                    seq++;
                else{
                    res += seq/3;
                    seq = 0;
                    pre = c;
                }
                return Math.max(res, defects);
            }
        }
        else{
            // 长度大于20 分情况讨论，seq%3 == 1, 2, 3 时分别采取什么方式
        }
        return 0;
    }

    public static void main(String[] args){
        System.out.println();
    }
}
