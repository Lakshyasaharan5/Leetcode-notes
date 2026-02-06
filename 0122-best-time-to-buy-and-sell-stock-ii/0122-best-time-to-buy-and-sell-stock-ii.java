class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0], profit = 0, p=0;
        for (int i = 1; i < prices.length; i++) {
            p = prices[i];
            if (p > buy) {
                profit += p - buy;
                buy = p;
            } else {
                buy = p;
            }            
        }
        return profit;
    }
}