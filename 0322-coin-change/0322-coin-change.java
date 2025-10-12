class Solution {
    int[] dp = new int[10001];
    public int coinChange(int[] coins, int amount) {
    //     1,2,5   amount = 0.5
    //     / |  \
    //    1  2  5
    //  / | \
    // 1  2  5
        int res = backtrack(coins, amount);
        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }

    private int backtrack(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        if (dp[amount] > 0) return dp[amount];
        int curr = Integer.MAX_VALUE - 1;
        for (int i=0; i<coins.length; i++) {
            curr = Math.min(curr, backtrack(coins, amount - coins[i]));
        }
        return dp[amount] = curr + 1;
    }
}