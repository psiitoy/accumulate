package org.sprintdragon.algorithm.jg.offer;

public class Offer51 {

    public static void main(String[] args) {
        Offer51 test = new Offer51();
        int[] a = {7, 5, 6, 4};
        System.out.println(test.reversePairs(a));
    }

    int reverseCount = 0;

    /**
     * 对比归并排序，只需要加 一行!! 即右边大于左边 merge的时候，左边剩余的都是逆序对，mid-leftIndex+1  (比如左边最后一个走到了mid，那么就是1)
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        int[] ret = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, ret);
        return reverseCount;
    }

    public void mergeSort(int[] nums, int left, int right, int[] ret) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, ret);
        mergeSort(nums, mid + 1, right, ret);
        merge(nums, left, mid, right, ret);
    }

    private void merge(int[] nums, int left, int mid, int right, int[] ret) {
        int indexLeft = left;
        int indexRight = mid + 1;
        int retIndex = left;
        while (indexLeft <= mid && indexRight <= right) {
            if (nums[indexLeft] <= nums[indexRight]) {
                ret[retIndex++] = nums[indexLeft++];
            } else {
                ret[retIndex++] = nums[indexRight++];
                reverseCount += mid - indexLeft + 1;
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
