class Solution {
    /**
        [1 3 4]
               i
        -1           []
     +3   -1       -3   []
   -4  0  +4 -1   +4 -3  -4 []

   if (bought):
        sell = dfs() + price[i]        
    else:
        buy = dfs() - price[i]
        
    skip = dfs()

    return max(buy, sell, skip)
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[2][prices.length];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        return dfs(prices, 0, 0, dp);
    }

    private int dfs(int[] prices, int i, int bought, int[][] dp) {
        if (i >= prices.length) return 0;
        if (dp[bought][i] != -1) return dp[bought][i];
        int buy = 0, skip = 0, sell = 0;
        if (bought == 1) {
            sell = dfs(prices, i + 1, 0, dp) + prices[i];
        } else {
            buy = dfs(prices, i + 1, 1, dp) - prices[i];
        }
        skip = dfs(prices, i + 1, bought, dp);

        return dp[bought][i] = Math.max(skip, Math.max(buy, sell));
    }
}