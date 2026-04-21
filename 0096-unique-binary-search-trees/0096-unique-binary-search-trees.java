class Solution {
    Integer[] dp;
    public int numTrees(int n) {
        dp = new Integer[n + 1];
        return dfs(n);
    }

    private int dfs(int n) {
        if (n < 2) return 1;
        if (dp[n] != null) return dp[n];
        int curr = 0;
        for (int k = 1; k <= n; k++) {
            curr += dfs(k - 1) * dfs(n - k);
        }
        return dp[n] = curr;
    }
}