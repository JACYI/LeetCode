package tree;

import com.sun.source.tree.Tree;

/**
 * @Author yiyonghao
 * @Date 2023/1/10 22:15
 */
public class code236 {
    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        return null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null)
            return root;

        if(left == null)
            return right;
        else
            return left;
    }
}
