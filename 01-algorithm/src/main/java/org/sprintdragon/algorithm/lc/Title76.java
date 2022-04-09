package org.sprintdragon.algorithm.lc;

import java.util.HashMap;
import java.util.Map;

public class Title76 {

    public static void main(String[] args) {
        Title76 test = new Title76();
        System.out.println(test.minWindow("aa", "aa"));
    }

    /**
     * 滑动窗口法
     * 1. 注意因为有可能t存在重复，所以比较distance和t的mapSize
     * 2. 另外，数值范围为-128到127，在此范围内可以==，超过需要使用equal，所以比较Integer用equal
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (!tMap.containsKey(c)) {
                tMap.put(c, 0);
                windowMap.put(c, 0);
            }
            tMap.put(c, tMap.get(c) + 1);
        }
        int sLen = s.length();
        int tSize = tMap.size();
        int distance = 0;
        int minLen = sLen + 1;
        int minIdx = -1;
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        while (right < sLen) {
            char c = chars[right];
            if (!tMap.containsKey(c)) {
                right++;
                continue;
            }
            windowMap.put(c, windowMap.get(c) + 1);
            if (windowMap.get(c).equals(tMap.get(c))) {
                distance++;
            }
            while (distance == tSize) {
                c = chars[left];
                if (!tMap.containsKey(c)) {
                    left++;
                    continue;
                }
                windowMap.put(c, windowMap.get(c) - 1);
                if (windowMap.get(c) < tMap.get(c)) {
                    distance--;
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        minIdx = left;
                    }
                }
                left++;
            }
            right++;
        }
        if (minLen == sLen + 1) {
            return "";
        }
        return s.substring(minIdx, minIdx + minLen);
    }


}
