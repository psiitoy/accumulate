package org.sprintdragon.algorithm.lc.dp;

public class Dp377 {

    //    爬楼梯问题 楼梯的阶数一共为target，一次可以走的步数为nums[i]。 一共有多少种走法？问题搞定。
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i >= n) {
                    dp[i] += dp[i - n];
                }
            }
        }
        return dp[target];
    }
}
