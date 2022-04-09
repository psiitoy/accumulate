package org.sprintdragon.algorithm.lc;

import java.util.HashMap;
import java.util.Map;

public class Title105 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inIndexMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inIndexMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inIndexMap);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inIndexMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode node = new TreeNode(rootVal);
        int inRootIndex = inIndexMap.get(rootVal);
        int left_len = inRootIndex - inStart;
        node.left = build(preorder, preStart + 1, preStart + 1 + (left_len - 1), inorder, inStart, inRootIndex - 1, inIndexMap);
        node.right = build(preorder, preStart + 1 + left_len, preEnd, inorder, inRootIndex + 1, inEnd, inIndexMap);
        return node;
    }

//    #################################################################################################################################################

    public TreeNode buildTreeGf(int[] preorder, int[] inorder) {
        return bulidGf(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);//这个先写，你传入的参数肯定就是这几个
    }

    public TreeNode bulidGf(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        //最后写递归出口 base case，很简单，就是两个数组之一越界就是出口（其实写1个也行，因为两个数组长度肯定相同的）
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        /*先序遍历框架-根、左、右*/
        //1.先构造根节点的值，做根节点
        //2.递归构造左子树
        //3.递归构造右子树

        //1.很明显根节点的值由先序遍历数组的第一个值确定
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        //2.递归构造左子树
        // root.left = bulid(preorder, ?, ?, inorder, ?, ?);//？需要我们画图去求的，也就是左右子树的索引
        // root.right = bulid(preorder, ?, ?, inorder, ?, ?);//？需要我们画图去求的，也就是左右子树的索引
        //首先通过rootVal在inorder中的索引（index），然后就能够知道inorder中左子树和右子树的边界
        //可以改进的，一开始用hashMap把inorder的值和索引存好，到时候直接查就行。
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break;
            }
        }
        //找到了index，确定inorder中左右子树的边界
        // root.left = bulid(preorder, ?, ?, inorder, inStart, index - 1);//确定inorder中左子树的边界
        // root.right = bulid(preorder, ?, ?, inorder, index + 1, inEnd);//确定inorder中右子树的边界
        //通过inorder中左子树节点的数目来确定preorder中左右子树的边界
        int nums_of_left_tree = index - inStart;
        // root.left = bulid(preorder, preStart + 1, preStart + nums_of_left_tree, inorder, ?, ?);//确定preorder中左子树的边界
        // root.right = bulid(preorder, preStart + nums_of_left_tree + 1, preEnd, inorder, ?, ?);//确定preorder中右子树的边界
        //最终确认好preorder和inorder中的左右子树边界
        root.left = bulidGf(preorder, preStart + 1, preStart + nums_of_left_tree, inorder, inStart, index - 1);
        root.right = bulidGf(preorder, preStart + nums_of_left_tree + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }

}
