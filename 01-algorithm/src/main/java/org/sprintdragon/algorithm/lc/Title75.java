package org.sprintdragon.algorithm.lc;

import java.util.Arrays;

public class Title75 {

    public void sortColors(int[] nums) {
        int p0 = 0;
        int p1 = nums.length - 1;
        for (int i = 0; i <= p1; i++) {
            if (nums[i] == 0) {
                swap(nums, p0, i);
                p0++;
            }
            if (nums[i] == 2) {
                swap(nums, p1, i);
                p1--;
                if (nums[i] != 1) {
                    i--;
                }
            }
        }
    }

    public void swap(int[] arr, int from, int to) {
        int tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }

}
