package cn.cian.leetcode;

public class LC02_AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        int car = 0;
        while(l1 != null || l2 != null || car != 0){
            int one = l1 == null? 0 : l1.val;
            int two = l2 == null? 0 : l2.val;
            int cur = (one + two + car) % 10;
            car = (one + two + car) / 10;
            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;
            p.next = new ListNode(cur);
            p = p.next;
        }

        return head.next;
    }
}
