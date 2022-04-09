package org.sprintdragon.algorithm.lc;


public class Title148 {

    public static void main(String[] args) {
        Title148 test = new Title148();
        ListNode a = new ListNode(-1);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(0);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        System.out.println(test.sortList(a));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode sortList(ListNode head) {
        int len = nodeLen(head);
        ListNode dummy = new ListNode();
        dummy.next = head;
        for (int interval = 1; interval < len; interval *= 2) {
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            while (cur != null) {
                ListNode left = cur;
                ListNode right = cutAndSkipN(left, interval);
                cur = cutAndSkipN(right, interval);
                pre.next = mergeNodes(left, right);
                while (pre.next != null) {
                    pre = pre.next;
                }
            }
        }
        return dummy.next;
    }

    public ListNode cutAndSkipN(ListNode node, int n) {
        if (node == null) {
            return null;
        }
        for (int i = 1; i < n && node.next != null; i++) {
            node = node.next;
        }
        ListNode right = node.next;
        node.next = null;
        return right;
    }

    public int nodeLen(ListNode node) {
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    public ListNode mergeNodes(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

}
