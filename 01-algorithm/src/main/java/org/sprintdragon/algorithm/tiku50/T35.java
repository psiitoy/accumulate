package org.sprintdragon.algorithm.tiku50;

import java.util.Arrays;

/**
 * 题目：输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组
 * Created by wangdi on 17-4-25.
 */
public class T35 {

    public static void main(String[] args) {
        int[] a = {3, 44, 12, 322, 55, 2, 11, 21, 555};
        System.out.println(Arrays.toString(change(a)));
    }

    public static int[] change(int[] n) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] > max) {
                max = n[i];
                maxIndex = i;
            }
            if (n[i] < min) {
                min = n[i];
                minIndex = i;
            }
        }
        int temp = n[maxIndex];
        n[maxIndex] = n[0];
        n[0] = temp;
        temp = n[minIndex];
        n[minIndex] = n[n.length - 1];
        n[n.length - 1] = temp;
        return n;
    }

}
