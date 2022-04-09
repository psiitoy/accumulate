package org.sprintdragon.algorithm.lc.binarysearch;

public class Title33 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (nums.length == 0) {
            return -1;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }
            //左边有序
            if (nums[mid] > nums[left]) {
                if (nums[mid] > target && nums[left] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[right] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
