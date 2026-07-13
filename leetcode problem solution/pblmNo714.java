//714. Best Time to Buy and Sell Stock with Transaction Fee
public class pblmNo714 {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0;            // not holding
        int hold = -prices[0];   // holding
        for (int i = 1; i < prices.length; i++) {
            int prevCash = cash;
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, prevCash - prices[i]);
        }
    return cash;
    }
}
