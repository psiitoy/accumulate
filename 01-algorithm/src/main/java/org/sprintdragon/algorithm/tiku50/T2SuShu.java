package org.sprintdragon.algorithm.tiku50;

import java.util.ArrayList;
import java.util.List;

/**
 * 【程序2】   题目：判断101-200之间有多少个素数，并输出所有素数。
 * Created by wangdi on 17-4-21.
 */
public class T2SuShu {

    /**
     * 1.程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除，则表明此数不是素数，反之是素数。
     *
     * @param args
     */

    public static void main(String[] args) {
        getSu1();
        getSu2();
    }

    public static void getSu1() {
        List<Integer> all = new ArrayList<>();
        List<Integer> nosu = new ArrayList<>();
        for (int i = 101; i <= 200; i++) {
            all.add(i);
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    nosu.add(i);
                    break;
                }
            }
        }
        all.removeAll(nosu);
        System.out.println(all);
    }

    public static void getSu2() {
        for (int i = 101; i <= 200; i++) {
            boolean suFlag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    suFlag = false;
                    break;
                }
            }
            if (suFlag) {
                System.out.print(i + " ");
            }
        }
    }

}
