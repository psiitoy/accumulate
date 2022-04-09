package org.sprintdragon.algorithm.lc;

public class Title53 {

    /**
     * 贪心+dp，贡献值思路，如果前面叠加贡献值为负，舍弃
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
    }

}
