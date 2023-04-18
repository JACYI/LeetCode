package array;

import java.util.Stack;

public class code682 {
    public static int calPoints(String[] ops){
        Stack<Integer> stack = new Stack<>();
        int last1=0, last2=0;
        for(String op:ops){
            if(op.equals("+")) {
                last2 = stack.pop();
                last1 = stack.peek();
                last2 = last1 + last2;
                last1 = last2 - last1;
                stack.push(last1);
                stack.push(last2);
            }
            else if(op.equals("C")){
                stack.pop();
            }
            else if(op.equals("D")){
                stack.push(stack.peek() * 2);
            }
            else{
                stack.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum+= stack.pop();
        }
        return sum;
    }
    public static void main(String[] args){
        String[] strs = new String[]{"5","2","C","D","+"};
        System.out.println(calPoints(strs));
    }
}
