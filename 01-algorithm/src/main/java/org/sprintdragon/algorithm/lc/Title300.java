package org.sprintdragon.algorithm.lc;

public class Title300 {

    public static void main(String[] args) {
        Title300 test = new Title300();
        int[] a = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(test.lengthOfLIS(a));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 0;
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            int maxVal = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxVal = Math.max(maxVal, dp[j] + 1);
                }
            }
            dp[i] = maxVal;
            ret = Math.max(ret, maxVal);
        }
        return ret == Integer.MIN_VALUE ? -1 : ret;
    }

    public int lengthOfLISDG(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxVal = Math.max(maxVal, process(nums, i));
        }
        return maxVal == Integer.MIN_VALUE ? -1 : maxVal;
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
        int maxVal = 1;
        for (int i = 0; i < right; i++) {
            if (nums[i] < nums[right]) {
                maxVal = Math.max(maxVal, process(nums, i) + 1);
            }
        }
        return maxVal;
    }

}
