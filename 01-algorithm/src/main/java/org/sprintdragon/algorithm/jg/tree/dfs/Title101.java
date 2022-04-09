package org.sprintdragon.algorithm.jg.tree.dfs;

import org.sprintdragon.algorithm.jg.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Title101 {

    /**
     * 迭代bfs
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> lQ = new LinkedList<>();
        Queue<TreeNode> rQ = new LinkedList<>();
        lQ.offer(root);
        rQ.offer(root);
        while (!lQ.isEmpty() && !rQ.isEmpty()) {
            int size = lQ.size();
            if (size != rQ.size()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                TreeNode lNode = lQ.poll();
                TreeNode rNode = rQ.poll();
                if (lNode.val != rNode.val) {
                    return false;
                }
                if (lNode.left == null && rNode.right == null) {
                    //do nothing
                } else if (lNode.left != null && rNode.right != null) {
                    lQ.offer(lNode.left);
                    rQ.offer(rNode.right);
                } else {
                    return false;
                }
                if (lNode.right == null && rNode.left == null) {
                    //do nothing
                } else if (lNode.right != null && rNode.left != null) {
                    lQ.offer(lNode.right);
                    rQ.offer(rNode.left);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isSym = true;

    public boolean isSymmetricDg(TreeNode root) {
        if (root == null) {
            return true;
        }
        dfs(root.left, root.right);
        return isSym;
    }

    private void dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return;
        }
        if (left == null && right != null) {
            isSym = false;
            return;
        }
        if (left != null && right == null) {
            isSym = false;
            return;
        }
        if (left.val != right.val) {
            isSym = false;
            return;
        }
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}
