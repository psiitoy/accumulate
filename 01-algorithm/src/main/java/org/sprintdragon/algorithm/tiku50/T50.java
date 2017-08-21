package org.sprintdragon.algorithm.tiku50;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * 题目：有五个学生，每个学生有3门课的成绩，从键盘输入以上数据（包括学生号，姓名，三门课成绩），
 * 计算出平均成绩，把原有的数据和计算出的平均分数存放在磁盘文import java.io.File;
 * Created by wangdi on 17-4-25.
 */
public class T50 {
    public static Student input() {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入学号：");
        int num = s.nextInt();
        System.out.println("请输入姓名：");
        String name = s.next();
        System.out.println("请分别输入3门成绩：");
        double[] a = new double[3];
        for (int i = 0; i < 3; i++) {
            a[i] = s.nextDouble();
        }
        return new Student(num, name, a);
    }

    public static void main(String[] args) throws Exception {
        Student[] st = new Student[2];
        for (int i = 0; i < st.length; i++) {
            st[i] = input();
        }
        File f = new File("d:" + File.separator + "123.txt");
        FileWriter output = new FileWriter(f);
        for (int i = 0; i < st.length; i++) {
            output.write(st[i].toString() + "\r\n");
            output.write("\r\n");
        }
        output.close();
    }
}

class Student {
    private int number = 0;
    private String name = "";
    private double[] a = new double[3];

    public double getAve() {
        return (a[0] + a[1] + a[2]) / 3;
    }

    public Student(int number, String name, double[] a) {
        super();
        this.number = number;
        this.name = name;
        this.a = a;
    }

    @Override
    public String toString() {
        return "学号：" + this.number + "\t姓名：" + this.name + "\r\n各科成绩：\r\n" + a[0] + "\t" + a[1] + "\t" + a[2] + "\r\n平均成绩：\r\n"
                + this.getAve();
    }
}