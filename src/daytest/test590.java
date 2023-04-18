package daytest;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class test590 {
    // 递归
    public List<Integer> postorder(Node root) {
        if(root == null) return new ArrayList<>();
        List<Node> childs = root.children;
        List<Integer> result = new ArrayList<>();
        for(Node child:childs){
            result.addAll(postorder(child));
        }
        result.add(root.val);
        return result;
    }
    // 迭代
    public List<Integer> postorder2(Node root){
        Node cur = root;
        Node pre = null;
        List<Node> childs = null;
        List<Integer> result = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        while(!stack.isEmpty() || cur!=null){
            while(cur!=null) {
                stack.push(cur);
                childs = cur.children;
                if(childs == null) break;
                cur = childs.get(0);
            }
            cur = stack.pop();
            result.add(cur.val);

        }
        return new ArrayList<>();
    }

    public static void main(String[] args){

    }
}
