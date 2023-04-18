package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class code669 {
    public TreeNode trimBST(TreeNode root,  int low, int high) {
        if(root == null) return null;
        if(root.val < low) return trimBST(root.right, low, high);
        if(root.val > high) return trimBST(root.left, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
    // 迭代( 待补充 )
    public TreeNode trimBST2(TreeNode root,  int low, int high) {
        if(root == null) return null;
        while(root != null && (root.val < low || root.val > high))
            root = root.val < low ? root.right : root.left;

        if(root == null) return null;
        TreeNode cur = root;
        // 修剪左子树
        for(TreeNode node = root; node.left != null;){
            if(node.left.val < low){
                node.left = node.left.right;
            }
            else
                node = node.left;
        }
        // 修剪右子树
        for(TreeNode node = root; node.right != null;){
            if(node.right.val > high)
                node.right = node.right.left;
            else
                node = node.right;
        }

        return root;
    }
    public static void main(String[] args) {
        code669 c = new code669();
        c.trimBST(new TreeNode(1, new TreeNode(0), new TreeNode(2)), 1, 2);
    }
}
