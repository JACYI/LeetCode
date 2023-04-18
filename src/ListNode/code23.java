package ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class code23 {
    public static class Node{
        int val;
        ListNode father;
        public Node(){}
        public Node(int _val, ListNode _father){
            val = _val;
            father = _father;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val, o2.val));
        for(ListNode list:lists) {
            if(list == null)
                continue;
            Node node = new Node(list.val, list);
            priorityQueue.add(node);
        }
        ListNode head = new ListNode();
        ListNode cur = head;
        while(!priorityQueue.isEmpty()){
            Node node = priorityQueue.poll();
            cur.next = node.father;
            cur = cur.next;
            if(node.father.next != null) {
                node.father = node.father.next;
                node.val = node.father.val;
                priorityQueue.add(node);
            }
        }
        return head.next;
    }
    public static void main(String[] args) {
        mergeKLists(new ListNode[]{new ListNode()});
    }
}
