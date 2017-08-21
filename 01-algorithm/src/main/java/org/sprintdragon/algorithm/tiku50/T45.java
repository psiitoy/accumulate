package org.sprintdragon.algorithm.tiku50;

/**
 * 题目：（1）判断几个9能被一个素数整除。（2）判断一个整数能被几个9整除。（原题：一个素数能被几个9整除）
 * Created by wangdi on 17-4-25.
 */
public class T45 {

    public static void main(String[] args) {
//        test1();
        System.out.println(test2(999));
    }

    public static int test2(int n) {
        int x = 10;
        int count = 0;
        while (true) {
            if (n < x - 1) {
                break;
            }
            if (n % (x - 1) == 0) {
                count++;
            }
            x *= 10;
        }
        return count;
    }

    public static void test1() {
        int x = 10;
        while (true) {
            for (int i = 2; i < x - 1; i++) {
                if (isSu(i) && (x - 1) % i == 0) {
                    System.out.println("x-1=" + (x - 1 + ",i=" + i));
                }
            }
            x *= 10;
        }
    }

    public static boolean isSu(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
