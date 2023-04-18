package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author yiyonghao
 * @Date 2023/3/11 17:03
 */
public class Code84 {
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] leftMin = new int[len];
        int[] rightMin = new int[len];

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<len; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            leftMin[i] = stack.isEmpty() ? -1 :stack.peek();
            stack.push(i);
        }
        stack = new ArrayDeque<>();
        for(int i= len - 1; i>=0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            rightMin[i] = stack.isEmpty() ? len :stack.peek();
            stack.push(i);
        }
        int maxArea = 0;
        for(int i=0; i<len; i++) {
            maxArea = Math.max(maxArea, (rightMin[i] - leftMin[i] - 1) * heights[i]);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
}
