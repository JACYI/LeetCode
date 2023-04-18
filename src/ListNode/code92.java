package ListNode;

public class code92 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null || left == right) return head;
        int count = 0;
        ListNode emptyHead = new ListNode();
        emptyHead.next = head;
        ListNode cur = emptyHead;
        ListNode pre = null;
        while(count <= right){
            if(pre != null){
                ListNode temp = cur.next.next;
                cur.next.next = pre.next;
                pre.next = cur.next;
                cur.next = temp;
            }
            if(count == left-1) pre = cur;
            count++;
        }
        return emptyHead.next;
    }
    public static ListNode reverseBetween1(ListNode head, int left, int right) {
        if(head.next == null || left == right) return head;
        ListNode pre = null, after = null;
        ListNode cur = head;
        for(int i=1; cur != null; i++){
            if(i == left-1) pre = cur;
            if(i == right+1) after = cur;
            cur = cur.next;
        }
        if(pre == null)
            cur = head;
        else
            cur = pre.next;
        ListNode newHead = after;
        while(cur != after){
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        if(pre == null)
            return newHead;
        else{
            pre.next = newHead;
            return head;
        }
    }
    public static void main(String[] args) {

    }
}
