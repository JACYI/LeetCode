package string;

import tree.TreeNode;

import java.util.HashMap;

public class code567 {
    public boolean checkInclusion(String s1, String s2){
        HashMap<Character, Integer> map2 = new HashMap<>(), map1 = new HashMap<>();
        for(char c:s1.toCharArray())
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        int valid = 0;
        int left = 0, right = 0;
        while(right < s2.length()){
            char c = s2.charAt(right);
            right++;

            map2.put(c, map2.getOrDefault(c, 0)+1);
            if(map2.get(c).equals(map1.getOrDefault(c, 0)))
                valid++;
            if(right - left < s1.length())
                continue;

            else if(right - left > s1.length()){
                c = s2.charAt(left);
                left++;
                if(map2.get(c).equals(map1.getOrDefault(c, 0)))
                    valid--;
                map2.put(c, map2.get(c) - 1);
            }
            if(valid == map1.size())
                return true;
        }
        return false;
    }
}
