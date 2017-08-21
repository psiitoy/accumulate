package org.sprintdragon.algorithm.tiku50;

/**
 * 输出9*9口诀乘法表。
 * Created by wangdi on 17-4-24.
 */
public class T16Xiao99 {

    public static void main(String[] args) {
    }

    /**
     * 1.程序分析：分行与列考虑，共9行9列，i控制行，j控制列。
     * 出现重复的乘积（全矩形）
     */
    public static void wanQuanJuXing() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.print(i + " * " + j + " = " + i * j + " ");
            }
            System.out.println();
        }
    }

    /**
     * 不现重复的乘积(下三角)
     */
    public static void xiaSanJiao() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " * " + j + " = " + i * j + " ");
            }
            System.out.println();
        }
    }
}
