package org.sprintdragon.algorithm.tiku50;

import java.util.Arrays;

/**
 * 题目：有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数
 * <p>
 * Created by wangdi on 17-4-25.
 */
public class T36 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rev(new int[]{1, 2, 3, 4, 5, 6}, 4)));
    }

    public static int[] rev(int[] a, int m) {
        if (a.length < m) {
            return a;
        }
        int[] cop = new int[a.length - m];
        for (int i = 0; i < a.length - m; i++) {
            cop[i] = a[i];
        }
        for (int i = 0; i < a.length; i++) {
            if (i < m) {
                a[i] = a[i + a.length - m];
            } else if (i >= m) {
                a[i] = cop[i - m];
            }
        }
        return a;
    }

}
