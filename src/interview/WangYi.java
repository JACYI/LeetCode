package interview;

import ListNode.ListNode;

import java.util.HashSet;

/**
 * @Author yiyonghao
 * @Date 2022/12/8 17:53
 */
public class WangYi {
    // 给一个单向链表，A -> B -> C -> D -> E，输入是A，要求返回两两交换，
    // 左闭右开的区间反转
//    public static ListNode reverse2(ListNode head, ListNode end) {
//        if(head.next == end)
//            return head;
//        ListNode newHead = reverse2(head.next, end);
//        head.next.next = head;
//        head.next = null;
//        return newHead;
//    }
//    public static ListNode reverse(ListNode root) {
//        ListNode preHead = new ListNode(-1, root);
//
//        int cnt = 0;
//        ListNode cur = preHead;
//        ListNode end = preHead;
//        // preHead -> A -> B -> C -> D -> E
//        while(end != null) {
//            end = end.next;
//            cnt++;
//            if(cnt == 2) {
//                cnt = 0;
//                ListNode prevEnd = cur.next;// 记录
//                end = end.next;
////                ListNode newHead = reverse2(cur.next, end);
//                // 两个
//                ListNode last = cur.next.next;
//                last.next = cur.next;
//                cur.next.next = end;
//
//
////                cur.next.next = end;
////                cur.next = newHead;
//
//                cur = prevEnd;
//                end = cur;
//            }
//        }
//        return preHead.next;
//    }
    public static void main(String[] args) {
        HashSet<Character> set = new HashSet<>();
        for(int i =0; i<26; i++) {
            set.add((char) ('a' + i));
        }

        System.out.println(set);
    }
}
