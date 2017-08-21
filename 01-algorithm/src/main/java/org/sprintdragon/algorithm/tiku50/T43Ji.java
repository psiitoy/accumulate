package org.sprintdragon.algorithm.tiku50;

/**
 * 题目：求0—7所能组成的奇数个数。
 * Created by wangdi on 17-4-25.
 */
public class T43Ji {
    //个人算法：
    //组成1位数是4个。
//组成2位数是7*4个。
//组成3位数是7*8*4个。
//组成4位数是7*8*8*4个。
//......
    public static void main(String[] args) {
        int sum = 4;
        int j;
        System.out.println("组成1位数是 " + sum + " 个");
        sum = sum * 7;
        System.out.println("组成2位数是 " + sum + " 个");
        for (j = 3; j <= 9; j++) {
            sum = sum * 8;
            System.out.println("组成" + j + "位数是 " + sum + " 个");
        }
    }

}
