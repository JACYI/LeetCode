package string;

import java.util.HashMap;

public class code953 {
    static HashMap<Character, Integer> map;
    public static boolean compare(String a, String b) {
        for(int i=0; i<a.length(); i++){
            int _a = map.get(a.charAt(i));
            int _b = i<b.length() ? map.get(b.charAt(i)) : -1;
            if(_a > _b)
                return false;
            else if(_a < _b)
                return true;
        }
        return true;
    }
    public static boolean isAlienSorted(String[] words, String order) {
        map  = new HashMap<>();
        for(int i = 0; i<order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for(int i = 0; i<words.length-1; i++){
            if(!compare(words[i], words[i+1]))
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        isAlienSorted(null, null);
    }
}
