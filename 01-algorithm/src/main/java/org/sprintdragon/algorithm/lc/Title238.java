package org.sprintdragon.algorithm.lc;

public class Title238 {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];
        int product = 1;
        for (int i = 0; i < len; i++) {
            output[i] = product;
            product *= nums[i];
        }
        product = 1;
        for (int i = len - 1; i >= 0; i--) {
            output[i] = output[i] * product;
            product *= nums[i];
        }
        return output;
    }

}
