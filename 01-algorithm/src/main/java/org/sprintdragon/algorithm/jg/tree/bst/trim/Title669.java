package org.sprintdragon.algorithm.jg.tree.bst.trim;

import org.sprintdragon.algorithm.jg.tree.TreeNode;

public class Title669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            root.right = trimBST(root.right, low, high);
            return root.right;
        }
        if (root.val > high) {
            root.left = trimBST(root.left, low, high);
            return root.left;
        }
        if (root.left != null) {
            root.left = trimBST(root.left, low, high);
        }
        if (root.right != null) {
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }

}
