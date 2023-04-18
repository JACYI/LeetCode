package ListNode;

public class code206 {
    public static ListNode reverseList1(ListNode head) {
        if(head.next == null) return head;
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public static ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode newHead = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }
    public static void main(String[] args) {

    }
}
