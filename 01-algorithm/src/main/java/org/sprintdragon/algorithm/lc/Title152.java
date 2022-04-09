package org.sprintdragon.algorithm.lc;

public class Title152 {


    /**
     * 脑筋急转弯，没有想到，维护3个变量，最大变最小最小变最大
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mi = min;
            int mx = max;
            max = Math.max(Math.max(mx * nums[i], nums[i]), mi * nums[i]);
            min = Math.min(Math.min(mx * nums[i], nums[i]), mi * nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }

}
