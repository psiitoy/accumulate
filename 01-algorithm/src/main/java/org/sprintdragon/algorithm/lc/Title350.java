package org.sprintdragon.algorithm.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Title350 {

    /**
     * 进阶三问：
     * 有序用双指针(q1)
     * 大小差别大用map(q2)
     * map存较小的，较大的不需要入内存，直接比较(q3)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] bigger = nums1.length > nums2.length ? nums1 : nums2;
        int[] smaller = nums1.length > nums2.length ? nums2 : nums1;
        Map<Integer, Integer> map = new HashMap<>(bigger.length);
        List<Integer> retList = new ArrayList<>();
        for (int n : bigger) {
            if (!map.containsKey(n)) {
                map.put(n, 0);
            }
            map.put(n, map.get(n) + 1);
        }
        for (int n : smaller) {
            if (map.containsKey(n)) {
                int num = map.get(n);
                map.put(n, num - 1);
                if (num - 1 == 0) {
                    map.remove(n);
                }
                retList.add(n);
            }
        }
        int[] ret = new int[retList.size()];
        for (int i = 0; i < retList.size(); i++) {
            ret[i] = retList.get(i);
        }
        return ret;
    }

}
