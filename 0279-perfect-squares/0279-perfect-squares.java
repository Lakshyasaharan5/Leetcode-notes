class Solution {
    Integer[][] dp;
    public int numSquares(int n) {
        int maxI = (int) Math.sqrt(n);
        dp = new Integer[n + 1][maxI + 2];
        return dfs(n, 1);
    }

    private int dfs(int n, int i) {
        if (n == 0) return 0;
        if (dp[n][i] != null) return dp[n][i];
        int curr = n;
        int initial_i = i;
        while (i * i <= n) {
            curr = Math.min(curr, dfs(n - i * i, i));
            i++;
        }
        return dp[n][initial_i] = curr + 1;
    }
}