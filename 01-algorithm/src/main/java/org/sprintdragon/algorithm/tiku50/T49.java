package org.sprintdragon.algorithm.tiku50;

import java.util.Scanner;

/**
 * 题目：计算字符串中子串出现的次数。
 * Created by wangdi on 17-4-25.
 */
public class T49 {

    public static void main(String[] args) {
        String a = "abcabcd";
        String b = "bc";
        int count = 0;
        for (int i = 0; i < a.length() - b.length(); i++) {
            if (b.equals(a.substring(i, i + b.length()))) {
                System.out.println("b=" + b + ",sub=" + a.substring(i, i + b.length()));
                count++;
            }
        }
        System.out.println(count);
    }

    public static void test1() {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入主串：");
        String str1 = in.nextLine();
        System.out.println("请输入子串：");
        String str2 = in.nextLine();
        // 生成子串长度的N个字符串数组
        String[] sa = new String[str1.length() - str2.length() + 1];
        for (int i = 0; i < sa.length; i++) {
            sa[i] = str1.substring(i, i + str2.length());
        }
        int sum = 0;
        // 子串与N个拆开的子串比对
        for (int i = 0; i < sa.length; i++) {
            if (sa[i].equals(str2)) {
                // 成功配对，计数器+1；
                sum++;
                // 因为不计算重叠的子串，所以跳过配对之后的部分拆分子串
                i = i + str2.length();
            }
        }
        System.out.println("主串中共包含" + sum + "个字串");
    }
}
