package org.sprintdragon.algorithm.lc.binarysearch;

public class Title1300 {

    /**
     * https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/solution/er-fen-cha-zhao-by-liweiwei1419-2/
     * wei 哥，这道题的思路是这样的吗：
     * value 的取值范围为[0, 数组中的最大值]，找最接近的，
     * 分两种情况，第一种就是第一个大于等于的（因为是大于等于，所以要与前面一个值进行比较，也就是 left - 1），
     * 第二种就是最后一个小于等于的（因为小于等于，所以要与后面一个值进行比较，也就是 left + 1）。
     *
     * @param arr
     * @param target
     * @return
     */
    public int findBestValue(int[] arr, int target) {
        int left = 0;
        int right = 0;
        for (int num : arr) {
            right = Math.max(right, num);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = mathSum(arr, mid);
            if (sum < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int sumL = mathSum(arr, left - 1);
        if (target - mathSum(arr, left - 1) <= mathSum(arr, left) - target) {
            return left - 1;
        }
        return left;
    }

    private int mathSum(int[] arr, int mid) {
        int sum = 0;
        for (int num : arr) {
            sum += num > mid ? mid : num;
        }
        return sum;
    }

}
