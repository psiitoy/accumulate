package org.sprintdragon.algorithm.lc;

import java.util.HashMap;
import java.util.Map;

public class Title3 {

    public static void main(String[] args) {
        Title3 test = new Title3();
        System.out.println(test.lengthOfLongestSubstring("abba"));
    }

    /**
     * 1. 滑动窗口
     * 2. map存每个字母最新的坐标，如果有重复，取坐标+1和当前left的最大值，因为有可能已经发生过重复，left会大于坐标
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int right = 0; right < s.length(); right++) {
            Character key = s.charAt(right);
            if (map.containsKey(key)) {
                left = Math.max(left, map.get(key) + 1);
            }
            map.put(key, right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

}
