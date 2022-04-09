package org.sprintdragon.algorithm.jg.tree.build;

import org.sprintdragon.algorithm.jg.tree.TreeNode;

public class Title106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inL, int inR, int pL, int pR) {
        if (inL == inR) {
            return new TreeNode(inorder[inL]);
        }
        if (pL == pR) {
            return new TreeNode(postorder[pL]);
        }
        int leftLen = 0;
        for (int i = inL; i <= inR; i++) {
            if (inorder[i] == postorder[pR]) {
                leftLen = i - inL;
            }
        }
        int rightLen = pR - pL - leftLen;
        TreeNode root = new TreeNode(postorder[pR]);
        root.left = leftLen == 0 ? null : buildTree(inorder, postorder, inL, inL + leftLen - 1, pL, pL + leftLen - 1);
        root.right = rightLen == 0 ? null : buildTree(inorder, postorder, inR - rightLen + 1, inR, pR - 1 - rightLen + 1, pR - 1);
        return root;
    }
    
}
