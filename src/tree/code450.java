package tree;

public class code450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;

        // 如果要删除的是本节点
        if(root.val == key) {
            // 1. 若有一个节点为空，直接删除
            if (root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;

            // 2. 找到右子树的最小节点删除并替换到本节点的位置
            TreeNode newRoot = getMin(root.right);
            deleteNode(root, newRoot.val);
            newRoot.left = root.left;
            newRoot.right = root.right;
            return newRoot;
        }
        else if(root.val > key)
            root.left = deleteNode(root.left, key);
        else
            root.right = deleteNode(root.right, key);

        return root;
    }

    private TreeNode getMin(TreeNode right) {
        while(right.left != null)
            right = right.left;
        return right;
    }
}
