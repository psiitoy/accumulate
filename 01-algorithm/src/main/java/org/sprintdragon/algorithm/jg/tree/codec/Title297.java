package org.sprintdragon.algorithm.jg.tree.codec;


import org.sprintdragon.algorithm.jg.tree.TreeNode;

import java.util.LinkedList;

public class Title297 {

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            prorderSer(root, sb);
            return sb.toString();
        }

        private void prorderSer(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("null").append(",");
                return;
            }
            sb.append(root.val).append(",");
            prorderSer(root.left, sb);
            prorderSer(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> list = new LinkedList<>();
            for (String s : data.split(",")) {
                if (s.length() != 0) {
                    list.add(s);
                }
            }
            return proderDeser(list);
        }

        private TreeNode proderDeser(LinkedList<String> list) {
            if (list.isEmpty()) {
                return null;
            }
            String val = list.removeFirst();
            if ("null".equals(val)) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = proderDeser(list);
            node.right = proderDeser(list);
            return node;
        }
    }

}
