package org.sprintdragon.algorithm.lc;

public class Title92 {

//    public AForTest.ListNode reverseBetween(AForTest.ListNode head, int left, int right) {
//        AForTest.ListNode cur = head;
//        int index = 1;
//        AForTest.ListNode revertBegin = left == 1 ? head : null;
//        AForTest.ListNode beforeTail = null;
//        while (cur != null) {
//            if (++index == left) {
//                revertBegin = cur.next;
//                cur.next = null;
//                beforeTail = cur;
//                break;
//            }
//            cur = cur.next;
//        }
//        index = 0;
//        cur = revertBegin;
//        int len = right - left + 1;
//        AForTest.ListNode pre = null;
//        while (cur != null) {
//            AForTest.ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//            if (++index == len) {
//                break;
//            }
//        }
//        if (beforeTail != null) {
//            beforeTail.next = pre;
//        }
//        if (revertBegin != null) {
//            revertBegin.next = cur;
//        }
//        return beforeTail == null ? pre : head;
//    }

}
