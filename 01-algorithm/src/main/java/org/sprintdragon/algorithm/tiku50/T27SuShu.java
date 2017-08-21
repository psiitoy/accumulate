package org.sprintdragon.algorithm.tiku50;

/**
 * 题目：求100之内的素数
 * Created by wangdi on 17-4-25.
 */
public class T27SuShu {

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(i + " ");
            }
        }
    }

}
