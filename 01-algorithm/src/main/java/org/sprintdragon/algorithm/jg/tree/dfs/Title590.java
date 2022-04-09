package org.sprintdragon.algorithm.jg.tree.dfs;

import java.util.ArrayList;
import java.util.List;

public class Title590 {

    public List<Integer> postorderDg(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        for (Node c : root.children) {
            dfs(c, res);
        }
        res.add(root.val);
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
