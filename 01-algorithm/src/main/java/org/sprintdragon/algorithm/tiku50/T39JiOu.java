package org.sprintdragon.algorithm.tiku50;

/**
 * 题目：编写一个函数，输入n为偶数时，调用函数求1/2+1/4+...+1/n,当输入n为奇数时，调用函数1/1+1/3+...+1/n
 * Created by wangdi on 17-4-25.
 */
public class T39JiOu {

    public static void main(String[] args) {
        System.out.println(sum(9));
    }

    public static double sum(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % 2 == 0 && i % 2 == 0) {
                sum += 1 / (double) i;
                System.out.print(i + " ");
            } else if (n % 2 != 0 && i % 2 != 0) {
                sum += 1 / (double) i;
                System.out.print(i + " ");
            }
        }
        return sum;
    }

}
