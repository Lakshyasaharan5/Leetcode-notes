class Solution {
    Integer[] dp;
    public int climbStairs(int n) {
        //            0
        //          /   \
        //         1     2
        //       /   \
        //      2     3 
        //     / \
        //    3   4 
        dp = new Integer[n + 1];
        return dfs(n, 0);
    }

    private int dfs(int n, int i) {
        if (i > n) return 0;
        if (i == n) return 1;
        if (dp[i] != null) return dp[i];
        return dp[i] = dfs(n, i + 1) + dfs(n, i + 2);
    }
}