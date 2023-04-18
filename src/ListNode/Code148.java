package ListNode;

/**
 * @Author yiyonghao
 * @Date 2023/3/23 22:45
 */
public class Code148 {
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead, p1 = head1, p2 = head2;

        while(p1 != null && p2 != null) {
            if(p1.val <= p2.val){
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        if(p1 != null)
            cur.next = p1;
        if(p2 != null)
            cur.next = p2;
        return newHead.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode preHead = new ListNode(-1, head);
        ListNode mid = preHead, fast = preHead;

        while(fast != null && fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }
        ListNode head2 = mid.next;
        mid.next = null;
        ListNode newHead1 = sortList(head);
        ListNode newHead2 = sortList(head2);

        return merge(newHead1, newHead2);
    }

    public static void main(String[] args) {
        // 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        Code148 c = new Code148();
        c.sortList(head);
    }
}
