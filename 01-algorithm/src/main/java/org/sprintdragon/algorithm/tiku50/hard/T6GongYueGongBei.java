package org.sprintdragon.algorithm.tiku50.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 【程序6】   题目：输入两个正整数m和n，求其最大公约数和最小公倍数。
 * Created by wangdi on 17-4-21.
 */
public class T6GongYueGongBei {

    public static void main(String[] args) {
        System.out.println(gongyue(60, 24));
    }

    /**
     * 1.程序分析：利用辗除法。
     *
     * @param x
     * @param y
     * @return
     */

    public static int commonDivisor(int x, int y) {
        if (x < y) {
            int t = x;
            x = y;
            y = t;
        }
        while (y != 0) {
            if (x == y) return x;
            else {
                int k = x % y;
                x = y;
                y = k;
            }
        }
        return x;
    }

    public static int gongyue(int m, int n) {
        List<Integer> mZs = zhiShuFenJie(m, null);
        List<Integer> nZs = zhiShuFenJie(n, null);
        int gy = 1;
//        for (Integer x : mZs) {
//            for (Integer y : nZs) {
//                if (x == y) {
//                    gy = gy * x;
//                } else {
//                    return gy;
//                }
//            }
//        }
        return gy;
    }

    public static List<Integer> zhiShuFenJie(int x, List<Integer> buf) {
        if (buf == null) {
            buf = new ArrayList<>();
        }
        for (int i = 2; i <= x; i++) {
            if (x % i == 0) {
                buf.add(i);
                return zhiShuFenJie(x / i, buf);
            }
        }
        return buf;
    }

}
