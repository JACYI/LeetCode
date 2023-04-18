package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class code429 {
    public static List<List<Integer>> levelOrder(Node root){
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Queue<Node> layer = new LinkedList<>();     // 使用for循环可以免除该变量
            List<Integer> layerNum = new ArrayList<>();
            while(!queue.isEmpty()){
                Node cur = queue.poll();
                layerNum.add(cur.val);
                for(Node i:cur.children)
                    layer.offer(i);
            }
            res.add(layerNum);
            queue = layer;
        }
        return res;
    }

    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll());
    }
}
