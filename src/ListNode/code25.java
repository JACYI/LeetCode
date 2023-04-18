package ListNode;

import java.util.List;

public class code25 {
    public static ListNode reverse(ListNode head, ListNode dest) {
//        if(head == null || head.next == null) return head;
        if(head.next == dest) return head;
        ListNode newHead = reverse(head.next, dest);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public static ListNode reverseGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1) return head;
        ListNode head0 = new ListNode(0, head);
        ListNode pre = head0, cur = head0;
        int cnt = 0;
        while(cur != null){
            cur = cur.next;
            cnt++;
            if(cnt == k && cur != null) {
                ListNode dest = cur.next;
                cur = pre.next;
                pre.next = reverse(cur, dest);
                cur.next = dest;
                pre = cur;
                cnt = 0;
            }
        }
        return head0.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode a = reverseGroup(head, 3);
    }
}
