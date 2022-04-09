package org.sprintdragon.algorithm.jg.tree.bst;

import org.sprintdragon.algorithm.jg.tree.TreeNode;

public class Title98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode root, Integer leftLimit, Integer rightLimit) {
        if (root == null) {
            return true;
        }
        if (leftLimit != null && root.val <= leftLimit) {
            return false;
        }
        if (rightLimit != null && root.val >= rightLimit) {
            return false;
        }
        return dfs(root.left, leftLimit, root.val) && dfs(root.right, root.val, rightLimit);
    }

}
