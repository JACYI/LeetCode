package others;

public class code788 {
    String number;
    int[] legals = new int[]{0, 1, 2, 5, 6, 8, 9};
    public int numDP(int i, boolean isDiff, boolean isLimit) {
        if(i == number.length())
            return isDiff ? 1 : 0;

        int res = 0;

        int up = 0;
        if(isLimit)
            up = Integer.parseInt(number.substring(i, i+1));
        else
            up = 9;
        // 依次填入不同数字
        // num=0表示不填数字，num > 0 表示填数字
        for(int num:legals){
            if(num > up) break;
            boolean diff;
            if(num == 0 || num == 1 || num == 8)
                diff = false;
            else
                diff = true;
            res += numDP(i+1, isDiff || diff, isLimit && (up == num));
        }
        return res;
    }
    public int rotatedDigits(int n) {
        number = Integer.toString(n);
        return numDP(0, false, true);
    }

    public static void main(String[] args) {
        code788 c = new code788();
        c.rotatedDigits(10);
    }
}
