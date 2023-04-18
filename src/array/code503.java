package array;

import java.util.Stack;

public class code503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        if(n==1) return new int[]{-1};
        int[] res = new int[n];
        for(int i=0; i<n; i++)
            res[i] = -1;
        // 存放序号的单调栈，单调递减
        Stack<Integer> stack = new Stack<>();
        // 循环遍历数组
        for(int i=0; i<2*n; i++){
            while(!stack.isEmpty() && nums[i % n] > stack.peek())
                res[stack.pop()] = nums[i % n];
            stack.push(nums[i % n]);
        }
        return res;
    }
}
