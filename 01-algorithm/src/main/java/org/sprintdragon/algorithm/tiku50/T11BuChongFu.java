package org.sprintdragon.algorithm.tiku50;

/**
 * 题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
 * <p>
 * Created by wangdi on 17-4-24.
 */
public class T11BuChongFu {


    public static void daAn() {
        int count = 0;
        for (int i = 1; i <= 4; i++)
            for (int j = 1; j <= 4; j++)
                for (int k = 1; k <= 4; k++)
                    if (i != j && j != k && i != k) {
                        count += 1;
                        System.out.println(i * 100 + j * 10 + k);
                    }
        System.out.println("共" + count + "个三位数");
    }

}
