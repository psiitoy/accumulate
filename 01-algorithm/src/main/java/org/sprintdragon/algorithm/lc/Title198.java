package org.sprintdragon.algorithm.lc;

public class Title198 {

    /**
     * 这个是我自创的，还是官方的正向解法比较简单
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[len - 1] = nums[len - 1];
        if (len == 1) {
            return dp[len - 1];
        }
        dp[len - 2] = Math.max(nums[len - 2], nums[len - 1]);
        if (len == 2) {
            return dp[len - 2];
        }
        dp[len - 3] = Math.max(nums[len - 3] + nums[len - 1], nums[len - 2]);
        if (len == 3) {
            return dp[len - 3];
        }
        for (int i = len - 4; i >= 0; i--) {
            int res1 = nums[i] + dp[i + 2];
            int res2 = nums[i + 1] + dp[i + 3];
            dp[i] = Math.max(res1, res2);
        }
        return dp[0];
    }

    public int robDg(int[] nums) {
        return process(nums, 0);
    }

    public int process(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (index == nums.length - 1) {
            return nums[index];
        }
        if (index == nums.length - 2) {
            return Math.max(nums[index], nums[index + 1]);
        }
        if (index == nums.length - 3) {
            return Math.max(nums[index] + nums[index + 2], nums[index + 1]);
        }
        int res1 = nums[index] + process(nums, index + 2);
        int res2 = nums[index + 1] + process(nums, index + 3);
        return Math.max(res1, res2);
    }

}
