package string;

import java.nio.charset.StandardCharsets;

public class code6 {
    public static void main(String[] args){
        System.out.println(convert("PAYPALISHIRING", 1));
    }
    public static String convert(String s, int numRows) {
        if(numRows <= 1) return s;

        StringBuilder[] strings = new StringBuilder[numRows];
        for(int j = 0; j<numRows; j++){
            strings[j] = new StringBuilder();
        }
        int i = 0;
        int count = 0;

        while(count < s.length()){
            // "Z"由上到下
            while(i < numRows && count < s.length()){
                strings[i++].append(s.charAt(count++));
            }
            i--;
            // “Z”由下到上
            while(i > 0 && count < s.length()){
                strings[--i].append(s.charAt(count++));
            }
            i++;
        }
        // 合并
        StringBuilder res = new StringBuilder();
        for(i = 0; i< numRows; i++)
            res.append(strings[i]);
        return res.toString();
    }
}
