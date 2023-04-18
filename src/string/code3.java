package string;

import java.util.HashMap;
import java.util.HashSet;

public class code3 {
    public static void main(String[] args){
        lengthOfLongestSubstring2("tmmzuxt");
    }
    public static int lengthOfLongestSubstring2(String s) {
        int left = 0, right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            map.put(c, map.getOrDefault(c, 0) + 1);

            while(map.get(c) > 1){
                char temp = s.charAt(left);
                left++;
                map.put(temp, map.getOrDefault(temp, 0) - 1);
            }
            maxLength = Math.max(maxLength, right-left);
        }
        return maxLength;
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        char[] chars = s.toCharArray();
        int pre = 0; //窗口包含 pre
        int cur = 0; //窗口包括 cur
        int res = 1;
        HashSet<Character> set = new HashSet<>();
        for(pre = 0; pre < chars.length; pre++){
            if(!set.contains(chars[pre]))
                set.add(chars[pre]);
            else{
                while(chars[cur] != chars[pre])
                    set.remove(chars[cur++]);
                set.remove(cur++);
            }
            res = Math.max(res, pre-cur+1);
        }
        return res;
    }
}
