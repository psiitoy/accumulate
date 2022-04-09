package org.sprintdragon.algorithm.jg.tree.dfs;

import org.sprintdragon.algorithm.jg.tree.TreeNode;

public class Title110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        dfs(root);
        return isB;
    }

    boolean isB = true;

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int lH = dfs(root.left);
        int rH = dfs(root.right);
        if (Math.abs(lH - rH) > 1) {
            isB = false;
        }
        return Math.max(lH, rH) + 1;
    }

}
