class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        return dfs(n, dp);
    }

    private int dfs(int n, int[] dp) {
        if (n == 0) return 0;
        if (dp[n] != 0) return dp[n];
        int curr = n;
        for (int i = 1; i * i <= n; i++) {
            curr = Math.min(curr, dfs(n - i * i, dp));
        }
        return dp[n] = curr + 1;
    }
}