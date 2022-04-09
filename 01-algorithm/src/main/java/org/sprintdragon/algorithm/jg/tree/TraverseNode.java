package org.sprintdragon.algorithm.jg.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TraverseNode {

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);
        pre(node1);
        pre2(node1);
        System.out.println();
        pos(node1);
        pos2(node1);
        System.out.println();
        in(node1);
        in2(node1);
        System.out.println();
        level(node1);
    }

    public static void pre(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        pre(node.left);
        pre(node.right);
    }

    public static void pre2(TreeNode node) {
        System.out.println("pre order:");
        if (node != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(node);
            while (!stack.isEmpty()) {
                TreeNode n = stack.pop();
                System.out.print(n.val + " ");
                if (n.right != null) {
                    stack.push(n.right);
                }
                if (n.left != null) {
                    stack.push(n.left);
                }
            }
        }
    }

    public static void in(TreeNode node) {
        if (node == null) {
            return;
        }
        in(node.left);
        System.out.print(node.val + " ");
        in(node.right);
    }

    public static void in2(TreeNode node) {
        System.out.println("in order:");
        if (node != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    TreeNode n = stack.pop();
                    System.out.print(n.val + " ");
                    node = n.right;
                }
            }
            return;
        }
    }

    public static void pos(TreeNode node) {
        if (node == null) {
            return;
        }
        pos(node.left);
        pos(node.right);
        System.out.print(node.val + " ");
    }

    public static void pos2(TreeNode node) {
        System.out.println("pos order:");
        if (node != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(node);
            while (!s1.isEmpty()) {
                TreeNode n = s1.pop();
                s2.push(n);
                if (n.left != null) {
                    s1.push(n.left);
                }
                if (n.right != null) {
                    s1.push(n.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().val + " ");
            }
        }
    }

    public static void level(TreeNode node) {
        System.out.println("level order:");
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            System.out.print(n.val + " ");
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
        }
    }

}
