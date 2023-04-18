package tree;

public class code98 {
    // 树是否在限定范围内
    public boolean isValid(TreeNode root, Integer min, Integer max) {
        if(root == null)
            return true;
        if(min != null && root.val <= min)
            return false;
        if(max != null && root.val >= max)
            return false;

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
}
