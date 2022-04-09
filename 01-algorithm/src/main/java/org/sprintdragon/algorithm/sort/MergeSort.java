package org.sprintdragon.algorithm.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = {5, 3, 6, 2, 1, 7, 9};
        MergeSort test = new MergeSort();
        test.mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    public void mergeSort(int[] nums) {
        int[] ret = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, ret);
    }

    public void mergeSort(int[] nums, int left, int right, int[] ret) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, ret);
        mergeSort(nums, mid + 1, right, ret);
        mergeTwoSortedArray(nums, left, mid, right, ret);
    }

    private void mergeTwoSortedArray(int[] nums, int left, int mid, int right, int[] ret) {
        int indexLeft = left;
        int indexRight = mid + 1;
        int retIndex = left;
        while (indexLeft <= mid && indexRight <= right) {
            if (nums[indexLeft] <= nums[indexRight]) {
                ret[retIndex++] = nums[indexLeft++];
            } else {
                ret[retIndex++] = nums[indexRight++];
            }
        }
        while (indexLeft <= mid) {
            ret[retIndex++] = nums[indexLeft++];
        }
        while (indexRight <= right) {
            ret[retIndex++] = nums[indexRight++];
        }
        for (int i = left; i <= right; i++) {
            nums[i] = ret[i];
        }
    }

}
