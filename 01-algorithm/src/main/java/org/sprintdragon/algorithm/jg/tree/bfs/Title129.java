package org.sprintdragon.algorithm.jg.tree.bfs;

import org.sprintdragon.algorithm.jg.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Title129 {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> valQueue = new LinkedList<>();
        queue.offer(root);
        valQueue.offer(root.val);
        int total = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int val = valQueue.poll();
                if (node.left != null) {
                    valQueue.offer(val * 10 + node.left.val);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    valQueue.offer(val * 10 + node.right.val);
                    queue.offer(node.right);
                }
                if (node.left == null && node.right == null) {
                    total += val;
                }
            }
        }
        return total;
    }

}
