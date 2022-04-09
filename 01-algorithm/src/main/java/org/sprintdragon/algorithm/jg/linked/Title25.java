package org.sprintdragon.algorithm.jg.linked;

public class Title25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        int remain = len(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null && remain >= k) {
            pre.next = null;
            ListNode lNode = cur;
            ListNode rNode = cur;
            for (int i = 0; i < k - 1; i++) {
                rNode = rNode.next;
            }
            ListNode rNext = rNode.next;
            rNode.next = null;
            pre.next = revertNode(lNode);
            lNode.next = rNext;
            cur = rNext;
            pre = lNode;
            remain -= k;
        }
        return dummy.next;
    }

    public ListNode revertNode(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public int len(ListNode node) {
        int cnt = 0;
        while (node != null) {
            node = node.next;
            cnt++;
        }
        return cnt;
    }

}
