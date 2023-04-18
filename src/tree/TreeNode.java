package tree;

import com.sun.source.tree.Tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){

    }
    TreeNode(int _val){
        this.val = _val;
    }
    TreeNode(int _val, TreeNode left, TreeNode right){
        this.val = _val;
        this.left = left;
        this.right = right;
    }
}
