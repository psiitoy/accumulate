package org.sprintdragon.algorithm.jg.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeTree {

    public static Queue<String> preSerial(TreeNode node) {
        Queue<String> ans = new LinkedList<>();
        pres(node, ans);
        return ans;
    }

    private static void pres(TreeNode node, Queue<String> ans) {
        if (node == null) {
            ans.add(null);
            return;
        }
        ans.add(String.valueOf(node.val));
        pres(node.left, ans);
        pres(node.right, ans);
    }

    public static TreeNode buildByPreQueue(Queue<String> preList) {
        if (preList == null || preList.isEmpty()) {
            return null;
        }
        return preb(preList);
    }

    private static TreeNode preb(Queue<String> preList) {
        String val = preList.poll();
        if (val == null) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = preb(preList);
        node.right = preb(preList);
        return node;
    }

}
