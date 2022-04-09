package org.sprintdragon.algorithm.lc;

public class Title172 {

    public static void main(String[] args) {
        Title172 test = new Title172();
        System.out.println(test.trailingZeroes(200));
    }

    public int trailingZeroes(int n) {
        int fivePow = 0;
        int x = 5;
        while (n >= x) {
            fivePow += 1;
            x = 5 * x;
        }
        int zeroCount = 0;
        while (fivePow > 0) {
            zeroCount += n / (Math.pow(5, fivePow--));
        }
        return zeroCount;
    }

}
