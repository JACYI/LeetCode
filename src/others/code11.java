package others;

public class code11 {
    public static void main(String[] args){
        System.out.println(intToRoman(1994));
    }
    public static String intToRoman(int num){
        int[] roman = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] romans = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};

        StringBuffer res = new StringBuffer();
        int p = roman.length -1;
        while(num != 0){
            if(num < roman[p]) {
                p--;
                continue;
            }
            res.append(romans[p]);
            num -= roman[p];
        }

        return res.toString();
    }
}
