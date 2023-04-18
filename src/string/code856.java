package string;

import java.util.ArrayDeque;
import java.util.Deque;

public class code856 {
    public int scoreOfParentheses(String s) {
        int score = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push(0);
            else{
                int top = stack.pop();
                top = stack.pop() + Math.max(1, top*2);
                stack.push(top);
            }
        }
        return stack.peek();
    }
}
