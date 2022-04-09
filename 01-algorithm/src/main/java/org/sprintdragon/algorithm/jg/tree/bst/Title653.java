package org.sprintdragon.algorithm.jg.tree.bst;

import org.sprintdragon.algorithm.jg.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Title653 {


    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int lv = list.get(left);
            int rv = list.get(right);
            int sum = lv + rv;
            if (sum == k) {
                return true;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

}
