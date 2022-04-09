package org.sprintdragon.algorithm.lc;

import java.util.HashSet;
import java.util.Set;

public class AForTest {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        AForTest a = new AForTest();
        System.out.println(a.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        for (int begin = 0; begin < s.length(); begin++) {
            Set<Character> chs = new HashSet<>(s.length());
            int cur = begin;
            while (cur < s.length() && !chs.contains(s.charAt(cur))) {
                chs.add(s.charAt(cur));
                cur++;
            }
            res = cur - begin > res ? cur - begin : res;
            begin = cur;
        }
        return res;
    }

}
