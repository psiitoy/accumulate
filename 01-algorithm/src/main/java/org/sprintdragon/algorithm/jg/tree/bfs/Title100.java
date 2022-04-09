package org.sprintdragon.algorithm.jg.tree.bfs;

import org.sprintdragon.algorithm.jg.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Title100 {

    /**
     * BFS法
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null && q != null) {
            return false;
        } else if (q == null && p != null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            int size = queue.size();
            //此处注意/2
            for (int i = 0; i < size / 2; i++) {
                TreeNode nodeP = queue.poll();
                TreeNode nodeQ = queue.poll();
                boolean eq = isNodeEqual(nodeP, nodeQ) && isNodeEqual(nodeP.left, nodeQ.left)
                        && isNodeEqual(nodeP.right, nodeQ.right);
                if (!eq) {
                    return eq;
                }
                if (nodeP.left != null && nodeQ.left != null) {
                    queue.offer(nodeP.left);
                    queue.offer(nodeQ.left);
                }
                if (nodeP.right != null && nodeQ.right != null) {
                    queue.offer(nodeP.right);
                    queue.offer(nodeQ.right);
                }
            }
        }
        return true;
    }

    private boolean isNodeEqual(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null && q != null) {
            return false;
        } else if (q == null && p != null) {
            return false;
        } else {
            return p.val == q.val;
        }
    }

    boolean isSameTree = true;

    public boolean isSameTreeDfs(TreeNode p, TreeNode q) {
        dfs(p, q);
        return isSameTree;
    }

    private void dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return;
        } else if (p == null && q != null) {
            isSameTree = false;
            return;
        } else if (q == null && p != null) {
            isSameTree = false;
            return;
        }
        if (p.val != q.val) {
            isSameTree = false;
            return;
        }
        dfs(p.left, q.left);
        dfs(p.right, q.right);
    }

}
