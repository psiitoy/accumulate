package org.sprintdragon.algorithm.lc;

import java.util.Arrays;
import java.util.List;

public class Title69 {

    /**
     * liweiwei 二分专题
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        if(x==0){
            return 0;
        }
        int left = 1;
        int right = x / 2;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    /**
     * 或者拿46340是整数范围的最大平方根，用这个卡
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int ans = 0;
        int l = 0;
        int r = x;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if ((long) m * m <= x) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Title69 title69 = new Title69();
        System.out.println(title69.mySqrt(8));
    }

    public int countZhi(int n) {
        int[] prime = new int[n];
        Arrays.fill(prime, 1);
        for (int i = 2; i < n; i++) {
            if (prime[i] == 1) {
                if (i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        prime[j] = 0;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 2; i < prime.length; i++) {
            count += prime[i] == 1 ? 1 : 0;
        }
        return count;
    }

}
