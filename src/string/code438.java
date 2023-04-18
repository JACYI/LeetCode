package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class code438 {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        // 窗口的左右边界，左闭右开
        int left = 0, right = 0;
        HashMap<Character, Integer> needs = new HashMap<>(), windows = new HashMap<>();
        int valid = 0;
        for(char c:p.toCharArray())
            needs.put(c, needs.getOrDefault(c, 0)+1);

        while(right < s.length()){
            // 窗口扩增
            char c = s.charAt(right);
            right++;
            if(needs.containsKey(c)){
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if(windows.get(c).equals(needs.get(c)))
                    valid++;
            }
            while(right - left >= p.length()) {
                if (valid == needs.size())
                    // 保存
                    res.add(left);
                // 窗口缩小
                c = s.charAt(left);
                left++;

                if (needs.containsKey(c)) {
                    if (windows.getOrDefault(c, 0).equals(needs.get(c)))
                        valid--;
                    windows.put(c, windows.get(c) - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        code438 c = new code438();
        c.findAnagrams("abcabc", "abc");
    }
}
