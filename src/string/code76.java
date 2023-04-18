package string;

import java.util.HashMap;

public class code76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> windows = new HashMap<>(), needs = new HashMap<>();
        for(char c:t.toCharArray()){
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        String res = new String(s);
        // 窗口两边，左闭右开
        int left = 0, right = 0;
        // 记录满足要求的字符数
        int valid = 0;
        while(right < s.length()){
            // 找到可行解
            char c= s.charAt(right);
            right++;
            if(needs.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if(windows.get(c).equals(needs.get(c)))
                    valid++;
            }
            // 如果可行，找最优解，并在临界位置破坏可行性
            while(valid == needs.keySet().size()){
                if(right - left < res.length())
                    res = s.substring(left, right);

                c = s.charAt(left);
                left++;
                if(needs.containsKey(c)){
                    if(needs.get(c).equals(windows.getOrDefault(c, 0)))
                        valid--;
                    windows.put(c, windows.get(c));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        code76 c = new code76();
        c.minWindow("a", "aa");
    }
}
