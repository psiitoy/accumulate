package org.sprintdragon.algorithm.lc.binarysearch;

public class Title34 {

    public int[] searchRange(int[] nums, int target) {
        int[] no = new int[]{-1, -1};
        if (nums.length == 0) {
            return no;
        }
        int f = findFirstPos(nums, target);
        if (f == -1) {
            return no;
        }
        return new int[]{f, findLastPos(nums, target)};
    }

    public int findFirstPos(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int m = left + (right - left) / 2;
            if (nums[m] < target) {
                left = m + 1;
            } else {
                right = m;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    public int findLastPos(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int m = left + (right - left + 1) / 2;
            if (nums[m] > target) {
                right = m - 1;
            } else {
                left = m;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

}
