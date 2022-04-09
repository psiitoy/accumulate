package org.sprintdragon.algorithm.lc;

import java.util.HashMap;
import java.util.Map;

public class Title138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 方法1：空间O(N) 直接用hashmap (独创)
     * 方法2：空间O(1) 新的每个点插到旧的后面，这样每个random都根据旧的下一个能找到，最后把链子打断即可
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            Node cpNode = new Node(cur.val);
            cpNode.next = cur.next;
            cpNode.random = cur.random;
            map.put(cur, cpNode);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node cpNode = map.get(cur);
            cpNode.next = map.get(cpNode.next);
            cpNode.random = map.get(cpNode.random);
            cur = cur.next;
        }

        return map.get(head);
    }
}
