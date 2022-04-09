package org.sprintdragon.algorithm.jg.tree.bst;

import org.sprintdragon.algorithm.jg.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Title1305 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode cur1 = root1;
        TreeNode cur2 = root2;
        while (!stack1.isEmpty() || !stack2.isEmpty() || cur1 != null || cur2 != null) {
            while (cur1 != null) {
                stack1.push(cur1);
                cur1 = cur1.left;
            }
            while (cur2 != null) {
                stack2.push(cur2);
                cur2 = cur2.left;
            }
            if (stack1.isEmpty()) {
                TreeNode node = stack2.pop();
                res.add(node.val);
                cur2 = node.right;
            } else if (stack2.isEmpty()) {
                TreeNode node = stack1.pop();
                res.add(node.val);
                cur1 = node.right;
            } else if (stack1.peek().val < stack2.peek().val) {
                TreeNode node = stack1.pop();
                res.add(node.val);
                cur1 = node.right;
            } else {
                TreeNode node = stack2.pop();
                res.add(node.val);
                cur2 = node.right;
            }
        }
        return res;
    }

}
