package org.sprintdragon.algorithm.jg.tree.full;

import org.sprintdragon.algorithm.jg.tree.TreeNode;

public class Title222 {

    /**
     * 1. 满二叉logN可以查到level
     * 2. left(High) == right。这说明，左子树一定是满二叉树，因为节点已经填充到右子树了，左子树必定已经填满了。所以左子树的节点总数我们可以直接得到，是 2^left - 1，加上当前这个 root 节点，则正好是 2^left。再对右子树进行递归统计。
     * 3. left(High) != right。说明此时最后一层不满，但倒数第二层已经满了，可以直接得到右子树的节点个数。同理，右子树节点 +root 节点，总数为 2^right。再对左子树进行递归查找。
     * <p>
     * 作者：xiao-ping-zi-5
     * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/chang-gui-jie-fa-he-ji-bai-100de-javajie-fa-by-xia/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/chang-gui-jie-fa-he-ji-bai-100de-javajie-fa-by-xia/
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = countFullNodeLevel(root.left);
        int rh = countFullNodeLevel(root.right);
        if (lh == rh) {
            return countNodes(root.right) + (1 << lh);
        } else {
            return countNodes(root.left) + (1 << rh);
        }
    }

    private int countFullNodeLevel(TreeNode node) {
        int level = 0;
        while (node != null) {
            level++;
            node = node.left;
        }
        return level;
    }

    public int countNodesDg(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

}
