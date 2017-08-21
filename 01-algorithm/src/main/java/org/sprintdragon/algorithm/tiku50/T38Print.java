package org.sprintdragon.algorithm.tiku50;

import java.util.Scanner;

/**
 * 题目:写一个函数，求一个字符串的长度，在main函数中输入字符串，并输出其长度。
 * Created by wangdi on 17-4-25.
 */
public class T38Print {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String mys = in.next();
        System.out.println(str_len(mys));
    }

    public static int str_len(String x) {
        return x.length();
    }
}
