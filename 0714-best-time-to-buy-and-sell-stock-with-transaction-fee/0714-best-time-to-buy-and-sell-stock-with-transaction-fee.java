class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices, int fee) {
        dp = new Integer[prices.length][2];
        return dfs(prices, fee, 0, 0);
    }

    private int dfs(int[] prices, int fee, int i, int bought) {
        if (i == prices.length) return 0;
        if (dp[i][bought] != null) return dp[i][bought];
        int a = 0, b = 0;
        if (bought == 0) {
            a = -prices[i] + dfs(prices, fee, i + 1, 1);
            b = dfs(prices, fee, i + 1, 0);
        } else {
            a = prices[i] + dfs(prices, fee, i + 1, 0) - fee;
            b = dfs(prices, fee, i + 1, 1);
        }        
        return dp[i][bought] = Math.max(a, b);
    }
}