package org.sprintdragon.algorithm.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Title56 {

    public static void main(String[] args) {
        Title56 test = new Title56();
        int[][] intervals = {{1, 4}, {4, 5}};
        test.print(test.merge(intervals));
    }

    public void print(int[][] arrs) {
        for (int[] a : arrs) {
            System.out.println(Arrays.toString(a));
        }
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> retList = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            if (retList.isEmpty()) {
                retList.add(intervals[i]);
            } else {
                int[] merge = retList.get(retList.size() - 1);
                if (intervals[i][0] <= merge[1]) {
                    merge[1] = Math.max(intervals[i][1], merge[1]);
                } else {
                    retList.add(intervals[i]);
                }
            }
        }
        int[][] ret = new int[retList.size()][2];
        for (int i = 0; i < retList.size(); i++) {
            ret[i] = retList.get(i);
        }
        return ret;
    }

}
