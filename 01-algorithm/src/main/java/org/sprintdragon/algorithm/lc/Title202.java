package org.sprintdragon.algorithm.lc;

public class Title202 {

    public static void main(String[] args) {
        Title202 test = new Title202();
        System.out.println(test.isHappy(8));
    }

    /**
     * 只存在两种case
     * 1：回归到1
     * 2：永远循环(不会越来越大 因为考虑最大的情况21亿，即31*81 = 2511"降维打击")
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int s = n;
        int f = next(n);
        while (true) {
            s = next(s);
            f = next(next(f));
            if (s == 1 || f == 1) {
                return true;
            } else if (s == f) {
                return false;
            }
        }
    }

    public int next(int n) {
        int sum = 0;
        while (n != 0) {
            int y = n % 10;
            sum += y * y;
            n = n / 10;
        }
        return sum;
    }

}
