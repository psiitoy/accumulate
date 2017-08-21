package org.sprintdragon.algorithm.tiku50.hard;

/**
 * 题目：一个偶数总能表示为两个素数之和。（注：哥德巴赫猜想是想证明对任何大于6的自然数n之内的所有偶数可以表示为两个素数之和）
 * Created by wangdi on 17-4-25.
 */
public class T44GeDeBaHe {

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 6; i <= 100; i += 2) {
            for (int j = 2; j < 100; j++) {
                if (!isPrime(j) || !isPrime(i - j) || j >= i)
                    continue;
                System.out.println(i + "=" + j + "+" + (i - j));
                break;
            }
        }
    }

}
