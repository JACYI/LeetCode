package string;

import java.util.HashSet;

public class code804 {
    public static int uniqueMorseRepresentations(String[] words){
        String[] transforms = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for(String word:words){
            StringBuffer s = new StringBuffer();
            for(char c:word.toCharArray())
                s.append(transforms[c-'a']);
            set.add(s.toString());
        }
        return set.size();
    }
    public static void main(String[] args){
//        uniqueMorseRepresentations(null);
    }
}
