package org.sprintdragon.algorithm.lc;

import java.util.Arrays;

public class Title204 {

    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == false) {
                continue;
            }
            count++;
            if ((long) i * i < n) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return count;
    }
    
}
