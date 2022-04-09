package org.sprintdragon.algorithm.lc;

public class Title26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preNum = nums[0];
        int preIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != preNum) {
                preNum = nums[i];
                nums[++preIndex] = nums[i];
            }
        }
        return preIndex + 1;
    }
}
