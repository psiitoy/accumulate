package org.sprintdragon.algorithm.lc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Title628 {

    public int maximumProduct1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }

    /**
     * 线性扫描 不用栈 直接变量
     *
     * @param nums
     * @return
     */
    public int maximumProduct2(int[] nums) {
        int len = nums.length;
        if (len == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        PriorityQueue<Integer> maxStack = new PriorityQueue<>(3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> minStack = new PriorityQueue<>(2);
        for (int i = 0; i < len; i++) {
            int val = nums[i];
            minStack.offer(val);
            maxStack.offer(val);
        }
        int maxNum = maxStack.poll();
        return Math.max(maxNum * maxStack.poll() * maxStack.poll(), maxNum * minStack.poll() * minStack.poll());
    }

}
