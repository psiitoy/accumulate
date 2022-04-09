package org.sprintdragon.algorithm.jg.tree.redblack;

import java.util.TreeSet;

public class Title220 {
    /**
     * 照猫画虎
     * https://leetcode-cn.com/problems/contains-duplicate-iii/solution/gong-shui-san-xie-yi-ti-shuang-jie-hua-d-dlnv/
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            Long target = (long) nums[i];
            Long f = treeSet.floor(target);
            Long c = treeSet.ceiling(target);
            if (f != null && target - f <= t) {
                return true;
            }
            if (c != null && c - target <= t) {
                return true;
            }
            treeSet.add(target);
            if (i >= k) {
                treeSet.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
