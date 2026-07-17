class Solution {
    private Integer[] dp;
    private static final int MOD = 1_000_000_007;

    public int countHousePlacements(int n) {
        dp = new Integer[n];

        int oneSide = dfs(0, n);

        return (int) ((long) oneSide * oneSide % MOD);
    }

    private int dfs(int i, int n) {
        if (i >= n) {
            return 1;
        }

        if (dp[i] != null) {
            return dp[i];
        }

        long skip = dfs(i + 1, n);
        long place = dfs(i + 2, n);

        return dp[i] = (int) ((skip + place) % MOD);
    }
}