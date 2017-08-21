package org.sprintdragon.algorithm.tiku50;

/**
 * 题目：求s = a + aa + aaa + aaaa + aa...a的值，其中a是一个数字。例如2 + 22 + 222 + 2222 + 22222(此时共有5个数相加)，几个数相加有键盘控制。
 * <p>
 * Created by wangdi on 17-4-24.
 */
public class T8 {


    public static void main(String[] args) {
        System.out.println(getSum(2, 5));
    }

    public static int getSum(int a, int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int in = 1;
            for (int j = 1; j < i; j++) {
                in += Math.pow(10, j);
            }
            sum += in;
        }
        return sum * a;
    }

}
