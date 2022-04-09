package org.sprintdragon.algorithm.lc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Title230 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        inOrder(root, arr);
        return arr.get(k-1);
    }

    public void inOrder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);
    }

}
