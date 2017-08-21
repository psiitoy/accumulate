package org.sprintdragon.algorithm.tiku50.hard;

/**
 * 题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
 * Created by wangdi on 17-4-25.
 */
public class T20FenZiFenMu {

    /**
     * 程序分析：请抓住分子与分母的变化规律。
     *
     * @param args
     */
    public static void main(String[] args) {
        float fm = 1.0f;
        float fz = 1.0f;
        float temp;
        float sum = 0f;
        for (int i = 0; i < 20; i++) {
            temp = fm;
            fm = fz;
            fz = fz + temp;
            System.out.println((int) fz + "/" + (int) fm);
            sum += fz / fm;
        }
        System.out.println(sum);
    }

}
