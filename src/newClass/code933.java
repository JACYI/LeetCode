package newClass;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> requests;
    public RecentCounter() {
        requests = new LinkedList<>();
    }
    public int ping(int t) {
        requests.offer(t);
        while(t - requests.peek() > 3000)
            requests.poll();
        return requests.size();
    }
}

public class code933 {
    public static void main(String[] args) {
//        Node root = new Node();
//        Stack<Node> stack = new Stack<>();
//        Node cur = root;
//        while(cur != null || !stack.isEmpty()){
//            while(cur != null) {
//                stack.push(cur);
//                cur = cur.left;
//            }
//
//            cur = stack.pop();
//            cur = cur.right;
//        }
    }
}
