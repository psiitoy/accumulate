package org.sprintdragon.algorithm.tiku50;

import java.util.Scanner;

/**
 * 两个字符串连接程序。
 * Created by wangdi on 17-4-25.
 */
public class T46LianJieStr {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入一个字符串：");
        String str1 = in.nextLine();
        System.out.print("请再输入一个字符串：");
        String str2 = in.nextLine();
        String str = str1 + str2;
        System.out.println("连接后的字符串是：" + str);
    }

}
