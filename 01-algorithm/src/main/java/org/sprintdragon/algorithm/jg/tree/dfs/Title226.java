package org.sprintdragon.algorithm.jg.tree.dfs;

import org.sprintdragon.algorithm.jg.tree.TreeNode;

public class Title226 {

    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

}
