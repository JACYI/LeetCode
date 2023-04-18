package ListNode;

public class code141 {
    public boolean hasCycle(ListNode head) {
        ListNode faster = head, slower = head;
        while(slower != null && faster != null && faster.next != null){
            faster = faster.next.next;
            slower = slower.next;
            if(faster == slower)
                return true;
        }
        return false;
    }
}
