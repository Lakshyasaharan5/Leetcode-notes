class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // dp[0] = 0 by default
        for (int i = 1; i <= n; i++) {
            int curr = i;
            for (int j = 1; j * j <= i; j++) {
                int cand = dp[i - j * j];
                if (cand < curr) curr = cand;
            }
            dp[i] = curr + 1;
        }
        return dp[n];
    }
}