package org.sprintdragon.algorithm.lc;

public class Title19 {

    public static void main(String[] args) {
        Title19 test = new Title19();
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        System.out.println(test.removeNthFromEnd(a, 2));
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * 快慢指针
     * slow追的条件是要等n+1次，因为要取n前面的即后n+1的节点pre，删除其后面的
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int index = 0;
        while (fast != null) {
            if (index >= n + 1) {
                slow = slow.next;
            }
            fast = fast.next;
            index++;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    /**
     * 两次迭代
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int size = length(head);
        ListNode dummy = new ListNode();
        dummy.next = head;
        int preIndex = size - n;
        int index = 0;
        ListNode cur = dummy;
        while (cur != null) {
            if (index == preIndex) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
            index++;
        }
        return dummy.next;
    }

    public int length(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

}
