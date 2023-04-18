package tree;

import java.util.HashSet;
import java.util.Locale;
import java.util.Stack;

public class code606 {
    static StringBuffer res = new StringBuffer();
    static void dfs(TreeNode root){
        if(root == null) return;
        res.append("(");
        res.append(root.val);
        dfs(root.left);
        if(root.left == null) {
            res.append("()");
            dfs(root.right);
        }
    }
    public static String tree2str(TreeNode root){
        if(root == null) return "";
        dfs(root);
        return res.substring(1, res.length()-1).toString();
//        StringBuffer res = new StringBuffer();
//        Stack<TreeNode> stack = new Stack<>();
//        // set用于判定括号对
//        HashSet<Character> set = new HashSet<>();
//        TreeNode cur = root;
//        while(cur!=null || !stack.empty()) {
//            while (cur != null) {
//                res.append(cur.val + "(");
//
//                stack.push(cur);
//                cur = cur.left;
//            }
//            cur = stack.pop();
//            cur = cur.right;
//            res.append(")");
//        }
//        return res.toString();
    }
    public static void main(String[] args){
//        System.out.println("a"+ 1);
    }
}
