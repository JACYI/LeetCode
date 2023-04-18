package tree;

import java.util.LinkedList;
import java.util.Queue;

public class code662 {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.offer(root);
        int maxWidth = 0;

        while(!queue.isEmpty()){
            Queue<TreeNode> next = new LinkedList<>();
            int start = queue.peek().val;
            TreeNode cur = null;
            while(!queue.isEmpty()){
                cur = queue.poll();
                if(cur.left != null) {
                    cur.left.val = cur.val * 2;
                    next.offer(cur.left);
                }
                if(cur.right != null) {
                    cur.right.val = cur.val * 2 + 1;
                    next.offer(cur.right);
                }
            }
            int end = cur.val;
            maxWidth = Math.max(maxWidth, end-start+1);
            queue = next;
        }
        return maxWidth;
    }
}
