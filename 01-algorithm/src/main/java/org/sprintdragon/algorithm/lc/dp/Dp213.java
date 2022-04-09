package org.sprintdragon.algorithm.lc.dp;

import java.util.Arrays;

//打家劫舍2
public class Dp213 {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int[] a = Arrays.copyOfRange(nums, 0, len - 1);
        int[] b = Arrays.copyOfRange(nums, 1, len);
        return Math.max(myRob(a), myRob(b));
    }

    public int myRob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }

    public int robDg(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int[] a = Arrays.copyOfRange(nums, 0, len - 1);
        int[] b = Arrays.copyOfRange(nums, 1, len);
        return Math.max(process(a, a.length - 1), process(b, b.length - 1));
    }

    public int process(int[] nums, int end) {
        if (end < 0) {
            return 0;
        }
        if (end == 0) {
            return nums[end];
        }
        if (end == 1) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(process(nums, end - 1), process(nums, end - 2) + nums[end]);
    }
}
