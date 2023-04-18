package string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

public class code316 {
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        HashMap<Character, Integer> map = new HashMap<>();  // 记录每个字母出现的次数
        char[] chars = s.toCharArray();
        for(char c:chars)
            map.put(c, map.getOrDefault(c, 0)+1);
        HashSet<Character> set = new HashSet<>();   // 保证当前栈的元素不重复

        // 遍历，对于遇到的字符，如果次数等于1，不可以舍弃;
        // 如果大于1，且字典序小于前一个字符，且前一个字符次数大于1
        for(char c:chars){
            // 已经包含该字符，直接丢弃
            if(!set.contains(c)) {
                // 当字典序小于前一个字符，并且前一个字符并不是最后出现的，那么删除前一个字符（acb ... c -> ab ... c）
                while (!stack.isEmpty() && c - stack.peek() < 0 && map.get(stack.peek()) > 1) {
                    char del = stack.pop();
                    map.put(del, map.get(del) - 1);
                    set.remove(del);
                }

                stack.push(c);
                set.add(c);
            } else
                map.put(c, map.get(c) - 1);
        }

        StringBuffer string = new StringBuffer();
        while(!stack.isEmpty())
            string.insert(0, stack.pop());

        return string.toString();
    }
}
