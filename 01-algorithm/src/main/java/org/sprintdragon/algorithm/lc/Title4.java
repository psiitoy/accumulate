package org.sprintdragon.algorithm.lc;

public class Title4 {

    public static void main(String[] args) {
        Title4 test = new Title4();
        int[] a = {1, 3, 6, 8};
        int[] b = {2, 7};
        System.out.println(test.findMedianSortedArrays(a, b));
    }

    /**
     * liweiwei: https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-s-114/
     * 二分专题最后一题
     * 官方题解 照猫画虎
     * 两数组叠一起，中间切一刀(一边一半数，分析线的左右四个数)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int totalLeftLen = (m + n + 1) / 2;
        int left = 0;
        int right = m;
        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = totalLeftLen - i;
            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }
        int i = left;
        int j = totalLeftLen - i;
        int num1LeftMax = i <= 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int num2LeftMax = j <= 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int num1RightMin = i >= m ? Integer.MAX_VALUE : nums1[i];
        int num2RightMin = j >= n ? Integer.MAX_VALUE : nums2[j];
        if ((m + n) % 2 == 0) {
            return (double) (Math.max(num1LeftMax, num2LeftMax) + Math.min(num1RightMin, num2RightMin)) / 2;
        } else {
            return Math.max(num1LeftMax, num2LeftMax);
        }
    }

}
