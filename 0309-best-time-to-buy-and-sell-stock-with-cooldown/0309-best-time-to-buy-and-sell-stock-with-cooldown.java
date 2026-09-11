class Solution {
    /**
        [1,2,3,0,2]
         i

         if not bougth:
            buy = (i + 1, isBought = true) - prices[i]            

         else bought:
            sell = (i + 2, isBought = false) + prices[i]
        
        skip = (i + 1, isBought)

        return max(buy, sell, skip)
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[2][prices.length];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        return dfs(prices, 0, 0, dp);
    }

    private int dfs(int[] prices, int i, int isBought, int[][] dp) {
        if (i >= prices.length) {
            return 0;
        }
        if (dp[isBought][i] != -1) return dp[isBought][i];
        int buy = 0, sell = 0;
        if (isBought == 0) {
            buy = dfs(prices, i + 1, 1, dp) - prices[i];
        } else {
            sell = dfs(prices, i + 2, 0, dp) + prices[i];
        }
        int skip = dfs(prices, i + 1, isBought, dp);

        return dp[isBought][i] = Math.max(skip, Math.max(buy, sell));
    }
}