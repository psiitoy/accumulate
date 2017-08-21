package org.sprintdragon.algorithm.tiku50;

import java.util.Arrays;

/**
 * 题目：有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。
 * Created by wangdi on 17-4-25.
 */
public class T30ShuZuChaRu {

    public static int[] t = {1, 2, 3, 4, 6, 7, 8, 9};

    public static void main(String[] args) {
        insert(5);
    }

    public static void insert(int x) {
        int[] buf = new int[t.length + 1];
        boolean inFlag = false;
        for (int i = 0; i < buf.length; i++) {
            if (!inFlag && i < t.length && t[i] > x) {
                inFlag = true;
                buf[i] = x;
                continue;
            }
            if (!inFlag && i < t.length) {
                buf[i] = t[i];
            } else {
                buf[i] = t[i - 1];
            }
        }
        System.out.println(Arrays.toString(buf));
    }

}
