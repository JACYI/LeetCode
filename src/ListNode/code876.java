package ListNode;

public class code876 {
    public ListNode middleNode(ListNode head) {
        ListNode lat=head, pre=head;
        while(lat != null && lat.next!= null){
            lat = lat.next.next;
            pre = pre.next;
        }
        return pre;
    }
}
