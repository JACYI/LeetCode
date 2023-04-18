package DP;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class code337 {
    public int rob3(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
//                cur = cur.left;
            }
        }
        return 0;
    }
}
