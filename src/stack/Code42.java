package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author yiyonghao
 * @Date 2023/3/2 17:56
 */
public class Code42 {
    public static int trap(int[] height) {
        // 栈保存墙的高度的下标
        Deque<Integer> stack = new ArrayDeque<>();
        int cal = 0;

        for(int i=0; i<height.length; i++){
            while(!stack.isEmpty() && height[stack.peek()] <= height[i]){
                int h = height[stack.pop()];
                if(stack.isEmpty())
                    break;
                int w = i - stack.peek() - 1;
                int l = Math.min(height[stack.peek()], height[i]) - h;
                cal += w * l;
            }
            stack.push(i);
        }
        return cal;
    }

    public static void main(String[] args) {
        trap(new int[]{3,1,2,1,1,0,3});
    }
}
