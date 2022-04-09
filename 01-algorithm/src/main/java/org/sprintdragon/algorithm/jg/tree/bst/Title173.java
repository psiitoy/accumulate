package org.sprintdragon.algorithm.jg.tree.bst;

import org.sprintdragon.algorithm.jg.tree.TreeNode;
import org.sprintdragon.algorithm.lc.AForTest;

import java.util.Stack;

public class Title173 {

    class BSTIterator {

        Stack<TreeNode> stack;
        TreeNode cur;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            cur = root;
        }

        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode res = stack.pop();
            cur = res.right;
            return res.val;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }

}
