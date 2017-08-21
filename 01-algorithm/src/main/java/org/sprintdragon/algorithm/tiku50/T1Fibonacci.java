package org.sprintdragon.algorithm.tiku50;

/**
 * 【程序1】   题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第四个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * <p>
 * Created by wangdi on 17-4-18.
 */
public class T1Fibonacci {

    /**
     * 1.程序分析：兔子的规律为数列1,1,2,3,5,8,13,21....
     * 斐波那契数列
     *
     * @param args
     */

    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 1; i <= arr.length; i++) {
            arr[i - 1] = fib1(i);
        }

        for (int i = 1; i <= arr.length; i++) {
            System.out.print(arr[i - 1] + " ");
            if (i % 5 == 0) {
                System.out.println();
            }
        }
    }

    public static int fib1(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return fib1(n - 2) + fib1(n - 1);
        }
    }

}
