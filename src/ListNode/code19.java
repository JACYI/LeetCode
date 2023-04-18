package ListNode;

public class code19 {
    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode pre = head, cur = head;
        int distance = 0;
        while(cur.next != null) {
            if(distance != n) {
                distance++;
            }
            else{
                pre = pre.next;
            }
            cur = cur.next;
        }
        if(distance != n){
            // n等于链表节点数，即需要删除头结点
            return head.next;
        }
        else{
            // n小于链表节点数，旧的链表头结点也是删除后的链表头结点
            pre.next = pre.next.next;
            return head;
        }
    }
    public static void main(String[] args) {

    }
}
