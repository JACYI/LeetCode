package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author yiyonghao
 * @Date 2023/3/12 15:11
 */
public class Code85 {
    public int maxArea(int[] nums) {
        int len = nums.length;
        int[] leftMin = new int[len], rightMin = new int[len];

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<len; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i])
                stack.pop();
            leftMin[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack = new ArrayDeque<>();
        for(int i = len - 1; i>=0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i])
                stack.pop();
            rightMin[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }
        int maxArea = 0;
        for(int i=0; i<len; i++) {
            maxArea = Math.max(maxArea, nums[i] * (rightMin[i] - leftMin[i] - 1));
        }
        return maxArea;
    }
    public int maximalRectangle(String[][] matrix) {
        int maxRectangle = 0;
        int[] nums = new int[matrix[0].length];

        for(int i=0; i<matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                nums[j] = matrix[i][j] == "0" ? 0 : nums[j] + 1;
            maxRectangle = Math.max(maxRectangle, maxArea(nums));

        }
        return maxRectangle;
    }

    public static void main(String[] args) {
        Code85 c = new Code85();
        c.maximalRectangle(new String[][]{{"1","0","1","0","0"},{"1","0","1","1","1"},{"1","1","1","1","1"}, {"1","0","0","1","0"}});
    }
}
