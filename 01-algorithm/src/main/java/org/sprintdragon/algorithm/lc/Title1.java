package org.sprintdragon.algorithm.lc;

import java.util.HashMap;
import java.util.Map;

public class Title1 {

    public static void main(String[] args) {

    }

    /**
     * 1. hashmap
     * 2. 一次遍历即可
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (map.containsKey(val)) {
                return new int[]{i, map.get(val)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
