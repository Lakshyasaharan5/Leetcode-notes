class Solution {
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        dp = new Integer[coins.length][amount + 1];
        return dfs(amount, coins, 0);
    }

    private int dfs(int amount, int[] coins, int start) {
        if (amount < 0) return 0;
        if (amount == 0) return 1;
        if (dp[start][amount] != null) return dp[start][amount];
        int curr = 0;
        for (int i = start; i < coins.length; i++) {
            curr += dfs(amount - coins[i], coins, i);
        }
        return dp[start][amount] = curr;
    }
}