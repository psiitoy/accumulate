package org.sprintdragon.algorithm.tiku50.hard;

/**
 * 题目：打印出如下图案（菱形）
 * Created by wangdi on 17-4-24.
 */
public class T19DaYinLingXing {

    /**
     * 自己实现了 根据中点下标 以及每行最大数 推算 中间左右+
     *
     * @param args
     */
    public static void main(String[] args) {

        int hang = 7;
        int max = 7;
        int middle = max / 2;   //中点下标
        for (int i = 0; i <= hang; i++) {
            if (i < middle) {
                for (int j = 0; j < max; j++) {
                    if (j >= middle - i && j <= middle + i) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            } else {
                for (int j = 0; j < max; j++) {
                    if (j >= middle - (hang - i) && j <= middle + (hang - i)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }

            System.out.println();
        }
    }

    public static void test1() {
        int hangshu = 11;
        int yiban = hangshu / 2 + 1;
        int yibanduo = hangshu / 2;
        System.out.println("空心菱形：");
        for (int k = 1; k <= yiban; k++) {
            for (int i = 1; i <= (yiban - k); i++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int i = 1; i <= ((k - 2) * 2 + 1); i++) {
                System.out.print(" ");
            }
            if (k != 1) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int k = yibanduo; k >= 1; k--) {
            for (int i = 1; i <= (yiban - k); i++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int i = 1; i <= ((k - 2) * 2 + 1); i++) {
                System.out.print(" ");
            }
            if (k != 1) {
                System.out.print("*");
            }
            System.out.println();
        }


        System.out.println("实心菱形：");
        for (int i = 1; i <= hangshu; i++) {
            if (i <= hangshu / 2 + 1) {
                for (int k = 1; k <= hangshu / 2 + 1 - i; k++) {
                    System.out.print(" ");
                }
                for (int k = 1; k <= i; k++) {
                    System.out.print("* ");
                }
                System.out.println();
            } else {
                for (int k = 1; k <= (i - (hangshu / 2 + 1)); k++) {
                    System.out.print(" ");
                }
                for (int k = 1; k <= (2 * (hangshu / 2 + 1) - i); k++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }

}
