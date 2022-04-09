package org.sprintdragon.algorithm.lc;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Title239 {

    public static void main(String[] args) {
        Title239 test = new Title239();
        int[] a = {4, -7, -8, 7, 5, 7, 1, 6, 0};
//        int[] a = {1, -1};
        System.out.println(Arrays.toString(test.maxSlidingWindow(a, 4)));
    }

    /**
     * 也可以不封装，直接用queue
     * 1. 核心思路就是单调队列，即，头部最大值，尾部入队列时把小于入值的都清理掉，保证顺序性
     * 2. 头部一定最大，尾部每次pop时判断一下是不是要清理的值(有可能push的时候已经清理过了)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonoQueue queue = new MonoQueue();
        int len = nums.length;
        int[] ret = new int[len - k + 1];
        for (int i = 0; i < k - 1; i++) {
            queue.push(nums[i]);
        }
        for (int i = 0; i < len - k + 1; i++) {
            queue.push(nums[i + k - 1]);
            ret[i] = queue.max();
            queue.pop(nums[i]);
        }
        return ret;
    }

    static class MonoQueue {
        Deque<Integer> queue;

        public MonoQueue() {
            this.queue = new LinkedList<>();
        }

        public void pop(int n) {
            if (!queue.isEmpty() && queue.peekFirst() == n) {
                queue.pollFirst();
            }
        }

        public Integer max() {
            return queue.peekFirst();
        }

        public void push(int n) {
            while (!queue.isEmpty() && queue.peekLast() < n) {
                queue.pollLast();
            }
            queue.addLast(n);
        }

    }

}
