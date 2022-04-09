package org.sprintdragon.algorithm.jg.tree.dfs;

import org.sprintdragon.algorithm.jg.tree.TreeNode;

public class Title543 {

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }

}
