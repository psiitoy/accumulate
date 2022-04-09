package org.sprintdragon.algorithm.lc;

public class Title171 {

    public static void main(String[] args) {
        Title171 test = new Title171();
        System.out.println(test.titleToNumber2("ZY"));
    }

    public int titleToNumber(String columnTitle) {
        int sum = 0;
        int len = columnTitle.length();
        for (int i = len - 1; i >= 0; i--) {
            int val = columnTitle.charAt(i) - 'A' + 1;
            sum += Math.pow(26, len - i - 1) * val;
        }
        return sum;
    }

    public int titleToNumber2(String columnTitle) {
        int sum = 0;
        int len = columnTitle.length();
        for (int i = 0; i < len; i++) {
            int val = columnTitle.charAt(i) - 'A' + 1;
            sum = sum * 26 + val;
        }
        return sum;
    }

}
