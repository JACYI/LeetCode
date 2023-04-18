package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class code230 {
    public int kthSmallest(TreeNode root, int k) {
        int cnt = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(++cnt == k)
                return cur.val;
            cur = cur.right;
        }
        return -1;
    }
}
