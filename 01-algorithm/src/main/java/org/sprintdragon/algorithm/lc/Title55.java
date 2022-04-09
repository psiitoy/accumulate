package org.sprintdragon.algorithm.lc;

public class Title55 {

    public static void main(String[] args) {
        Title55 test = new Title55();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(test.canJump(nums));
    }

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
