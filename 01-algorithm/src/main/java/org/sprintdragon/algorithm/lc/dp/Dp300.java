package org.sprintdragon.algorithm.lc.dp;

public class Dp300 {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int innerMax = 1;
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i]) {
                    innerMax = Math.max(dp[j] + 1, innerMax);
                }
            }
            dp[i] = innerMax;
            max = Math.max(innerMax, max);
        }
        return max;
    }

    public int lengthOfLISDg(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, process(nums, i));
        }
        return max;
    }

    /**
     * 以right为结尾的lis
     *
     * @param nums
     * @param right
     * @return
     */
    public int process(int[] nums, int right) {
        if (right == 0) {
            return 1;
        }
        int max = 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] < nums[right]) {
                max = Math.max(process(nums, i) + 1, max);
            }
        }
        return max;
    }
}
