package ListNode;

public class code24 {
    public static ListNode swapPairs(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode pre = new ListNode();
        ListNode newHead = pre;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            ListNode temp = cur.next.next;
            cur.next.next = cur;
            pre.next = cur.next;
            cur.next = temp;
            pre = cur;
            cur = cur.next;
        }
        return newHead.next;
    }
    public static void main(String[] args) {

    }
}
