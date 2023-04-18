package string;

import java.util.Arrays;
import java.util.HashSet;

public class code824 {
    public static String toGoatLatin(String sentence) {
        StringBuilder res = new StringBuilder();
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        StringBuilder tails = new StringBuilder("a");
        String tail2 = null;
        char[] chars = sentence.toCharArray();
        for(int i=0; i<sentence.length(); i++){
            if(vowels.contains(chars[i]))
                // 是元音
                tail2 = "ma";
            else
                tail2 = chars[i++] + "ma";

            while(i<chars.length && chars[i] != ' ')
                res.append(chars[i++]);
            res.append(tail2);
            res.append(tails);
            if (i!=chars.length)
                res.append(" ");
            tails.append("a");
        }
        return res.toString();
    }
    public static void main(String[] args) {

    }
}
