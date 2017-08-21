package org.sprintdragon.algorithm.tiku50;

import java.util.Calendar;
import java.util.Scanner;

/**
 *  题目：输入某年某月某日，判断这一天是这一年的第几天？
 *
 * Created by wangdi on 17-4-24.
 */
public class T14WhenDay {

    public static void main(String[] args) {
        System.out.println("请输入年,月,日：");
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        int sum = cal.get(Calendar.DAY_OF_YEAR);
        System.out.println("这一天是这一年的第" + sum + "天");
    }

}
