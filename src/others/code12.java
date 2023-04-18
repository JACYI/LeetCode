package others;

public class code12 {
    public static void main(String[] args){
        System.out.println(romanToInt("IV"));
    }
    public static int romanToInt(String s){
        if(s.length() <= 1) return value(s.charAt(0));

        int res = 0;
        int pre = value(s.charAt(0));
        int i = 1;
        while(i<s.length()){
            int temp = value(s.charAt(i));
            if(temp <= pre)
                res += pre;
            else
                res -= pre;
            pre = temp;
            i++;
        }
        return res + pre;
    }
    private static int value(char c){
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
