package org.sprintdragon.algorithm.lc.dp;

public class Dp55 {

    public boolean canJump(int[] nums) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxLen < i) {
                return false;
            } else {
                maxLen = Math.max(maxLen, i + nums[i]);
            }
        }
        return maxLen >= (nums.length - 1);
    }

}
