package org.sprintdragon.algorithm.lc.dp;

public class Dp121 {

    /**
     * 注意low初始化是p[0]
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int low = prices[0];
        for (int i = 0; i < prices.length; i++) {
            int val = prices[i];
            if (val < low) {
                low = val;
            }
            if (val - low > maxProfit) {
                maxProfit = val - low;
            }
        }
        return maxProfit;
    }

}
