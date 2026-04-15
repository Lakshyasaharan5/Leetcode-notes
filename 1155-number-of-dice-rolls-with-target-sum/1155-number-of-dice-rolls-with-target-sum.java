class Solution {
    Integer[][] dp;
    public int numRollsToTarget(int n, int k, int target) {
        dp = new Integer[n + 1][target + 1];
        return dfs(n, k, target);
    }

    private int dfs(int n, int k, int target) {        
        if (n == 0 && target == 0) return 1;
        if (target < 0 || n == 0) return 0;
        if (dp[n][target] != null) return dp[n][target];
        int curr = 0;
        for (int i = 1; i <= k; i++) {
            curr = (curr + dfs(n - 1, k, target - i))  % 1_000_000_007;
        }
        return dp[n][target] = curr;
    }
}