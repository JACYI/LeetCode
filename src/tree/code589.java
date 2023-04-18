package tree;

import java.util.ArrayList;
import java.util.List;

public class code589 {

    List<Integer> preOrder(Node root){
        if(root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        List<Node> children = root.children;

        while(!children.isEmpty()){
            Node temp = children.remove(0);
            list.addAll(preOrder(temp));
        }
        return list;
    }

    public static void main(String[] args){

    }
}
