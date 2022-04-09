package org.sprintdragon.algorithm.lc;

public class Title283 {

    /**
     * 加last指针会加速
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int last = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                continue;
            }
            for (int j = last == 0 ? i + 1 : last; j < len; j++) {
                if (nums[j] != 0) {
                    last = j + 1;
                    swap(nums, i, j);
                    break;
                }
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
