class Solution {
    public int maxProfit(int[] prices) {
        // 7,1,5,3,6,4
        //     ^
        int currMin = prices[0];
        int profit = 0;
        for (int price : prices) {
            if (currMin <= price) {
                profit = Math.max(profit, price - currMin);
            } else {
                currMin = price;
            }
        }
        return profit;
    }
}