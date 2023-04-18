package string;

import java.util.HashMap;

public class code1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();  // 也可以使用int[] alphabet = new int[26]优化
        char[] chars = s.toCharArray();
        int maxLength = -1;
        for(int i=0; i<chars.length; i++){
            if(!map.containsKey(chars[i]))
                 map.put(chars[i], i);
            else
                maxLength = Math.max(maxLength, i-map.get(chars[i])-1);
        }
        return maxLength;
    }
}
