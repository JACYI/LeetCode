package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class code538{
    int prev;
    public void dfs(TreeNode root) {
        if(root == null)
            return;

        dfs(root.right);
        root.val += prev;
        prev = root.val;
        dfs(root.left);

    }
    public TreeNode convertBST(TreeNode root) {
        prev = 0;
        dfs(root);
        return root;
    }
}
