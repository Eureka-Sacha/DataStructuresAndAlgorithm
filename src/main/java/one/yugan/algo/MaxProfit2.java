package one.yugan.algo;

/**
 * @author : yugan.
 * @date : 2023/8/20
 * @email : eureka_sacha@outlook.com
 */
public class MaxProfit2 {
    public static int maxProfit(int[] prices) {
        int cash = 0;
        int hold = -prices[0];

        int preCash = cash;
        int preHold = hold;
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(preCash, preHold + prices[i]);
            hold = Math.max(preHold, preCash - prices[i]);

            preCash = cash;
            preHold = hold;
        }
        return cash;
    }

}
