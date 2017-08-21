package org.sprintdragon.algorithm.tiku50;

/**
 * 题目：有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。问第4个人岁数，他说比第3个人大2岁。问第三个人，又说比第2人大两岁。问第2个人，说比第一个人大两
 * 岁。最后问第一个人，他说是10岁。请问第五个人多大？
 * Created by wangdi on 17-4-25.
 */
public class T23DiGuiSuiShu {

    public static void main(String[] args) {
        int s = 10;
        for (int i = 0; i < 4; i++) {
            s = s + 2;
        }
        System.out.println(s);
        System.out.println("digui fa:" + digui(5));
    }

    public static int digui(int n) {
        if (n == 1) {
            return 10;
        } else {
            return digui(n - 1) + 2;
        }
    }

}
