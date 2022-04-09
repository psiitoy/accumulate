package org.sprintdragon.algorithm.jg.tree.dfs;

import org.sprintdragon.algorithm.jg.tree.TreeNode;

public class Title104 {

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int lH = dfs(root.left);
        int rH = dfs(root.right);
        return Math.max(lH, rH) + 1;
    }

}
