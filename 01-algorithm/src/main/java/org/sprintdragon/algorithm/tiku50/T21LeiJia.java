package org.sprintdragon.algorithm.tiku50;

/**
 * 题目：求1+2!+3!+...+20!的和。
 * Created by wangdi on 17-4-25.
 */
public class T21LeiJia {

    /**
     * 程序分析：此程序只是把累加变成了累乘。
     *
     * @param args
     */
    public static void main(String[] args) {
        long sum = 0;
        long fac = 1;
        for (int i = 1; i <= 20; i++) {
            fac = fac * i;
            sum += fac;
        }
        System.out.println(sum);
    }

}
