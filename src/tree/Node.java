package tree;

import java.util.List;

// N叉树
class Node {
    public int val;
    public List<Node> children;
    public Node(){

    }
    public Node(int _val){
        this.val = _val;
    }
    public Node(int _val, List<Node> _children){
        this.val = _val;
        this.children = _children;
    }

}
