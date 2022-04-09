package org.sprintdragon.algorithm.lc;

import java.util.LinkedList;
import java.util.Queue;

public class Title116 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        Title116 test = new Title116();
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n2 = new Node(2, n4, n5, null);
        Node n3 = new Node(3, n6, n7, null);
        Node n1 = new Node(1, n2, n3, null);
        System.out.println(test.connectBfs(n1));
    }

    public Node connectBfs(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        Node cur = root;
        queue.add(cur);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    /**
     * dfs自顶向下，必定能找到父节点邻居节点next，进而指定right.next的parent.left.next
     *
     * @param root
     * @return
     */
    public Node connectDfs(Node root) {
        return dfs(root);
    }

    public Node dfs(Node node) {
        if (node == null || node.left == null || node.right == null) {
            return node;
        }
        node.left.next = node.right;
        node.right.next = node.next != null ? node.next.left : null;
        dfs(node.left);
        dfs(node.right);
        return node;
    }

}
