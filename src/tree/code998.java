package tree;

public class code998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root.val < val)
            return new TreeNode(val, root, null);
        TreeNode pre = root;
        TreeNode cur = root.right;
        while(cur != null){
            if(cur.val < val)
                break;
            pre = cur;
            cur = cur.right;
        }
        pre.right = new TreeNode(val, cur, null);
        return root;
    }
}
