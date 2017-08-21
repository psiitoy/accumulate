package org.sprintdragon.algorithm.tiku50;

/**
 * 题目：求一个3*3矩阵主对角线元素之和。
 * Created by wangdi on 17-4-25.
 */
public class T29JuZhenDuiJiaoXian {

    public static int[][] arrs = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    public static void main(String[] args) {
        for (int i = 0; i < arrs[0].length; i++) {
            for (int j = 0; j < arrs.length; j++) {
                if (i == j || i + j == arrs.length - 1) {
                    System.out.print(arrs[i][j]);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
