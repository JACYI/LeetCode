package tree;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class code687 {
    int max_len = 0;
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int res = 0;
        int leftLen = root.left != null? dfs(root.left) : 0;
        int rightLen = root.right != null? dfs(root.right) : 0;
//        if(root.right != null){
//            int rightLen = dfs(root.right);
//            if(root.right.val == root.val)
//                res +=rightLen + 1;
//            max_len = Math.max(max_len, res);
//        }
        int leftFinal = 0;
        int rightFinal = 0;
        if(root.left != null && root.left.val == root.val) {
            leftFinal = leftLen + 1;
            res += leftLen + 1;
        }
        if(root.right != null && root.right.val == root.val) {
            rightFinal = rightLen + 1;
            res += rightLen + 1;
        }
        max_len = Math.max(max_len, res);
        res = Math.max(leftFinal, leftFinal);
        return res;
    }
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return max_len;
    }
    public static void main(String[] args) {
        code687 c = new code687();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4, new TreeNode(1), new TreeNode(1));
        root.right = new TreeNode(5, new TreeNode(4), new TreeNode(5));
        c.longestUnivaluePath(root);
    }
}
