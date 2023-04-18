package ListNode;

class MyLinkedList {
    static class Node{
        int val;
        Node next;
        Node(){this(0, null);}
        Node(int _val){this(_val, null);}
        Node(int _val, Node _next){val = _val; next = _next;}
    }
    Node head;
    int length;
    public MyLinkedList() {
        head = new Node();
        length = 0;
    }

    public int get(int index) {
        if(index < 0 || index >= length) return -1;
        Node cur = head.next;
        while(index > 0){
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(length, val);
    }

    public void addAtIndex(int index, int val) {
        if(index < 0 ||index > length) return;

        Node pre = head;
        while(index > 0){
            pre = pre.next;
            index--;
        }
        Node nex = pre.next;
        pre.next = new Node(val, nex);
        length++;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= length) return;
        Node pre = head;
        while(index > 0){
            pre = pre.next;
            index--;
        }
        pre.next = pre.next.next;
        length--;
    }
}

public class code707 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.get(1);
    }
}
