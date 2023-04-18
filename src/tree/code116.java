package tree;

import java.util.Deque;
import java.util.LinkedList;

public class code116 {
    // 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            // BST 层序遍历
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 从队首取出元素
                Node node = queue.poll();

                // 连接
                if (i < size - 1)
                    node.next = queue.peek();

                // 拓展下一层节点
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return root;
    }
}
