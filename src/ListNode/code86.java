package ListNode;

public class code86 {
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(-1);
        ListNode cur = head;
        ListNode p1 = l1, p2 = l2;
        while(cur != null){
            if(cur.val < x){
                p1.next = cur;
                p1 = p1.next;
            }
            else{
                p2.next = cur;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        p2.next = null;
        p1.next = l2.next;
        return l1.next;
    }

    public static void main(String[] args) {
        Integer i = 10;
        System.out.println(i.compareTo(9));;
    }
}
