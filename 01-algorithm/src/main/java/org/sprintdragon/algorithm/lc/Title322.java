package org.sprintdragon.algorithm.lc;

import java.util.Arrays;

public class Title322 {

    public static void main(String[] args) {
        Title322 test = new Title322();
        int[] a = {186, 419, 83, 408};
        int b = 6249;
        System.out.println(test.coinChange(a, b));
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return process(coins, amount, coins.length - 1);
    }

    public int process(int[] coins, int amount, int index) {
        if (amount == 0) {
            return 0;
        }
        boolean canChange = false;
        for (int i = index; i >= 0; i--) {
            if (coins[i] <= amount) {
                canChange = true;
                index = i;
                break;
            }
        }
        if (!canChange) {
            return -1;
        }
        int totalCount = -1;
        for (int i = index; i >= 0; i--) {
            int coinNum = amount / coins[i];
            if (coins[i] == amount) {
                return 1;
            } else if (amount % coins[i] == 0) {
                totalCount = totalCount == -1 ? coinNum : Math.min(totalCount, coinNum);
            } else if (coins[i] < amount) {
                int remain = amount % coins[i];
                int c = process(coins, remain, i - 1);
                if (c != -1) {
                    c = coinNum + c;
                    totalCount = totalCount == -1 ? c : Math.min(totalCount, c);
                }
            }
        }
        return totalCount;
    }

}
