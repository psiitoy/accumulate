package org.sprintdragon.algorithm.jg.tree.codec;

import org.sprintdragon.algorithm.jg.tree.TreeNode;

import java.util.LinkedList;

public class Title449 {

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            preorderSer(root, sb);
            return sb.toString();
        }

        private void preorderSer(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("null").append(",");
                return;
            }
            sb.append(root.val).append(",");
            preorderSer(root.left, sb);
            preorderSer(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> nodes = new LinkedList<>();
            for (String s : data.split(",")) {
                if (s != "") {
                    nodes.add(s);
                }
            }
            return preorderDes(nodes);
        }

        private TreeNode preorderDes(LinkedList<String> nodes) {
            if (nodes.isEmpty()) {
                return null;
            }
            String val = nodes.removeFirst();
            if ("null".equals(val)) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = preorderDes(nodes);
            node.right = preorderDes(nodes);
            return node;
        }
    }

}
