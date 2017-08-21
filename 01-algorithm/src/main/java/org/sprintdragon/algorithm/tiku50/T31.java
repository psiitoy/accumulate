package org.sprintdragon.algorithm.tiku50;

/**
 * 题目：将一个数组逆序输出。
 * Created by wangdi on 17-4-25.
 */
public class T31 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.print(a[i] + " ");
        }
    }

}
