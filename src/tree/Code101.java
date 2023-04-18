package tree;

/**
 * @Author yiyonghao
 * @Date 2023/3/12 16:09
 */
public class Code101 {
    private boolean dfs(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null || root1.val != root2.val)
            return false;

        return dfs(root1.left, root2.right) && dfs(root1.right, root2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return dfs(root.left, root.right);
    }
}
