package org.sprintdragon.algorithm.weapon;

/**
 * 小写字母前缀树
 */
public class TrieTree {

    TreeNode root;

    public TrieTree() {
        root = new TreeNode();
    }

    public void insertString(String str) {
        int len = str.length();
        TreeNode cur = root;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            int index = c - 'a';
            if (cur.nexts[index] == null) {
                cur.nexts[index] = new TreeNode();
            }
            cur.path++;
            cur = cur.nexts[index];
        }
        cur.path++;
        cur.end++;
    }

    public int searchWord(String str) {
        TreeNode target = findNode(str);
        return target == null ? 0 : target.end;
    }

    public int searchPrefix(String str) {
        TreeNode target = findNode(str);
        return target == null ? 0 : target.path;
    }

    private TreeNode findNode(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int len = str.length();
        TreeNode cur = root;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            int index = c - 'a';
            if (cur.nexts[index] == null) {
                return null;
            }
            cur = cur.nexts[index];
        }
        return cur;
    }

    class TreeNode {
        int path;
        int end;
        TreeNode[] nexts;

        public TreeNode() {
            this.path = 0;
            this.end = 0;
            nexts = new TreeNode[26];
        }
    }
}
