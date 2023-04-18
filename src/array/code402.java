package array;

import java.util.ArrayDeque;
import java.util.Deque;

public class code402 {
    // 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
    public String removeKdigits(String num, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] charArray = num.toCharArray();
//        StringBuffer string = new StringBuffer();
        int delete = 0; // 删除个数
        for (char c : charArray) {
            int curNum = c - '0';
            // 栈空、栈顶元素小于等于curNum、已经删除了k个数
            while (delete < k && !stack.isEmpty() && curNum < stack.peek()) {
                stack.pop();
//                string.deleteCharAt(string.length() - 1);
                delete++;
            }
            stack.push(curNum);
//            string.append(curNum);
        }
        while(delete++ < k)
            stack.pop();
        // stack -> string
        StringBuilder string = new StringBuilder();
        while(!stack.isEmpty())
            string.insert(0, stack.pop());

        int notZero;
        for (int i = 0; i < string.length(); i++)
            if (string.charAt(i) - '0' != 0){
                notZero = i;
                return string.substring(notZero);
            }
        return "0";
    }
}
