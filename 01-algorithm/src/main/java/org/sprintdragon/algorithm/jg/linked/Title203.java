package org.sprintdragon.algorithm.jg.linked;

public class Title203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val == val) {
                pre.next = cur.next;
                cur.next = null;
            } else {
                pre = cur;
            }
            cur = next;
        }
        return dummy.next;
    }
}
