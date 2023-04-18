package tree;

public class code114 {
    // 将一棵二叉树变成 root -> 左子树 -> 右子树的函数，返回最后的尾结点
    public TreeNode transfer2Nodelist(TreeNode root) {
        if(root == null)
            return null;
        TreeNode last = root;
        TreeNode curLeft = root.left;
        TreeNode curRight = root.right;
        TreeNode lastLeft = transfer2Nodelist(root.left);
        TreeNode lastRight = transfer2Nodelist(root.right);


        if(lastLeft != null) {
            root.left = null;
            root.right = curLeft;
            last = lastLeft;
        }
        if(lastRight != null){
            last.right = curRight;
            last = lastRight;
        }

        return last;
    }
    public void flatten(TreeNode root){
        transfer2Nodelist(root);
    }
}
