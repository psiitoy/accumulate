package org.sprintdragon.algorithm.lc;

public class Title5 {

    public static void main(String[] args) {
        Title5 test = new Title5();
        System.out.println(test.longestPalindrome("a"));
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        String res = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String p0 = getPalindrome(s, i, i);
            if (s.charAt(i) == s.charAt(i + 1)) {
                String p1 = getPalindrome(s, i, i + 1);
                p0 = p0.length() > p1.length() ? p0 : p1;

            }
            res = res.length() > p0.length() ? res : p0;
        }
        return res;
    }

    public String getPalindrome(String s, int left, int right) {
        while (left > 0 && right < s.length() - 1) {
            if (s.charAt(left - 1) != s.charAt(right + 1)) {
                break;
            }
            left--;
            right++;
        }
        return s.substring(left, right + 1);
    }

}
