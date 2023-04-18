package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class code1305 {
    public static ArrayList<Integer> midOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = midOrder(root1);
        ArrayList<Integer> list2 = midOrder(root2);
        ArrayList<Integer> res = new ArrayList<>();
        int i=0, j=0;
        while(i<list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j))
                res.add(list1.get(i++));
            else
                res.add(list2.get(j++));
        }
        if(i==list1.size())
            res.addAll(list2.subList(j,list2.size()));
        else
            res.addAll(list1.subList(i, list1.size()));
        return res;
    }
    public static void main(String[] args) {

    }
}
