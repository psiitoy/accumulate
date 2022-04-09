package org.sprintdragon.algorithm.lc;

public class Title50 {

    public static void main(String[] args) {
        Title50 test = new Title50();
        System.out.println(test.myPow(2.00000, -2147483648));
    }

    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        } else if (n > 0) {
            return myPowHelper(x, n);
        } else {
            return myPowHelper(1 / x, Math.abs(n));
        }
    }

    public double myPowHelper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            double half = myPowHelper(x, n / 2);
            return half * half;
        } else {
            double half = myPowHelper(x, n / 2);
            return half * half * x;
        }
    }


    public double myPowForce(double x, int n) {
        double sum = 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        for (int i = 0; i < n; i++) {
            sum *= x;
        }
        return sum;
    }

}
