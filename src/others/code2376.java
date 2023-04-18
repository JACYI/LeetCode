package others;

public class code2376 {
    String number;
    public int numDP(int i, boolean isLimit, boolean isNum){
        if(i == number.length()){
            return 1;
        }
        int res = 0;
        // 不填数字或者填0
        int max = isLimit ? Integer.parseInt(number.substring(i, i+1)) : 9;
        for(int num=0; num<=max; num++){
            boolean limit = false;
            if(num == max)
                limit = true;
            res += numDP(i+1, isLimit && limit, isNum || (num != 0));
        }
        return res;
    }
    public int countSpecialNumbers(int n) {
        number = Integer.toString(n);
        return numDP(0, true, false);
    }
}
