package org.sprintdragon.algorithm.tiku50;

/**
 * 题目：取一个整数a从右端开始的第4～7位数字。
 * Created by wangdi on 17-4-25.
 */
public class T32 {

    public static void main(String[] args) {
        System.out.println(get4dao7(12345671));
    }

    public static int get4dao7(int x) {
        char[] c = String.valueOf(x).toCharArray();
        if (c.length < 7) {
            return 0;
        }
        String s = "";
        for (int i = c.length - 7; i <= c.length - 4; i++) {
            s += c[i];
        }
        return Integer.valueOf(s);
    }

}
