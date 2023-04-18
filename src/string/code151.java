package string;

import java.util.Arrays;

public class code151 {
    private void reverse(char[] chars, int left, int right){
        for(int i=0; i<(right-left)/2; i++){
            char temp = chars[left+i];
            chars[left+i] = chars[right-i-1];
            chars[right-i-1] = temp;
        }
    }
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int idx = s.length()-1;
        while(idx >= 0){
            while(idx >= 0 && s.charAt(idx) == ' ')
                idx--;
            while(idx >= 0 && s.charAt(idx) != ' ')
                stringBuilder.append(s.charAt(idx--));
            stringBuilder.append(' ');
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        char[] chars = stringBuilder.toString().toCharArray();
        int pre = 0;
        for(int i=0; i<=chars.length; i++){
            if(i == chars.length || chars[i] == ' '){
                reverse(chars, pre, i);
                pre = i+1;
            }
        }
        return Arrays.toString(chars);
    }

    public static void main(String[] args) {
        code151 c = new code151();
        c.reverseWords("the sky is blue");
    }
}
