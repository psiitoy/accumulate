package org.sprintdragon.algorithm.lc;

import java.util.Random;

public class TItle384 {

    static class Solution {
        int[] nums;
        Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            int ranNums[] = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                ranNums[i] = nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                swap(ranNums, i, random.nextInt(nums.length));
            }
            return ranNums;
        }

        private void swap(int[] nums, int a, int b) {
            if (a != b) {
                int tmp = nums[a];
                nums[a] = nums[b];
                nums[b] = tmp;
            }
        }
    }
    
}
