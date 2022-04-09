package org.sprintdragon.algorithm.jg.tree.bst;

import org.sprintdragon.algorithm.jg.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Title230 {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list, k);
        return list.get(k - 1);
    }

    private void inorder(TreeNode root, List<Integer> list, int k) {
        if (root == null) {
            return;
        }
        inorder(root.left, list, k);
        list.add(root.val);
        if (list.size() == k) {
            return;
        }
        inorder(root.right, list, k);
    }

}
