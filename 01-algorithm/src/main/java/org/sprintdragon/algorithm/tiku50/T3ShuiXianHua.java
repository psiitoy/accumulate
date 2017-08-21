package org.sprintdragon.algorithm.tiku50;

/**
 * 【程序3】   题目：打印出所有的 水仙花数 ，所谓 水仙花数 是指一个三位数，其各位数字立方和等于该数本身。
 * 例如：153是一个 水仙花数 ，因为153=1的三次方＋5的三次方＋3的三次方。
 * <p>
 * Created by wangdi on 17-4-21.
 */
public class T3ShuiXianHua {

    /**
     * 1.程序分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位。
     *
     * @param args
     */

    public static void main(String[] args) {
        for (int i = 100; i <= 999; i++) {
            int b = i / 100;
            int s = i % 100 / 10;
            int g = i % 10;
            if (b * b * b + s * s * s + g * g * g == i) {
                System.out.print(i + " ");
            }
        }
    }

}