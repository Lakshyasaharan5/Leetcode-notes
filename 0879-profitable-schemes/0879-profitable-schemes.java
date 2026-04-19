class Solution {
    Integer[][][] dp;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        dp = new Integer[n + 1][minProfit + 1][group.length];
        return dfs(n, minProfit, 0, group, profit);
    }

    private int dfs(int n, int p, int i, int[] group, int[] profit) {        
        if (n < 0) return 0;
        if (i == group.length) return p == 0 ? 1 : 0;
        if (dp[n][p][i] != null) return dp[n][p][i];
        int curr = (dfs(n - group[i], Math.max(0, p - profit[i]), i + 1, group, profit) + dfs(n, p, i + 1, group, profit)) % 1000000007;        
        return dp[n][p][i] = curr;
    }
}