package org.sprintdragon.algorithm.lc;

import java.util.ArrayList;
import java.util.List;

public class Title297 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Title297 test = new Title297();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        String str = test.serialize(treeNode);
        System.out.println(str);
        System.out.println(test.deserialize(str));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = prebToList(root);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public List<Integer> prebToList(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            list.add(null);
            return list;
        }
        list.add(root.val);
        list.addAll(prebToList(root.left));
        list.addAll(prebToList(root.right));
        return list;
    }

    public TreeNode prebListToNode(List<Integer> list) {
        Integer val = list.remove(0);
        if (val == null) {
            return null;
        }
        TreeNode node = new TreeNode(val);
        node.left = prebListToNode(list);
        node.right = prebListToNode(list);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<Integer> list = new ArrayList<>();
        String[] strs = data.split(",");
        for (String str : strs) {
            if ("null".equals(str)) {
                list.add(null);
            } else {
                list.add(Integer.valueOf(str));
            }
        }
        return prebListToNode(list);
    }

}
