package org.sprintdragon.algorithm.tiku50;

/**
 * 题目：利用递归方法求5!。
 * Created by wangdi on 17-4-25.
 */
public class T22DiGui {

    /**
     * 程序分析：递归公式：f(n)=f(n-1)*4!
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(jieCheng(4));
    }

    public static Integer jieCheng(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * jieCheng(n - 1);
        }
    }

}
