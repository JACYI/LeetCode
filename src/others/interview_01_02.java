package others;

import java.util.HashMap;

public class interview_01_02 {
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s1.length(); i++)
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0)+1);
        for(int i=0; i<s2.length(); i++){
            char temp = s2.charAt(i);
            if(!map.containsKey(temp)) return false;
            if(map.get(temp) == 0) return false;
            map.put(temp, map.get(temp)-1);
        }
        return true;
    }
}
