package org.sprintdragon.algorithm.tiku50;

/**
 * 【程序5】   题目：利用条件运算符的嵌套来完成此题：学习成绩=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
 * <p>
 * Created by wangdi on 17-4-21.
 */
public class T5ChengJi {

    public static void main(String[] args) {
        int score = 33;
        System.out.println(score >= 90 ? "A" : score < 60 ? "C" : "B");
    }

}
