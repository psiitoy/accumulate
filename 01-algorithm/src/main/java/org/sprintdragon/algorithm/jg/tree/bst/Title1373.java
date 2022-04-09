package org.sprintdragon.algorithm.jg.tree.bst;

import org.sprintdragon.algorithm.jg.tree.TreeNode;

public class Title1373 {

    int res = 0;

    public int maxSumBST(TreeNode root) {
        if (root == null) {
            return res;
        }
        if (isBst(root, null, null)) {
            sumVal(root);
            return res;
        }
        maxSumBST(root.left);
        maxSumBST(root.right);
        return res;
    }

    public int sumVal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            res = Math.max(res, root.val);
            return root.val;
        }
        int leftVal = sumVal(root.left);
        int rightVal = sumVal(root.right);
        int total = root.val + leftVal + rightVal;
        res = Math.max(res, total);
        return total;
    }

    public boolean isBst(TreeNode root, Integer leftLimit, Integer rightLimit) {
        if (root == null) {
            return true;
        }
        if (leftLimit != null && root.val <= leftLimit) {
            return false;
        }
        if (rightLimit != null && root.val >= rightLimit) {
            return false;
        }
        return isBst(root.left, leftLimit, root.val) && isBst(root.right, root.val, rightLimit);
    }

}
