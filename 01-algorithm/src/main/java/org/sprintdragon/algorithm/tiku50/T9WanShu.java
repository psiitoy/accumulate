package org.sprintdragon.algorithm.tiku50;

/**
 * 题目：一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3。编程找出1000以内的所有完数。
 * <p>
 * 因字数 包质数因子和非质数因子
 * Created by wangdi on 17-4-24.
 */
public class T9WanShu {

    public static void main(String[] args) {
        for (int i = 1; i < 1000; i++) {
            int temp = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    temp += j;
                }
            }
            if (temp == i) {
                System.out.print(i + " ");
            }
        }
    }

}
