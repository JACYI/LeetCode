package ListNode;

public class code142 {
    public ListNode detectCycle(ListNode head) {
        int l1 = 0, l2 = 0;
        ListNode faster = head, slower = head;
        while(faster != null && faster.next != null && slower != null){
            faster = faster.next.next;
            slower = slower.next;
            l1 += 2;
            l2 += 1;
            if(faster == slower){
                int k = l1 - l2;
                ListNode dummy = new ListNode(-1, head);
                faster = dummy;
                slower = dummy;
                int dist = 0;
                while(true){
                    faster = faster.next;
                    if(dist == k)
                        slower = slower.next;
                    else
                        dist++;
                    if(faster == slower)
                        return faster;
                }
            }
        }
        return null;
    }
}
