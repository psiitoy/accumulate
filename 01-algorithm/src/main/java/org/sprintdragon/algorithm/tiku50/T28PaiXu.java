package org.sprintdragon.algorithm.tiku50;

import java.util.Arrays;

/**
 * 对10个数进行排序。
 * Created by wangdi on 17-4-25.
 */
public class T28PaiXu {

    public static int[] arr = {99, 22, 33, 55, 25, 3, 87, 2, 53, 817};

    public static void main(String[] args) {
        maoPaoPaiXu(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void maoPaoPaiXu(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
