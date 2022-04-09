package org.sprintdragon.algorithm.lc;

import java.util.Arrays;

public class Title189 {

    public static void main(String[] args) {
        Title189 test = new Title189();
        int[] nums = {1, 2, 3};
        test.rotate(nums, 4);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * nums = "----->-->"; k =3
     * result = "-->----->";
     * <p>
     * reverse "----->-->" we can get "<--<-----"
     * reverse "<--" we can get "--><-----"
     * reverse "<-----" we can get "-->----->"
     * this visualization help me figure it out :)
     * 1. 注意翻转法 k要取模，避免越界
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        revert(nums, 0, nums.length - 1);
        revert(nums, 0, k - 1);
        revert(nums, k, nums.length - 1);
    }

    public void revert(int[] nums, int left, int right) {
        if (left < 0 || right >= nums.length) {
            return;
        }
        while (left < right) {
            swap(nums, left++, right--);
        }
    }


    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    /**
     * 自创 循环交换，可能涉及到和k为公约数，需要处理永远循环的问题，即++
     *
     * @param nums
     * @param k
     */
    public void moveArr(int[] nums, int k) {
        if (k == 0 || nums.length == 1) {
            return;
        }
        int len = nums.length;
        int currentIdx = 0;
        int fromIndex = 0;
        for (int i = 0; i < len; i++) {
            currentIdx = (currentIdx + k) % len;
            if (currentIdx == fromIndex) {
                fromIndex++;
                currentIdx++;
            }
            if (fromIndex >= len || currentIdx >= len) {
                break;
            }
            swap(nums, fromIndex, currentIdx);
        }
    }

}
