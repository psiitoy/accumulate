package org.sprintdragon.algorithm.jg.tree.bst;


import org.sprintdragon.algorithm.jg.linked.ListNode;
import org.sprintdragon.algorithm.jg.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Title109 {

    public TreeNode sortedListToBST(ListNode head) {
        List<TreeNode> list = new ArrayList<>();
        while (head != null) {
            list.add(new TreeNode(head.val));
            head = head.next;
        }
        return inorder(list, 0, list.size() - 1);
    }

    private TreeNode inorder(List<TreeNode> list, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return list.get(left);
        }
        int mid = left + (right - left) / 2;
        //这里是get，不是remove!!
        TreeNode node = list.get(mid);
        node.left = inorder(list, left, mid - 1);
        node.right = inorder(list, mid + 1, right);
        return node;
    }

}
