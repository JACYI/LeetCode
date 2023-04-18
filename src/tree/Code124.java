package tree;

/**
 * @Author yiyonghao
 * @Date 2023/3/14 22:26
 */
public class Code124 {
    int res;
    public int dfs(TreeNode root) {
        if(root == null)
            return 0;

        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);

        int max = Math.max(root.val, root.val + leftMax);
        max = Math.max(max, root.val + rightMax);
        int returnMax = max;
        max = Math.max(max, root.val + leftMax + rightMax);
        res = Math.max(res, max);

        return returnMax;
    }
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        dfs(root);
        return res;
    }

    public static void main(String[] args) {
        Code124 c = new Code124();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(c.maxPathSum(root));
    }
}
