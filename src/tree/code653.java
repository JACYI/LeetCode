package tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class code653 {
    public static boolean findTarget(TreeNode root, int k){
        HashSet<Integer> set = new HashSet<>();
        // 前序遍历
        TreeNode cur = root;
        Stack<TreeNode> stack= new Stack<>();
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                if(set.contains(k-cur.val))
                    return true;
                set.add(cur.val);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return false;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        findTarget(root, 0);
    }
}
