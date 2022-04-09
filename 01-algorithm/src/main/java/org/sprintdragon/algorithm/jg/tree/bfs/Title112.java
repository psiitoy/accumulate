package org.sprintdragon.algorithm.jg.tree.bfs;

import org.sprintdragon.algorithm.jg.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Title112 {

    /**
     * bfs
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> valQueue = new LinkedList<>();
        queue.offer(root);
        valQueue.offer(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int val = valQueue.poll();
                if (node.left != null) {
                    valQueue.offer(val + node.left.val);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    valQueue.offer(val + node.right.val);
                    queue.offer(node.right);
                }
                if (node.left == null && node.right == null && val == targetSum) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean has = false;
    int total = 0;

    public boolean hasPathSumDg(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return has;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        total += root.val;
        if (total == targetSum && root.left == null && root.right == null) {
            has = true;
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        total -= root.val;
    }

}
