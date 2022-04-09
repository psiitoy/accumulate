package org.sprintdragon.algorithm.jg.tree.bst;

import org.sprintdragon.algorithm.jg.tree.TreeNode;

import java.util.Stack;

public class Title538 {

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int sum = 0;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            TreeNode node = stack.pop();
            sum += node.val;
            node.val = sum;
            if (node.left != null) {
                cur = node.left;
            }
        }
        return root;
    }

    public TreeNode convertBSTDg(TreeNode root) {
        return dfs(root);
    }

    int sum = 0;

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode r = dfs(root.right);
        sum += root.val;
        root.val = sum;
        TreeNode l = dfs(root.left);
        return root;
    }
}
