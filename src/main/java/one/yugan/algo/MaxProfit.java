package one.yugan.algo;

import one.yugan.DataStructuresCollect;

/**
 * @author : yugan.
 * @date : 2023/8/20
 * @email : eureka_sacha@outlook.com
 */
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

}
