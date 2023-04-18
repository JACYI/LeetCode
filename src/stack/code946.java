package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class code946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int push = 0, pop = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while(push < pushed.length){
            stack.push(pushed[push++]);
            while(!stack.isEmpty() && stack.peek() == popped[pop]) {
                stack.pop();
                pop++;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        code946 code = new code946();
        System.out.println(code.validateStackSequences(null, null));;
    }
}
