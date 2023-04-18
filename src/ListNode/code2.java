package ListNode;

public class code2 {
    public static void main(String[] args){

    }
    // 原地修改
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode p = l1;
        ListNode q = l2;
        int v1=0,v2 = 0;
        int sum=0;
        int carry = 0;
        while(p != null || q != null || carry != 0){
            v1 = (p != null)? p.val:0;
            v2 = (q != null)? q.val:0;
            sum = v1 + v2 + carry;
            carry = sum / 10;

            if(p == null)
                p = new ListNode(sum % 10);
            else
                p.val = sum % 10;

            p = p.next;
            if(q != null)
                q = q.next;
        }
        return l1;
    }
    // 创建新链表
    public static ListNode add(ListNode l1, ListNode l2){
        int v1,v2;
        int sum;
        int carry = 0;
        ListNode res = new ListNode();
        ListNode p = res;
        while(l1 != null || l2 != null || carry != 0){
            v1 = (l1 != null)? l1.val:0;
            v2 = (l2 != null)? l2.val:0;
            sum = v1 + v2 + carry;
            carry = sum / 10;
            // 当前两位和保存在下一位res上
            p.next = new ListNode();
            p = p.next;
            p.val = sum % 10;

            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
        }
        return res.next;
    }
}
