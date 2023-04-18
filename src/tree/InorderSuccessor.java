package tree;

import java.util.Stack;

public class InorderSuccessor {
    // O(1)空间复杂度
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode successor = null;
        if(p.right != null) {
            p = p.right;
            while(p != null){
                successor = p;
                p = p.left;
            }
            return successor;
        }
        while(cur != null){
            if(cur.val > p.val) {
                successor = cur;
                cur = cur.left;
            }
            else
                cur = cur.right;
        }
        return successor;
    }


    // O(n)时间复杂度
    public static TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode cur = root, pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while(cur != null || !stack.isEmpty()){
            while(cur != null) {
//                pre = cur;
//                if(pre == p) return cur;
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            pre = cur;
            if(pre == p) return cur;
            cur = cur.right;
        }
        return null;
    }
    public static void main(String[] args) {

    }
}
