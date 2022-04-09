package org.sprintdragon.algorithm.lc;

public class Title124 {
    public static class TreeNode {
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

    public static void main(String[] args) {
        Title124 test = new Title124();
        TreeNode node = new TreeNode(-5);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        System.out.println(test.maxPathSum(node));
    }

    int max_val = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        process(root);
        return max_val;
    }

    public int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lv = Math.max(0, process(root.left));
        int rv = Math.max(0, process(root.right));
        max_val = Math.max(max_val, lv + rv + root.val);
        return root.val + Math.max(lv, rv);
    }
}
