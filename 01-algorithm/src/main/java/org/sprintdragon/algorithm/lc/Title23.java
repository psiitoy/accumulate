package org.sprintdragon.algorithm.lc;

public class Title23 {
    public class ListNode {
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
    }

    /**
     * 1. 分治法，注意递归的baseCase，l==r取l
     * 2. 注意判断入参为null和size0
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        int mid = l + (r - l) / 2;
        ListNode leftNode = mergeKLists(lists, l, mid);
        ListNode rightNode = mergeKLists(lists, mid + 1, r);
        return merge2Nodes(leftNode, rightNode);
    }

    public ListNode merge2Nodes(ListNode l1, ListNode l2) {
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

    /**
     * 第一版自己想出来的，最朴素的解法，每次从数组中取出一个
     *
     * @param lists
     * @return
     */
    public ListNode mergeKListsPs(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        mergeSortPs(lists, dummy);
        return dummy.next;
    }

    public void mergeSortPs(ListNode[] lists, ListNode cur) {
        if (cur == null) {
            return;
        }
        ListNode min = null;
        int index = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            ListNode node = lists[i];
            if (min == null) {
                min = node;
                index = i;
            } else if (min.val > node.val) {
                min = node;
                index = i;
            }
        }
        if (index != -1) {
            lists[index] = lists[index].next;
        }
        cur.next = min;
        mergeSortPs(lists, cur.next);
    }

}
