package string;

import java.util.Stack;

public class code388 {
    public static int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        if(lines.length == 1) return input.contains(".")?input.length():0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (String line : lines) {
            int depth = 0;
            while (line.charAt(depth) == '\t')
                depth++;
            while (depth < stack.size())
                stack.pop();
            int stackLast = stack.size()==0 ? 0 : stack.peek();
            int curLen = stackLast + line.length() - depth;
            if (line.contains(".")){
                // 是文件
                res = Math.max(curLen, res);
            }
            else{
                // 是目录
                stack.push(curLen+1);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(lengthLongestPath("a\n\tb1\n\t\tf1.txt\n\taaaaa\n\t\tf2.txt"));;
    }
}
