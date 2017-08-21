package org.sprintdragon.algorithm.tiku50;

/**
 * 题目：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。
 * Created by wangdi on 17-4-25.
 */
public class T25HuiWenShu {

    public static void main(String[] args) {
        System.out.println(huiwen(23432));
    }

    public static boolean huiwen(int n) {
        if (n / 10000 == n % 10 && (n % 10000) / 1000 == (n % 100) / 10) {
            return true;
        } else {
            return false;
        }
    }

}
