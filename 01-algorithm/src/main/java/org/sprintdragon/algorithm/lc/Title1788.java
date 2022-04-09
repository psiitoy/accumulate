package org.sprintdragon.algorithm.lc;

import java.util.*;

public class Title1788 {

    public int maximumBeauty(int[] flowers) {
        Set<Integer> keys = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] prefix = new int[flowers.length + 1];
        for (int i = 0; i < flowers.length; i++) {
            int key = flowers[i];
            prefix[i + 1] = prefix[i] + (key > 0 ? key : 0);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            List<Integer> vals = map.get(key);
            vals.add(i);
            if (vals.size() > 1) {
                keys.add(key);
            }
            map.put(key, vals);
        }
        int res = Integer.MIN_VALUE;
        for (int key : keys) {
            List<Integer> idxList = map.get(key);
            int left = idxList.get(0);
            int right = idxList.get(idxList.size() - 1);
            int max = prefix[right + 1] - prefix[left];
            if (flowers[left] < 0) {
                max += 2 * flowers[left];
            }
            res = Math.max(res, max);
        }
        return res;
    }
}
