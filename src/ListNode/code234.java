package ListNode;

public class code234 {
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode faster = head, slower = head;
        while(faster != null && faster.next != null){
            faster = faster.next.next;
            slower = slower.next;
        }
        // 处理节点为奇数个数的情况
        if(faster != null){
            slower = slower.next;
        }
        ListNode left = head, right = reverse(slower);
        while(right != null){
            if(left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        code234 c = new code234();
        c.isPalindrome(new ListNode(1, new ListNode(2)));
    }
}
