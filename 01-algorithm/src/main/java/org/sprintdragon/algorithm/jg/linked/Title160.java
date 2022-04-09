package org.sprintdragon.algorithm.jg.linked;


public class Title160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = nodeLen(headA);
        int lenB = nodeLen(headB);
        //a is bigger
        if (lenA < lenB) {
            int tmp = lenA;
            lenA = lenB;
            lenB = tmp;
            ListNode tmpNode = headA;
            headA = headB;
            headB = tmpNode;
        }
        int distance = lenA - lenB;
        int indexA = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            if (indexA >= distance) {
                curB = curB.next;
            }
            indexA++;
        }
        return null;
    }

    public int nodeLen(ListNode node) {
        int cnt = 0;
        while (node != null) {
            cnt++;
            node = node.next;
        }
        return cnt;
    }
    
}
