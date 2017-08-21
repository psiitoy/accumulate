package org.sprintdragon.algorithm.tiku50;

import java.util.Arrays;

/**
 * 题目：输入3个数a,b,c，按大小顺序输出
 * Created by wangdi on 17-4-25.
 */
public class T34 {

    public static void main(String[] args) {
        int[] arrays = {800, 56, 500};
        Arrays.sort(arrays);
        for (int n = 0; n < arrays.length; n++)
            System.out.println(arrays[n]);
    }

}
