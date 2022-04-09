package org.sprintdragon.algorithm.jg.tree.bst;

import org.sprintdragon.algorithm.jg.tree.TreeNode;

import java.util.Stack;

public class Title783 {

    public int minDiffInBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int res = Integer.MAX_VALUE;
        Integer pre = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            if (pre != null) {
                res = Math.min(res, node.val - pre);
            }
            pre = node.val;
            cur = node.right;
        }
        return res;
    }

    int res = Integer.MAX_VALUE;
    Integer pre = null;

    public int minDiffInBSTDg(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (pre != null) {
            res = Math.min(res, root.val - pre);
        }
        pre = root.val;
        inorder(root.right);
    }

}
