package org.sprintdragon.algorithm.weapon;

public class MyKmp {

    /**
     * 参考视频:https://www.bilibili.com/video/BV1M5411j7Xx?from=search&seid=2289335004084826729
     *
     * aabaabaaf
     * aabaaf
     * 010120
     */
    /**
     * 生成next数组 (和主串不匹配我们是回退前一位的next值的位置)
     * 1. 初始化next
     * 2. 当p[i]!=p[j]时
     * 3. 当p[i]==p[j]时
     * 4. next[i] 赋值
     *
     * @param p 模式串
     */
    public int[] genNext(String p) {
        int len = p.length();
        int[] next = new int[len];
        //i,前缀末尾，j，后缀末尾(还隐含着最长前后缀长度) 初始j(1)要比i(0)大，才可以进行比较
        int j = 0;
        char[] chars = p.toCharArray();
        for (int i = 1; i < len; i++) {
            while (j > 0 && chars[i] != chars[j]) {
                j = next[j - 1];
            }
            if (chars[i] == chars[j]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     * 拿leetcode28 举例 遍历主串
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = genNext(needle);
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int pLen = p.length;
        int j = 0;
        for (int i = 0; i < s.length && j < p.length; i++) {
            while (j > 0 && s[i] != p[j]) {
                j = next[j - 1];
            }
            if (s[i] == p[j]) {
                j++;
            }
            if (j == pLen) {
                return i - j + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MyKmp test = new MyKmp();
//        System.out.println(Arrays.toString(test.genNext("aabaaf")));

//        System.out.println(test.strStr("aabaabaaf", "aabaaf"));
//        System.out.println(test.strStr("mississippi", "issipi"));
        System.out.println(test.strStr("hello", "ll"));
    }

}
