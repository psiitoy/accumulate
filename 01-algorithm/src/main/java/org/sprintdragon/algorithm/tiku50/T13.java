package org.sprintdragon.algorithm.tiku50;

/**
 * 题目：一个整数，它加上100后是一个完全平方数，加上168又是一个完全平方数，请问该数是多少？
 * Created by wangdi on 17-4-24.
 */
public class T13 {

    /**
     * 1.程序分析：在10万以内判断，先将该数加上100后再开方，再将该数加上168后再开方，如果开方后的结果满足如下条件，即是结果。请看具体分析：
     *
     * @param args
     */

    public static void main(String[] args) {
        int x;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (Math.sqrt(i + 100) % 1 == 0 && Math.sqrt(i + 100 + 168) % 1 == 0) {
                System.out.println(i);
            }
        }
    }

}
