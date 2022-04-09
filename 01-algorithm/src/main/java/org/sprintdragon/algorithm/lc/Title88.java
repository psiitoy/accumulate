package org.sprintdragon.algorithm.lc;

public class Title88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int indexA = m - 1;
        int indexB = n - 1;
        int index = len - 1;
        while (indexA >= 0 && indexB >= 0) {
            if (nums1[indexA] >= nums2[indexB]) {
                nums1[index--] = nums1[indexA--];
            } else {
                nums1[index--] = nums2[indexB--];
            }
        }
        while (indexA >= 0 || indexB >= 0) {
            if (indexA >= 0) {
                nums1[index--] = nums1[indexA--];
            } else {
                nums1[index--] = nums2[indexB--];
            }
        }
    }

}
