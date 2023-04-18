package interview;

/**
 * @Author yiyonghao
 * @Date 2022/12/26 16:23
 */
public class YMartix2 {


    // 两个大整数,求和
    // num1 = "1234", num2 = "234"
    public static String sum(String num1, String num2) {
        int maxLenth = Math.max(num1.length(), num2.length());
        StringBuilder string = new StringBuilder();
        int carry = 0;

        for(int i=0; i<maxLenth; ++i) {
            int n1 = num1.length() - i <= 0 ? 0 : num1.charAt(num1.length() - i - 1) - '0';
            int n2 = num2.length() - i <= 0 ? 0 : num2.charAt(num2.length() - i - 1) - '0';

            int sum = n1 + n2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            string.append(sum);
        }

        if(carry != 0)
            string.append(carry);

        int i=0, j = string.length() - 1;
        while(i < j){
            char temp = string.charAt(i);
            string.setCharAt(i, string.charAt(j));
            string.setCharAt(j, temp);
            i++;
            j--;
        }
//        StringBuilder res = new StringBuilder();
//        for(int i = string.length() - 1; i>=0; i--)
//            res.append(string.charAt(i));


        for(i=0; i<string.length(); i++){

            if(string.charAt(i) == '0') {
                string.deleteCharAt(i);
            } else {
                break;
            }
        }

        return string.length() == 0 ? "0" : string.toString();
    }

    public static void main(String[] args) {
        int i = 0, j = 0;
        for(; i<=1000; i++) {
            for(; j<=1000; j++){
                try {
                    if(Integer.parseInt(sum(String.valueOf(i), String.valueOf(j))) != i+j)
                        System.out.println(i +" + "+ j + " = " + sum(String.valueOf(i), String.valueOf(j)));

                } catch (Exception e) {
                    System.out.println(i + " " + j);
                }
            }
        }
//        System.out.println("num1: " + num1 + " num2:" + num2);
//        System.out.println(sum(num1, num2));
        // num1 + num2 - num2 == num1
    }
}
