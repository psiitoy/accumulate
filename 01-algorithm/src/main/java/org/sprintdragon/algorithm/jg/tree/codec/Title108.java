package org.sprintdragon.algorithm.jg.tree.codec;

import org.sprintdragon.algorithm.jg.tree.TreeNode;

public class Title108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return inorderDes(nums, 0, nums.length - 1);
    }

    private TreeNode inorderDes(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = inorderDes(nums, left, mid - 1);
        root.right = inorderDes(nums, mid + 1, right);
        return root;
    }

}
