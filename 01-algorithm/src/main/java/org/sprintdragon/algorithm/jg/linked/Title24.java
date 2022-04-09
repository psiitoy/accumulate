package org.sprintdragon.algorithm.jg.linked;

public class Title24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            pre.next = next;
            next.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

}
